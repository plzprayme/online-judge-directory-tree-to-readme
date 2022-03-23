FROM eclipse-temurin:17-jdk-alpine

RUN ls

RUN chmod +x gradlew
RUN ./gradlew build
COPY build/libs/readme-generator-1.0-SNAPSHOT.jar /github/workspace/application.jar
RUN chmod +x /github/workspace/application.jar

COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]