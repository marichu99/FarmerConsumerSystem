FROM maven:3.9.5-eclipse-temurin-17-alpine AS build
LABEL authors=" "


WORKDIR /app

COPY . .

RUN curl -o mysql-connector-java-8.0.17.jar https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.17/mysql-connector-java-8.0.17.jar

RUN mvn clean install -DskipTests -X

RUN mvn compile package


FROM quay.io/wildfly/wildfly:26.1.3.Final-jdk11 AS deploy

RUN rm /opt/jboss/wildfly/standalone/configuration/standalone.xml
RUN rm -rf /opt/jboss/wildfly/standalone/deployments
RUN mkdir -p /opt/jboss/wildfly/standalone/deployments



COPY --from=build /app/target/*.war /opt/jboss/wildfly/standalone/deployments/
COPY --from=build /app/standalone.xml /opt/jboss/wildfly/standalone/configuration/


RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
COPY --from=build /app/mysql/main/module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
COPY --from=build /app/mysql/main/mysql-connector-java-8.0.17.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]