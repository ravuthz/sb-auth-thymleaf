### BUILD a maven builder. This will contain all mvn dependencies and act as an abstraction for all mvn goals
FROM maven:openjdk:8-jdk-slim as builder

# create app folder for sources
RUN mkdir -p /build
RUN mkdir -p /build/logs

# The WORKDIR instruction sets the working directory for any RUN, CMD, ENTRYPOINT, COPY
# and ADD instructions that follow it in the Dockerfile.
WORKDIR /build
COPY pom.xml /build
# Download all required dependencies into one layer
RUN mvn dependency:resolve && mvn compile
RUN mvn spring-boot:run
