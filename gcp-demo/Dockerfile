FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=./target/gcp-demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo.jar"]