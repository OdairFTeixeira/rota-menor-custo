FROM openjdk:21-jdk
ENV MAVEN_VERSION 3.6.3
WORKDIR /app
COPY . .
RUN chmod +x /app/mvnw
RUN ./mvnw clean install
EXPOSE 8080
CMD ["java", "-jar", "target/dijikstra.jar"]