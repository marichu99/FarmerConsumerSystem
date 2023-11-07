# Use an official Maven runtime as a parent image
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and src files to the container
COPY pom.xml .
COPY src ./src

# Build the Maven project and package it as a JAR file
RUN mvn package

# Use a lightweight Alpine-based image for the final runtime image
FROM openjdk:11-jre-slim

# Set the working directory for the runtime image
WORKDIR /app

# Copy the WAR file from the build image to the runtime image
COPY --from=build /app/target/farmer-system-app.war ./farmer-system-app.war

# Specify the command to run your Java application
CMD ["mvn", "clean compile package wildfly:deploy"]
