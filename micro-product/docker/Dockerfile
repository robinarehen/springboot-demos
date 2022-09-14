FROM openjdk:11-jre-slim

RUN mkdir micro-product-app

EXPOSE 8080

COPY ./*.jar micro-product-app/product-app.jar

CMD java -jar micro-product-app/product-app.jar