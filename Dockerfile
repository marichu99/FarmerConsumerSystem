# Use a base image with Maven for building and WildFly for runtime
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the POM file to the container
COPY pom.xml .

# Download the dependencies and plugins
RUN mvn dependency:go-offline

# Copy the source code to the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use the official WildFly base image for runtime
FROM jboss/wildfly:latest

# Set environment variables
ENV WILDFLY_USER=mabera \
    WILDFLY_PASSWORD=mabera

# Copy the .war file from the build stage to the WildFly deployment directory
COPY --from=build /app/target/farmer-system-app.war /opt/jboss/wildfly/standalone/deployments/

# Expose the ports needed by WildFly
EXPOSE 8080 9990

# Start WildFly in standalone mode
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
