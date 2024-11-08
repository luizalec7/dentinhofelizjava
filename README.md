# Dentinho Feliz - SPRINT 2

Dentinho Feliz - Um aplicativo voltado para conscientização sobre higiene bucal infantil, utilizando gamificação para ensinar boas práticas às crianças de até 14 anos.

# 1. Integrantes do Grupo

    Guilherme Augusto de Oliveira (RM554176)
    Responsável pela implementação da lógica de pontuação e quizzes no aplicativo.

    Luiz Alecsander Viana (RM553034)
    Responsável pela estruturação do backend utilizando Java e integração com banco de dados, além da criação da API REST.

    Lucas Martinez Lopes (RM553816)
    Responsável pelo design do front-end e pela implementação das telas e fluxo de navegação do aplicativo.

# 2. Instruções para rodar a aplicação

Pré-requisitos:

    JDK 8+

    Maven

    Banco de Dados MySQL

    IDE (IntelliJ, Eclipse, etc.)

`Passos:`

`1. Clone este repositório: git clone https://github.com/luizalec7/dentinhofeliz.git`


`2. Navegue até a pasta do projeto: cd dentinhofeliz`


`3. Configure o arquivo application.properties com as credenciais do seu banco de dados MySQL.`


`4. Rode o Maven para compilar o projeto: mvn clean install`


`5. Execute a aplicação: mvn spring-boot:run`
   

`6. Acesse a API em: http://localhost:8080`


# 3. Diagramas

### Diagrama de Entidades:

Entidades

- **Usuario**
    - `id` (PK)
    - `nome`
    - `email`

- **Quiz**
    - `id` (PK)
    - `pergunta`
    - `respostaCorreta`

- **Alarme**
    - `id` (PK)
    - `hora`

- **Resposta**
    - `id` (PK)
    - `respostaUsuario`
    - `correta`
    - `usuario_id` (FK para `Usuario.id`)
    - `quiz_id` (FK para `Quiz.id`)

Relações no Diagrama

- **Usuario** ↔ **Resposta**: 1:N
- **Quiz** ↔ **Resposta**: 1:N
- **Usuario** ↔ **Alarme**: 1:N (já existente)


### Diagrama de Casos de Uso:

![img.png](img.png)

# 4. Link para Vídeo

Acesse o vídeo de apresentação da proposta tecnológica, o público-alvo e os problemas que o aplicativo Dentinho Feliz resolve através do link abaixo:
[https://youtu.be/tC7rbQUxJx8](https://youtu.be/tC7rbQUxJx8)

# 5. Endpoints
AlarmeController

Prefixo: /api/alarmes

    GET /api/alarmes
    Retorna a lista de todos os alarmes cadastrados.

    POST /api/alarmes
    Cria um novo alarme.
    Request body: JSON com os dados do AlarmeDTO.

QuizController

Prefixo: /api/quizzes

    GET /api/quizzes
    Retorna a lista de todos os quizzes cadastrados.

    POST /api/quizzes
    Cria um novo quiz.
    Request body: JSON com os dados do QuizDTO.

UsuarioController

Prefixo: /api/usuarios

    GET /api/usuarios
    Retorna a lista de todos os usuários cadastrados.

    POST /api/usuarios
    Cria um novo usuário.
    Request body: JSON com os dados do UsuarioDTO.
    Validação: O corpo da requisição deve estar de acordo com a validação (@Valid).

RespostaController

Prefixo: /api/respostas

    POST /api/respostas
    Cria uma nova resposta.
    Request body: JSON com os dados do RespostaDTO.

    GET /api/respostas/usuario/{usuarioId}
    Retorna a lista de respostas de um usuário específico.

## 6. Cronograma para Próximas Sprints

| Sprint  | Atividade                                                                                               | Responsável                   | Prazo Estimado     |
|---------|---------------------------------------------------------------------------------------------------------|-------------------------------|--------------------|
| Sprint 2 | Implementar o armazenamento de respostas do usuário aos quizzes                                         | Luiz Alecsander Viana         | Concluído          |
| Sprint 2 | Atualizar diagramas de entidade e classe                                                               | Lucas Martinez Lopes          | Concluído          |
| Sprint 2 | Configurar endpoints e DTOs para a entidade `Resposta`                                                 | Luiz Alecsander Viana         | Concluído          |
| Sprint 3 | Adicionar testes unitários para todas as entidades e serviços                                         | Toda a equipe                 | Próximo Semestre   |
| Sprint 3 | Implementar lógica de pontuação baseada nas respostas e no tempo de resposta                           | Guilherme Augusto de Oliveira | Próximo Semestre   |
| Sprint 3 | Criar sistema de autenticação para o acesso ao aplicativo                                              | Luiz Alecsander Viana         | Próximo Semestre   |
| Sprint 3 | Melhorar a interface do usuário e implementar feedback visual para respostas corretas/incorretas       | Lucas Martinez Lopes          | Próximo Semestre   |
| Sprint 4 | Realizar integração com serviços de notificação para lembretes de escovação                            | Toda a equipe                 | Último Semestre    |
| Sprint 4 | Otimizar o desempenho do backend e refatorar código para escalabilidade                                | Luiz Alecsander Viana         | Último Semestre |
| Sprint 4 | Validar dados e melhorar segurança com validações adicionais e tratamento de erros                    | Toda a equipe                 | Último Semestre  |
