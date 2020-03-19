FROM openjdk:11-jdk
ADD target/quiz-app-0.0.1-SNAPSHOT.war target/quiz-app-0.0.1-SNAPSHOT.war
EXPOSE 8082
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","target/quiz-app-0.0.1-SNAPSHOT.war"]