FROM openjdk:17
ARG FILE_JAR=target/*.jar
ADD ${FILE_JAR} api-server.jar
ENTRYPOINT ["java", "-jar", "api-server.jar"]
EXPOSE 80