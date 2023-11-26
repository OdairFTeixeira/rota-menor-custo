FROM openjdk:21-jdk
VOLUME /tmp
COPY ./dijikstra-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080