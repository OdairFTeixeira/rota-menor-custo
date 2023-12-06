FROM openjdk:21-jdk
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "dijikstra.jar"]