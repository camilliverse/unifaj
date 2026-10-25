# Exercício 5 – JDBC + DAO – Plano de Saúde

Aluno: SEU NOME | RA: SEU RA   (troque também em src/main/resources/static/js/common.js)

## Como executar
    mvn spring-boot:run
Abra http://localhost:8080/index.html

## Classes escolhidas
- Paciente  -> PacienteDAO / PacienteService (/pacientes)
- Médico    -> MedicoDAO   / MedicoService   (/medicos)

## Arquitetura
HTML + fetch -> @RestController (Service) -> DAO (JDBC puro: Connection, PreparedStatement, ResultSet) -> Banco
Sem JPA/Hibernate/Spring Data. Banco H2 em arquivo (./data/planosaude), tabelas criadas pelo ConnectionFactory.
Para MySQL/PostgreSQL: troque o driver no pom.xml e URL/USER/PASSWORD em ConnectionFactory.
