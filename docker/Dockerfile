FROM openjdk:8-jre-alpine
WORKDIR arkitik-io
COPY app-spring-boot.jar app.jar
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n","-Djava.security.egd=file:/dev/./urandom","-Xms2g","-Xmx8g","-jar","app.jar"]
