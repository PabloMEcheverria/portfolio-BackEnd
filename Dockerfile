FROM amazoncorretto:11-alpine-jdk
MAINTAINER Pablo Martin Echeverria
COPY target/SpringBoot-0.0.1-SNAPSHOT.jar  portfolio-app.jar
ENTRYPOINT ["java","-jar","/portfolio-app.jar"]