FROM alpine:latest
RUN apk --update add openjdk17
RUN apk upgrade
RUN apk --no-cache add curl
RUN rm -rf /var/cache/apk/*
COPY ./target/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8080