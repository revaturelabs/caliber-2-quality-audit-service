FROM java:8
COPY target/LocationService-0.0.1-SNAPSHOT.jar /tmp/LocationService-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/tmp/LocationService-0.0.1-SNAPSHOT.jar","--server.servlet.context-path=/location","&"]
