# DockerFile for the building and running the application
# Use a base image with Maven for building and WildFly for runtime
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the POM file to the container
COPY pom.xml .

# Download the dependencies and plugins
RUN mvn dependency:go-offline

# Copy the source code to the container
COPY . .

# Build the application
RUN mvn package -DskipTests

# Dockerfile for setting up the mysql database
# Use an official MySQL image as a base image
FROM mysql:latest

# Set the environment variables
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=mabera
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root

# Copy the SQL script to initialize the database
COPY init.sql /docker-entrypoint-initdb.d/
# Use the official WildFly base image for runtime
FROM jboss/wildfly:latest as deploy

# Set environment variables
ENV WILDFLY_USER=mabera \
    WILDFLY_PASSWORD=mabera

# Copy the .war file from the build stage to the WildFly deployment directory
COPY --from=build /app/target/farmer-system-app.war /opt/jboss/wildfly/standalone/deployments/

# Remove the standalone.xml file from the wildfly deployments directory
RUN rm /opt/jboss/wildfly/standalone/configuration/standalone.xml

# create the main in the container
# RUN mkdir /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main

# Copy the mysql connector and the modules.xml to the newly created directory
COPY --from=build /app/mysql /opt/jboss/wildfly/modules/system/layers/base/com/
COPY --from=build /app/mysql-connector-java-8.0.17.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/

# Copy the Standalone.xml file tp the Wildfly deployment directory
COPY --from=build /app/standalone.xml /opt/jboss/wildfly/standalone/configuration/

# Expose the ports needed by WildFly
EXPOSE 8080 9990

# Start WildFly in standalone mode
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]


