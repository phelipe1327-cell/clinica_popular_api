# Clínica Popular API (ODONTOLOGIA)

## ALUNO
Phelipe Damasio de Andrade Silva

## Descrição
API desenvolvida para o controle de uma clínica popular com foco em odontologia utilizando Java 17 e SpringBoot.

## Tecnologias utilizadas 
- Java 17
- Spring Boot 4.0.6
- PostgreSQL
- Spring Data JPA
- Maven
- Swagger 

## Como rodar o projeto

### Deve possuir
- Java 17 instalado
- PostgreSQL instalado
- Maven instalado

### Passo-a-Passo
- Clone o repositório
- Crie o banco de dados no PostgreSQL:
   CREATE DATABASE clinica_popular;
- Configure o arquivo `application.properties` com sua senha do PostgreSQL
- Roda o projeto pelo IntelliJ
- Acesse o Swagger com o link: `http://localhost:8080/swagger-ui.html`
- Utilize os Endpoints no Postman ex: http://localhost:8080/pacientes

## 📦 Entidades
- Paciente = dados pessoais do paciente
- Prontuario = histórico médico do paciente
- Dentista = dados do dentista
- Especialidade = especialidades odontológicas
- Consulta = agendamento de consultas

## Relacionamentos
- Paciente 1/1 Prontuario - OneToOne
- Dentista N/N Especialidade - ManyToMany
- Paciente/Dentista N/1 Consulta - ManyToOne

## Endpoints
- Confira acessando o swagger
- Roda o projeto, abra seu navegador e utilize este link http://localhost:8080/swagger-ui.html

### Como usar
- Exemplo de uso
- Criar Paciente

POST /pacientes
{
    "nome": "CLEITIN",
    "cpf": "12345678910",
    "telefone": "2145987645",
    "email": "cleitin@email.com",
    "dataNascimento": "2008-04-20"
}
