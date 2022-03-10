FROM openjdk:latest
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} UserService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app.jar"]