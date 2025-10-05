#  API Tasklist

Este é o backend de uma aplicação de gerenciamento de tarefas (To-Do List), desenvolvido com **Spring Boot**. A API permite criar, listar, atualizar e deletar tarefas, funcionando como base para o frontend Angular que consome esses dados.

##  Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Postgresql
- Maven

##  Estrutura do projeto

- `model/Task.java`: representa a entidade de tarefa
- `repositories/TaskRepository.java`: interface de acesso ao banco de dados
- `services/TaskService.java`: camada de lógica de negócio
- `controller/TaskController.java`: endpoints REST da API

## 📡 Endpoints principais

| Método | Rota                     | Descrição                  |
|--------|--------------------------|----------------------------|
| GET    | `/api/tarefas`           | Lista todas as tarefas     |
| POST   | `/api/tarefas`           | Cria uma nova tarefa       |
| PUT    | `/api/tarefas/{id}`      | Atualiza uma tarefa        |
| DELETE | `/api/tarefas/{id}`      | Remove uma tarefa          |

## 🛠️ Como rodar localmente

1. Clone o repositório:

```bash
git clone https://github.com/andregattdev/api-Tasklist.git


