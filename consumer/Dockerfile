FROM eclipse-temurin:21-jdk-jammy
#EXPOSE 8080
ADD ./target/*.jar /app/consumer.jar
ENTRYPOINT exec java $JAVA_OPT -jar /app/consumer.jar
WORKDIR /opt
