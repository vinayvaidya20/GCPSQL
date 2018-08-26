FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=./target/gcp-demo-0.0.8-SNAPSHOT.jar
ADD ${JAR_FILE} demo7.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo7.jar"]
