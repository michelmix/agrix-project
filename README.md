# Agrix - Sistema de Gestão e Monitoramento de Fazendas
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/michelmix/project-agrix/blob/main/LICENSE) 

# Sobre o projeto

O Agrix é uma aplicação back-end web desenvolvido em Java utilizando Spring, que permite a gestão e o monitoramento de fazendas. 
Este projeto implementa uma API RESTful e aplica diversos conceitos e tecnologias do ecossistema Spring para criar uma API robusta e segura.

## Modelo conceitual
<img src="https://github.com/michelmix/agrix-project/blob/main/images/agrix-tabelas-fase-b.png" width=600>

## Funcionalidades

- Gestão de fazendas: Cadastra, atualize e remove informações sobre fazendas.
- Monitoramento: Acompanha dados importantes sobre as fazendas.
- Autenticação: Utiliza o Spring Security para garantir que apenas usuários autorizados tenham acesso ao sistema.
- Autorização: Define diferentes níveis de autorização para garantir que cada rota atenda a regras específicas de segurança.

## Tecnologias Utilizadas

- **Spring Boot**: Facilita a criação de aplicações Java autônomas e com configurações mínimas.
- **Spring Web**: Crie rotas da API de forma simples e eficaz.
- **Spring Data JPA/Hibernate**: Implementa entidades e repositórios para a persistência em banco de dados de forma eficiente.
- **Spring Security**: Adiciona autenticação ao projeto e defina regras de autorização.
- **Docker**: Configura a aplicação para execução em containers Docker.
- **JUnit**: Desenvolve testes unitários para garantir a qualidade do código.
- **Maven**: Gerenciamento de dependências

## Iniciando

Certifique-se de ter o Docker instalado para simplificar a execução do Agrix.

### Executando com Docker

1. Clone este repositório:

```
git clone git@github.com:michelmix/agrix-project.git
cd agrix
```

2. Construa a imagem Docker:
```
docker build -t agrix .
```

3. Execute o contêiner Docker:
```
docker run -p 8080:8080 agrix
```

Agora, o Agrix estará disponível em http://localhost:8080.

Configurações
Antes de executar o projeto, você pode configurar as propriedades do banco de dados em application.properties para atender às suas necessidades.

Testes
Certifique-se de que o projeto esteja em execução e execute os testes unitários para garantir que tudo funcione conforme o esperado:
```
./mvnw test
```

---

**Nota:** Este é um projeto fictício criado apenas para fins de demonstração e aprendizado. Não se destina a ser usado em produção, mas sim como um exemplo de como aplicar tecnologias Spring em um projeto Java.

# Autor

Michel Arantes Barbosa

https://www.linkedin.com/in/michel-barbosa-dev/
