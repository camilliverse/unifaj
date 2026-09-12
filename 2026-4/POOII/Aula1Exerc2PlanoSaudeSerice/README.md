# Aula1Exerc2PlanoSaudeSerice

REST em Spring Boot para o "Plano de Saude" com duas entidades: **Medico** e **Beneficiario**.

> ⚠️ Antes de gravar o vídeo / entregar: edite `RA_ALUNO` e `NOME_ALUNO` em
> `src/main/java/com/planosaude/Aula1Exerc2PlanoSaudeSericeApplication.java`
> com seus dados reais.

## Modelagem (UML)

```
+----------------------+          +----------------------------+
|        Medico        |          |        Beneficiario         |
+----------------------+          +----------------------------+
| - id: Long           |          | - id: Long                  |
| - nome: String       |          | - nome: String               |
| - crm: String        |          | - cpf: String                 |
| - especialidade: Str |          | - dataNascimento: String       |
| - telefone: String   |          | - plano: String                 |
+----------------------+          | - ativo: boolean                 |
| + getters/setters    |          +----------------------------+
+----------------------+          | + getters/setters             |
                                    +----------------------------+
```

Camadas (arquitetura em 3 camadas por entidade):

```
Controller (REST)  --->  Repository (Spring Data JPA)  --->  Banco H2 (memoria)
MedicoController         MedicoRepository                    tabela medico
BeneficiarioController   BeneficiarioRepository               tabela beneficiario
```

## Como executar

1. Abrir o projeto no IntelliJ (Open -> selecionar a pasta do projeto, contendo o `pom.xml`).
2. Aguardar o Maven baixar as dependências.
3. Rodar a classe `Aula1Exerc2PlanoSaudeSericeApplication` (botão Run).
4. A aplicação sobe em `http://localhost:8080`.
5. Console do banco H2 (opcional): `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:planosaudedb`
   - user: `sa` / senha: (em branco)
6. Endpoint com RA/Nome: `GET http://localhost:8080/api/planosaude/info`

Ao subir, a aplicação já grava 2 médicos e 2 beneficiários de exemplo
(ver `CarregadorDeDados`), então os GETs já retornam dados de imediato.

## Testes via cURL

### Médico — `/api/planosaude/medico`

```bash
# Obter todos
curl -X GET http://localhost:8080/api/planosaude/medico

# Obter um (troque 1 pelo id retornado acima)
curl -X GET http://localhost:8080/api/planosaude/medico/1

# Criar
curl -X POST http://localhost:8080/api/planosaude/medico \
  -H "Content-Type: application/json" \
  -d '{"nome":"Dr. Pedro Alves","crm":"CRM-99999","especialidade":"Ortopedia","telefone":"(19) 98888-0003"}'

# Atualizar (o id deve existir; ajuste conforme o retornado no POST/GET)
curl -X PUT http://localhost:8080/api/planosaude/medico \
  -H "Content-Type: application/json" \
  -d '{"id":1,"nome":"Dr. Joao Silva","crm":"CRM-12345","especialidade":"Cardiologia Clinica","telefone":"(19) 99999-0001"}'

# Excluir
curl -X DELETE http://localhost:8080/api/planosaude/medico/1
```

### Beneficiário — `/api/planosaude/beneficiario`

```bash
# Obter todos
curl -X GET http://localhost:8080/api/planosaude/beneficiario

# Obter um
curl -X GET http://localhost:8080/api/planosaude/beneficiario/1

# Criar
curl -X POST http://localhost:8080/api/planosaude/beneficiario \
  -H "Content-Type: application/json" \
  -d '{"nome":"Fernanda Lima","cpf":"333.333.333-33","dataNascimento":"1998-01-15","plano":"Intermediario","ativo":true}'

# Atualizar
curl -X PUT http://localhost:8080/api/planosaude/beneficiario \
  -H "Content-Type: application/json" \
  -d '{"id":1,"nome":"Carlos Pereira","cpf":"111.111.111-11","dataNascimento":"1985-03-10","plano":"Premium","ativo":false}'

# Excluir
curl -X DELETE http://localhost:8080/api/planosaude/beneficiario/1
```

> Dica para o vídeo: também é possível importar esses mesmos comandos no
> Thunder Client (VS Code) ou no Postman, criando uma coleção com os 5
> métodos (GET all, GET by id, POST, PUT, DELETE) para cada entidade.

## Estrutura do projeto

```
src/main/java/com/planosaude/
 ├── Aula1Exerc2PlanoSaudeSericeApplication.java  (MAIN - RA e Nome)
 ├── model/
 │    ├── Medico.java
 │    └── Beneficiario.java
 ├── repository/
 │    ├── MedicoRepository.java
 │    └── BeneficiarioRepository.java
 ├── controller/
 │    ├── MedicoController.java
 │    ├── BeneficiarioController.java
 │    └── InfoController.java
 └── config/
      └── CarregadorDeDados.java
```
