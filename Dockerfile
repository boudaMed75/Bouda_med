FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests 

FROM maven:3.8.3-openjdk-17-slim
COPY --from=build /target/company-0.0.1-SNAPSHOT.jar bouda.jar

EXPOSE 8080
ENTRYPOINT [ "java","-jar","bouda.jar" ]

