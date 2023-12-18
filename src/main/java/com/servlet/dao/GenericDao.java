package com.servlet.dao;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.model.entity.AuditLog;
import com.servlet.utils.GlobalBean;
import com.servlet.view.enums.UserAction;
import com.servlet.view.html.annotation.AuthFormsAnnot;

@SuppressWarnings({ "unchecked" })
public class GenericDao<T> implements GenericDaoI<T> {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private Event<AuditLog> logger;

    @Inject
    GlobalBean globalBean;

    @Override
    public List<T> list(T entity) {
        Class<?> clazz = entity.getClass();

        String simpleName = entity.getClass().getSimpleName();

        String tAlias = (simpleName.charAt(0) + "_").toLowerCase();
        String jpql = "FROM " + entity.getClass().getSimpleName() + " " + tAlias;

        StringBuilder whereClause = new StringBuilder();
        Map<String, Object> whereParams = new HashMap<>();

        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        for (Field field : fields) {
            if (!field.isAnnotationPresent(Column.class))
                continue;

            Column column = field.getAnnotation(Column.class);

            field.setAccessible(true);

            try {
                if (field.get(entity) != null) {
                    // get the numeric fields and check if they are zero
                    if(field.getType().isAssignableFrom(Double.class)){
                        if((Double)field.get(entity) == 0.0){
                            continue;
                        }
                    }else if(field.getType().isAssignableFrom(int.class)){
                        if((int)field.get(entity) == 0){
                            continue;
                        }
                    }
                    System.out.println(field.getName()+" is not null");
                    System.out.println("the value is "+field.get(entity));
                    String colName = StringUtils.isEmpty(column.name()) ? field.getName() : column.name();
                    

                    // convert the value to enum if needed
                    if (!field.isAnnotationPresent(AuthFormsAnnot.class)) {
                        whereClause
                                .append(whereParams.isEmpty() ? "" : " AND ")
                                .append(tAlias).append(".").append(colName).append("=:").append(colName);

                        whereParams.put(colName, field.get(entity));
                    }
                }

            } catch (IllegalAccessException iEx) {
                iEx.printStackTrace();

            }
        }

        jpql = jpql + (whereParams.isEmpty() && StringUtils.isBlank(whereClause) ? "" : " WHERE " + whereClause);

        jpql = jpql.replace(", FROM", " FROM");
        System.out.println("jpql: " + jpql);

        TypedQuery<T> query = (TypedQuery<T>) em.createQuery(jpql, entity.getClass());

        for (Map.Entry<String, Object> entry : whereParams.entrySet()) {
            System.out.println("param Name: " + entry.getKey() + " = " + entry.getValue());
            query = query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();

    }

    @Override
    public void addOrUpdate(T entity) {
        // fire the logs that will register this event
        System.out.println("The current user's email is " + GlobalBean.getUserEmail());
        AuditLog auditLog = new AuditLog(GlobalBean.getUserEmail(), LocalDateTime.now(),
                UserAction.ADD_ITEM.getValue());
        logger.fire(auditLog);
        em.merge(entity);
    }

    @Override
    public void delete(T entity) {

        em.remove(em.contains(entity) ? entity : em.merge(entity));
        AuditLog auditLog = new AuditLog(GlobalBean.getUserEmail(),LocalDateTime.now(),UserAction.DELETE_ITEM.getValue());
        logger.fire(auditLog);
        // code to remove an object from the database
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<T> allElements(T entity) {
        // TODO Auto-generated method stub
        String tAlias = (entity.getClass().getSimpleName().charAt(0) + "_").toLowerCase();
        String jpql = "FROM " + entity.getClass().getSimpleName() + " " + tAlias;

        System.out.println("The jpql query ##"+jpql);

        return (List<T>) em.createQuery(jpql, entity.getClass()).getResultList();
    }
}
