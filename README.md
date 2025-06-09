![Logo da ArchFacts](/archfacts/src/utils/assets/logo.svg)
# App-Web
## ArchFacts - Frontend 

## Introdução
### ArchFacts é uma aplicação Web que proporciona uma interface intuitiva de um sistema de ERP para prestadores de serviço se organizarem com seus clientes e pessoalmente

## Descrição
O projeto é uma aplicação backend desenvolvida com Java Spring. Seu principal objetivo é fornecer a lógica de negócios, a API Restful e a camada de persistência de dados para o frontend. Ele gerencia todos os dados relacionados ao projeto, proposta, chamados, tarefas, eventos e garnate a segurança e integridade dos dados.

## Funcionalidades
* API REST: Uma API que aplica vários dos principios Rest com camadas de Serviços, Controles, DTOS e entidades.
* JPA: O ORM utilizado é o JPA, utilizado para fazer o mapeamento dos dados no banco para a API
* JWT SECURITY: Garante a segurança e integridade do usuário logado gerando um token JWT ao fazer o login.
* Padrões de Projeto: Aplica o conceito de Factory do padrão Strategy e também conceitos do padrão Observer para a funcionalidade de eventos

## Tecnologias Utilizadas
- Java 17
- SpringBoot

## Configurando o Ambiente de Desenvolvimento
### Requisitos
- JDK: Especificamente a versão 17
- Sistema de Gerenciamento de Banco de Dados (Originalmente foi utilizado o MySQL)

## Instalação
1. Clone o repositório 
```
git clone https://github.com/ArchFacts/Spring-Rest.git
```

2. Mova-se para o diretório
```
Spring-Rest/ArchFacts/src/main/java/Facts/Arch/ArchFacts/
```

3. Crie um banco de dados com todas as tabelas necessárias e modifique o arquivo aplicattion.properties com suas informações
```
spring.datasource.url=jdbc:mysql://localhost:5432/[nome_do_seu_banco_de_dados]
spring.datasource.username=[seu_usuario_do_banco]
spring.datasource.password=[sua_senha_do_banco]
spring.jpa.show-sql=true

# Outras configurações, como porta do servidor, segredo JWT, etc.
server.port=8080 # Porta padrão do Spring Boot
```

4. Faça o build do projeto utilizando o comando:
```
mvn clean install
```

5. Isso gerará um JAR do projeto, após isso, somente execute-o com:
```
java -jar target/nome-do-projeto.jar
```

OBS: É necessário ter o banco de dados e as tabelas já criadas, além de todas as configurações necessárias no application.properties para o funcionamento completo deste repositório
