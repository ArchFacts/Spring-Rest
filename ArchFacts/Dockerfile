FROM maven:3.8.6-openjdk-17-slim as builder

LABEL maintainer="ArchFacts Team"

WORKDIR /ArchFacts

# Instalação das dependências do projeto no pom e cache para acelerar builds
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline -B

# Copiando os arquivos para criar o build
COPY src ./src

#Buildando a imagem com .JAR
RUN mvn clean package -DskipTests
RUN mkdir -p /ArchFacts/build && find target/ -name '*.jar' -exec mv {} /ArchFacts/build/ArchFacts.jar \;

#Utilizando JDK slim para fazer o build da imagem mais leve
FROM openjdk:17-jre-slim
WORKDIR /ArchFacts
COPY --from=builder /ArchFacts/build/ArchFacts.jar .

#RUN apt-get update && apt-get install -y default-mysql-client && rm -rf /var/lib/apt/lists*

RUN apt-get update
RUN apt-get install -y default-mysql-client
RUN rm -rf /var/lib/apt/lists*

COPY config_banco.sh /usr/local/bin

COPY Dump20250422.sql /app/schema.sql

RUN chmod +x /usr/local/bin/config_banco.sh

EXPOSE 8080

ENTRYPOINT [ "/usr/local/bin/config_banco.sh" ]

CMD ["java", "-jar", "ArchFacts.jar"]