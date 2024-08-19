FROM eclipse-temurin:21-jdk-jammy
#EXPOSE 8080
ADD ./target/*.jar /app/producer.jar
ENTRYPOINT exec java $JAVA_OPT -jar /app/producer.jar
WORKDIR /opt