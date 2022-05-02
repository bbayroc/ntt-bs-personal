FROM amazoncorretto:11-alpine-jdk
MAINTAINER bayro
#target/Personal-0.0.1-SNAPSHOT.jar Personal.jar
COPY target/Personal-0.0.1-SNAPSHOT.jar /Personal.jar
ENTRYPOINT ["java","-jar","/Personal.jar"]

