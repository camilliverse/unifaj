# Plano de Saude - Aula 3 / Exercicio 4 - JavaScript Fetch

Projeto Spring Boot + HTML/JavaScript (Fetch) para o tema **Plano de Saude**.

## Classes modeladas (2, conforme exigido)

- **Medico**: id, nome, crm, especialidade, telefone
- **Paciente**: id, nome, cpf, dataNascimento, telefone

Cada uma com CRUD completo: Listar, Incluir, Alterar, Excluir.

## IMPORTANTE - antes de entregar

Edite o arquivo `src/main/resources/static/js/aluno.js` e coloque o SEU
nome e o SEU RA nas variaveis `nome` e `ra`. Esse dado aparece automaticamente
no topo de TODAS as paginas (index e listagens), conforme exigido no enunciado.

## Como rodar

Pre-requisitos: Java 17+ e Maven (ou use o wrapper `mvnw` se adicionar um).

```bash
mvn spring-boot:run
```

A aplicacao sobe em `http://localhost:8080`.

Abra no navegador:

- `http://localhost:8080/index.html` -> pagina inicial
- `http://localhost:8080/medico-listar.html`
- `http://localhost:8080/paciente-listar.html`

Como as paginas HTML ficam dentro de `src/main/resources/static`, o proprio
Spring Boot ja serve o front-end (nao precisa de outro servidor). As paginas
consomem a API REST atraves do `fetch()`.

## Endpoints REST (Backend)

### Medico
- `GET    /api/medicos`       -> listar
- `GET    /api/medicos/{id}`  -> buscar por id
- `POST   /api/medicos`       -> incluir
- `PUT    /api/medicos/{id}`  -> alterar
- `DELETE /api/medicos/{id}`  -> excluir

### Paciente
- `GET    /api/pacientes`
- `GET    /api/pacientes/{id}`
- `POST   /api/pacientes`
- `PUT    /api/pacientes/{id}`
- `DELETE /api/pacientes/{id}`

## Banco de dados

Usa H2 em memoria (nao precisa instalar nada). Os dados sao perdidos ao
reiniciar a aplicacao. Console disponivel em `http://localhost:8080/h2-console`
(JDBC URL: `jdbc:h2:mem:planosaude`, usuario `sa`, senha em branco).

## Estrutura do projeto

```
src/main/java/com/planosaude/demo/
  model/         -> Medico.java, Paciente.java (entidades JPA)
  repository/    -> MedicoRepository.java, PacienteRepository.java
  service/       -> MedicoService.java, PacienteService.java
  controller/    -> MedicoController.java, PacienteController.java (REST)
  config/        -> CorsConfig.java

src/main/resources/
  application.properties
  static/
    index.html
    medico-listar.html / medico-incluir.html / medico-alterar.html / medico-excluir.html
    paciente-listar.html / paciente-incluir.html / paciente-alterar.html / paciente-excluir.html
    css/style.css
    js/aluno.js   -> NOME e RA (editar aqui)
    js/api.js     -> URL base da API
    js/medico.js  -> funcoes fetch de Medico
    js/paciente.js-> funcoes fetch de Paciente
```

## Video explicativo (a gravar)

Sugestao de roteiro para o video (foco no Fetch, conforme pedido):
1. Mostrar a tela inicial com nome e RA.
2. Mostrar `medico-listar.html` e explicar a funcao `listarMedicos()` (GET) em `js/medico.js`.
3. Incluir um medico novo -> mostrar `incluirMedico()` (POST) e o Network do navegador (F12).
4. Alterar um medico -> mostrar `buscarMedicoPorId()` (GET) preenchendo o form e `alterarMedico()` (PUT).
5. Excluir um medico -> mostrar `excluirMedico()` (DELETE).
6. Repetir rapidamente para Paciente.
7. Mostrar o Controller no Spring Boot recebendo as requisicoes (endpoints REST).
