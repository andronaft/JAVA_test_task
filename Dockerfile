FROM openjdk:16-slim
MAINTAINER javatask
COPY ./target/javatask-*.jar javatask-0.0.1.jar
ENTRYPOINT ["java","-jar","/javatask-0.0.1.jar"]