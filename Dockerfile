FROM openjdk:17-jdk-alpine3.14
WORKDIR /app
COPY ./target/*.jar /app/
CMD ["sh", "-c", "java -jar /app/config-serv-0.0.1-SNAPSHOT.jar"]