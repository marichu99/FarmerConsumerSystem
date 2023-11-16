package com.servlet.action.dashboard;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class BaseAction extends HttpServlet {

   
    @SuppressWarnings("unchecked")
    public <T> T serializeForm(Class<?> clazz, Map<String, ?> requestMap) {

        T clazzInstance;

        try {
            clazzInstance = (T) clazz.getDeclaredConstructor().newInstance();

            BeanUtils.populate(clazzInstance, requestMap);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e ) {
            throw new RuntimeException(e);
        }

        return clazzInstance;
    }

    public void renderPage(HttpServletRequest request, HttpServletResponse response, int activeMenu,
        String content)
            throws ServletException, IOException {

        request.setAttribute("activeMenu", activeMenu);       
            
        request.setAttribute("content", content);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./app/index.jsp");
        dispatcher.forward(request, response);
    }
}

  
    
