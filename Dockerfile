FROM java:8
COPY target/caliber-quality-audit-service-0.0.1-SNAPSHOT.jar /tmp/caliber-quality-audit-service-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/tmp/caliber-quality-audit-service-0.0.1-SNAPSHOT.jar","--server.context-path=/qa","&"]
