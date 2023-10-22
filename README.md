# insper-user

Este projeto contém a API para a criação de usuários e a autenticação desses usuários na plataforma. A API contém as seguintes rotas:

## POST /user 

Cria novo usuário - Autenticada 

```json
{
"email": "admin@sa.com",
"password": "123456"
}
```

Header:
token: {token}

## GET /user

Lista usuários - Autenticada 

Header:
token: {token}

## POST /login 

Cria o token de autenticação para um usuário - Aberta


## GET /token

Verifica se um token existe na aplicação - Autenticada -> Se o token existe retorna 200 e as informações do usuário,
se o token não existe retorna um erro 401

Header:
token: {token}

