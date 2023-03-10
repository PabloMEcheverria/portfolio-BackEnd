FROM openjdk:8-jre-alpine
MAINTAINER Pablo Martin Echeverria
COPY target/SpringBoot-0.0.1-SNAPSHOT.jar Portfolio-backend
ENTRYPOINT ["java","-jar","/Portfolio-backend"]
