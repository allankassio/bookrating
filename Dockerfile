# Use an official Java 21 runtime as a parent image
FROM openjdk:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build artifact into the container at /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","/app/app.jar"]
