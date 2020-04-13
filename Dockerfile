FROM openjdk:8-jdk-alpine
VOLUME /tmp

ARG JAR_FILE=./bazel-bin/services/web-service/web-service-executable_deploy.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
