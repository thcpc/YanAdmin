FROM openjdk:11 as javaBuilder
RUN mkdir /app
WORKDIR /app
COPY . .
RUN sh gradlew wrapper
RUN sh gradlew build
ENTRYPOINT ["java", "-jar","out/libs/YanBackend-0.0.1-SNAPSHOT.jar"]