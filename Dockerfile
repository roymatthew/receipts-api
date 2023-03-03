FROM openjdk:17
EXPOSE 8080 8000
ADD target/receipts-api.jar receipts-api.jar
ADD entrypoint.sh entrypoint.sh
ENTRYPOINT ["sh", "/entrypoint.sh"]