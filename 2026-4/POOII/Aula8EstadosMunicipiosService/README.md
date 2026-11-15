# Aula8EstadosMunicipiosService

Spring Boot 3.3 + Spring Data JPA (Hibernate) + H2 em memória. **Sem JDBC/DAO manual.**

## Antes de entregar
Troque `SEU NOME` e `SEU_RA` pelos seus dados nos 3 HTMLs (`src/main/resources/static/`).
Dica: Ctrl+Shift+F na IDE, procure `SEU NOME` e `SEU_RA`.

## Executar
    mvn spring-boot:run        (ou rodar a classe Aula8EstadosMunicipiosServiceApplication na IDE)
Abrir http://localhost:8080  (Java 17+)

## Tabelas (criadas pelo JPA)
- `estados`   (id = COD do CSV, nome, sigla)
- `municipios` (id = COD do CSV, nome, estado_id -> FK estados.id)
Console do banco: http://localhost:8080/h2-console  (JDBC URL `jdbc:h2:mem:estadosdb`, user `sa`, senha vazia)

## REST
- GET /api/estados
- GET /api/municipios                    (com estadoNome e estadoSigla)
- GET /api/municipios?estado=Paraná      (filtro pelo NOME do estado)
- GET /api/municipios/total

## Roteiro sugerido para o vídeo (4-5 min)
1. Estrutura do projeto e os CSVs em `resources/csv` (30s)
2. Entidades `Estado` e `Municipio` com `@ManyToOne` (FK) (40s)
3. `CsvImportService`: leitura, trim da sigla, ordem estados -> municípios, `saveAll` (90s)
4. `MunicipioRepository`: JPQL com JOIN e `new MunicipioDTO(...)`, filtro por nome (60s)
5. Controllers REST e JSON no navegador (30s)
6. HTMLs: `fetch()` em estados.html e municipios.html (combo + filtro) rodando (60s)
