FROM maven:3.8.7-openjdk-18-slim AS MAVEN_BUILD

ARG outputJAR article-magick-api-1.0.jar

WORKDIR /

COPY . .

RUN mvn install

FROM eclipse-temurin:18-jre-alpine

COPY --from=MAVEN_BUILD /target/$outputJAR /$outputJAR

COPY --from=MAVEN_BUILD /src/main/resources/application.properties /application.properties

CMD ["java", "-jar", "/article-magick-api-1.0.jar"] 
