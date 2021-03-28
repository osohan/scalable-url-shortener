FROM fabric8/java-jboss-openjdk8-jdk:1.5.2
ENV JAVA_APP_DIR=/deployments
EXPOSE 8080
COPY target/demo-0.0.1-SNAPSHOT.jar /deployments/