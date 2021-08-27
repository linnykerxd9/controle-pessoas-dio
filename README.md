## Sistema de cadastro/gerenciamento de pessoas em API REST com Spring Boot

Projeto desenvolvido na DIO(Digital Innovation One) no botcamp do santander para criação de uma API REST para cadastro de pessoas usando o spring boot.



#### Tecnologias usadas nesse projeto

- Lombok
- Spring boot
- JPA

- h2 database
- Map struct
- Heroku
- Maven



Para executar o projeto no terminal, digite o seguinte comando:

```
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/people
```

Ou use a API hospedada no heroku:

```
https://person-api-dioo.herokuapp.com/api/v1/people
```

Use o "/:id" caso queira deletar,atualizar ou recuperar os dados de uma pessoa específica pelo ID

Exemplo:

```
https://person-api-dioo.herokuapp.com/api/v1/people/1
```