FROM openjdk:17
EXPOSE 9911
ADD target/obp-transaction-service.jar obp-transaction-service.jar
ENTRYPOINT ["java", "-jar", "/obp-transaction-service.jar"]