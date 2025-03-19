# Étape 1 : Construction de l'application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copier uniquement pom.xml et télécharger les dépendances en avance (optimisation du cache Docker)
COPY pom.xml .
RUN mvn dependency:go-offline -DskipTests

# Copier le reste du projet et compiler
COPY . .
RUN mvn clean package -DskipTests 

# Étape 2 : Image finale avec une JRE légère
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copier uniquement le JAR compilé
COPY --from=build /app/target/company-0.0.1-SNAPSHOT.jar company.jar

# Exposer le port de l'application
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT [ "java", "-jar", "company.jar" ]
