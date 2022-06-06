FROM openjdk:11
EXPOSE 8080
RUN mkdir ./exchange-rates
ADD target/exchange-rates-0.0.1-SNAPSHOT.jar ./exchange-rates/exchange-rates.jar
RUN cd exchange-rates
ENTRYPOINT ["java", "-jar", "exchange-rates.jar"]