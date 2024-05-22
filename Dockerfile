FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 8002
ADD ./target/servicio-items.jar servicio-items.jar
ENTRYPOINT [ "java", "-jar", "/servicio-items.jar" ] 