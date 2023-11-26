# Use a imagem oficial do OpenJDK como imagem base
FROM openjdk:21-jdk

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o contêiner
COPY target/dijikstra-0.0.1.jar /app/app.jar

# Expõe a porta que a aplicação Spring Boot está escutando
EXPOSE 8080

# Configurações do banco de dados PostgreSQL
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/a3_menor_custo
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=postgres

# Adiciona o wait-for-it.sh para esperar até que o banco de dados esteja pronto antes de iniciar a aplicação
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Comando para esperar até que o banco de dados esteja pronto e, em seguida, iniciar a aplicação
CMD ["./wait-for-it.sh", "db:5432", "--", "java", "-jar", "app.jar"]