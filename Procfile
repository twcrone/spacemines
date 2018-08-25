release: ./mvnw flyway:clean flyway:migrate

web: java -Dserver.port=$PORT $JAVA_OPTS -jar target/*.jar