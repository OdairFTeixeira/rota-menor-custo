FROM openjdk:21-jdk
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_VERSION 3.6.3
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY . .
RUN mvn clean install
COPY ./target/dijikstra-0.0.1.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]