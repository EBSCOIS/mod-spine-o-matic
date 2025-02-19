# build base image
FROM maven:3-openjdk-11-slim as maven

# copy pom.xml
COPY ./pom.xml ./pom.xml

# copy src files
COPY ./src ./src

# build
RUN mvn package

# final base image
FROM openjdk:11-jre-slim

# set deployment directory
WORKDIR /mod-spine-o-matic

# copy over the built artifact from the maven image
COPY --from=maven /target/mod-spine-o-matic*.jar ./mod-spine-o-matic.jar

# Expose this port locally in the container.
EXPOSE 8081
