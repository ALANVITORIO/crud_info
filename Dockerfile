# Use a imagem oficial do Java para a imagem base
FROM openjdk:17-jdk-alpine

# Variável para armazenar o diretório do aplicativo dentro do contêiner
ARG APP_DIR=/usr/app

# Variável para armazenar o nome do arquivo JAR
ARG JAR_FILE=target/crud_info-0.0.1-SNAPSHOT.jar

# Cria o diretório do aplicativo dentro do contêiner
RUN mkdir -p ${APP_DIR}

# Copia o arquivo JAR para o diretório do aplicativo
COPY ${JAR_FILE} ${APP_DIR}/app.jar

# Muda o diretório de trabalho para o diretório do aplicativo
WORKDIR ${APP_DIR}

# Executa o aplicativo quando o contêiner é iniciado
ENTRYPOINT ["java", "-jar", "app.jar"]


