FROM openjdk:11-jdk
ADD target/quiz-app-0.0.1-SNAPSHOT.jar target/quiz-app-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","target/quiz-app-0.0.1-SNAPSHOT.jar"]
