FROM gradle:jdk11 AS builder
WORKDIR /build/
COPY . .
RUN gradle build

FROM openjdk:11-jre-alpine
WORKDIR /covidhub-api/
COPY --from=builder /build/libs/covid-hub-0.0.1-SNAPSHOT.jar /covidhub-api/
ENTRYPOINT ["java","-jar","covid-hub-0.0.1-SNAPSHOT.jar"]
