# ifood-clone

Projeto backend completo de um clone do iFood utilizando Java 21, Spring Boot e Clean Architecture.

## Sumário
- [Arquitetura](#arquitetura)
- [Como executar](#como-executar)
- [Exemplos de chamadas à API](#exemplos-de-chamadas-à-api)
- [Testes](#testes)

## Arquitetura
O projeto segue Clean Architecture, dividido em:
- **domain**: entidades e interfaces de repositório
- **application**: casos de uso (services)
- **infrastructure**: configurações, adaptadores, repositórios Spring Data JPA, banco H2
- **interfaces**: controllers REST

## Como executar
1. Requisitos: Java 21+ e Maven 3.8+
2. Execute:
   ```bash
   cd ifood-clone
   ./mvnw spring-boot:run
   ```
3. Acesse o Swagger em: http://localhost:8080/swagger-ui.html

## Exemplos de chamadas à API
- Cadastro de restaurante:
  ```json
  POST /restaurantes
  {
    "nome": "Restaurante Exemplo",
    "endereco": "Rua Exemplo, 123"
  }
  ```
- Listagem de restaurantes:
  ```
  GET /restaurantes
  ```
- Cadastro de prato:
  ```json
  POST /pratos
  {
    "nome": "Pizza",
    "preco": 39.90,
    "restauranteId": 1
  }
  ```
- Listagem de pratos por restaurante:
  ```
  GET /restaurantes/1/pratos
  ```
- Criação de pedido:
  ```json
  POST /pedidos
  {
    "pratosIds": [1,2],
    "valorTotal": 79.80
  }
  ```

## Testes
Execute:
```bash
./mvnw test
```

## Tecnologias
- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Swagger/OpenAPI
- ModelMapper
- Bean Validation
- JUnit 5, Mockito
