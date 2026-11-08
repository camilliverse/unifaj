create database if not exists ong_projeto;
use ong_projeto;


 -- 1 - criar tabelas

create table endereco (
    id int auto_increment primary key,
    rua varchar(100),
    numero varchar(10),
    bairro varchar(60),
    cidade varchar(60),
    cep varchar(10)
);

create table ong (
    id int auto_increment primary key,
    nome varchar(100) not null
);

create table unidade (
    id int auto_increment primary key,
    identificacao varchar(100),
    tipoAtendimento varchar(100),
    publicoAlvo varchar(100),
    id_ong int,

    foreign key  (id_ong) references ong(id)
);

create table formacao (
    id int auto_increment primary key,
    nome varchar(100),
    diploma varchar(100)
);

create table profissional (
    id int auto_increment primary key,
    nome varchar(100) not null,
    CPF varchar(14) unique  not null,
    dataNascimento date,
    telefone varchar(20),
    id_endereco int,

	foreign key  (id_endereco) references endereco(id)
);

-- Relação N:N entre profissional e formação
create table profissional_formacao (
    id_profissional int,
    id_formacao int,

    primary key (id_profissional, id_formacao),

     foreign key  (id_profissional) references profissional(id),
     foreign key  (id_formacao) references formacao(id)
);

-- Relação N:N entre profissional e ONG
create table profissional_ong (
    id_profissional int,
    id_ong int,
    vinculoONG varchar(60),
    funcaoONG varchar(60),

     primary key (id_profissional, id_ong),

     foreign key  (id_profissional) references profissional(id),
     foreign key  (id_ong) references ong(id)
);

-- Relação N:N entre profissional e unidade
create table unidade_profissional (
    id_unidade int,
    id_profissional int,

   primary key (id_unidade, id_profissional),

	foreign key (id_unidade) references unidade(id),
    foreign key  (id_profissional) references profissional(id)
);

-- Cada usuário está associado a um profissional
create table usuario (
    id int auto_increment primary key,
    nome varchar(60) not null,
    senha varchar(255) not null,
    id_profissional int unique not null,

     foreign key  (id_profissional) references profissional(id)
);

create table crianca (
    id int auto_increment primary key,
    nome varchar(100) not null,
    dataNascimento date,
    nomePai varchar(100),
    nomeMae varchar(100),
    telefone varchar(20),
    id_endereco int,

     foreign key  (id_endereco) references endereco(id)
);

create table comportamento (
    id int auto_increment primary key,
    descricao varchar(150)
);

-- Uma criança pode possuir vários agendamentos
create table agendamento (
    id int auto_increment primary key,
    data date not null,
    horario time not null,
    situacao varchar(30),
    id_crianca int not null,

    foreign key (id_crianca) references crianca(id)
);

-- Cada ficha está associada a um agendamento
create table ficha_atendimento (
    id int auto_increment primary key,
    dataAtendimento date not null,
    altura decimal(5,2),
    peso decimal(5,2),
    grauMobilidade varchar(100),
    desenvolvimentoCog varchar(150),
    obsEnfermeira text,

    id_agendamento int unique not null,
    id_enfermeira int,
    id_profissionalSaude int,
    id_comportamento int,

     foreign key  (id_agendamento) references agendamento(id),
     foreign key  (id_enfermeira) references profissional(id),
     foreign key  (id_profissionalSaude) references profissional(id),
     foreign key  (id_comportamento) references comportamento(id)
);

-- Tabela utilizada para registrar novas fichas
create table log_ficha (
    id int auto_increment primary key,
    id_ficha int,
    dataRegistro DATETIME,
    descricao varchar(200)
);

-- 2- inserindo valores

insert into endereco (rua, numero, bairro, cidade, cep) VALUES
('Rua das Flores', '100', 'Centro', 'Sumaré', '13170-000'),
('Rua Azul', '200', 'Matão', 'Sumaré', '13170-001'),
('Rua Verde', '300', 'Nova Veneza', 'Sumaré', '13170-002'),
('Rua das Acácias', '400', 'Centro', 'Sumaré', '13170-003'),
('Rua Primavera', '500', 'Centro', 'Sumaré', '13170-004'),
('Rua do Sol', '600', 'Matão', 'Sumaré', '13170-005'),
('Rua das Palmeiras', '700', 'Nova Veneza', 'Sumaré', '13170-006');

insert into  ong (nome) VALUES
('ONG Criança Feliz'),
('ONG Novo Amanhã');

insert into  unidade
(identificacao, tipoAtendimento, publicoAlvo, id_ong) VALUES
('Unidade Central', 'Atendimento pediátrico', 'Crianças de 0 a 6 anos', 1),
('Unidade Norte', 'Acompanhamento infantil', 'Crianças de 7 a 12 anos', 1),
('Unidade Sul', 'Atendimento psicológico', 'Crianças e adolescentes', 2);

insert into formacao (nome, diploma) VALUES
('Enfermagem', 'Bacharelado'),
('Medicina', 'Bacharelado'),
('Psicologia', 'Bacharelado'),
('Fisioterapia', 'Bacharelado');

insert into  profissional
(nome, CPF, dataNascimento, telefone, id_endereco) VALUES
('Ana Souza', '111.111.111-11', '1990-05-10', '19999990001', 1),
('Carlos Lima', '222.222.222-22', '1985-08-15', '19999990002', 2),
('Mariana Alves', '333.333.333-33', '1992-03-20', '19999990003', 3);

insert into  profissional_formacao VALUES
(1, 1),
(2, 2),
(3, 3),
(3, 4);

insert into  profissional_ong VALUES
(1, 1, 'CLT', 'Enfermeira'),
(2, 1, 'CLT', 'Médico'),
(3, 2, 'Voluntário', 'Psicóloga');

insert into  unidade_profissional VALUES
(1, 1),
(1, 2),
(2, 3);

insert into  usuario (nome, senha, id_profissional) VALUES
('ana.souza', 'senha123', 1),
('carlos.lima', 'senha456', 2),
('mariana.alves', 'senha789', 3);

insert into crianca
(nome, dataNascimento, nomePai, nomeMae, telefone, id_endereco) VALUES
('Lucas Silva', '2019-04-10', 'João Silva', 'Maria Silva', '19988880001', 4),
('Pedro Santos', '2018-06-15', 'Paulo Santos', 'Ana Santos', '19988880002', 5),
('Julia Oliveira', '2020-02-20', 'Carlos Oliveira', 'Fernanda Oliveira', '19988880003', 6),
('Beatriz Costa', '2017-09-12', 'Roberto Costa', 'Camila Costa', '19988880004', 7);

insert into  comportamento (descricao) VALUES
('Calmo e participativo'),
('Agitado'),
('Tímido'),
('Comunicativo');

insert into agendamento
(data, horario, situacao, id_crianca) VALUES
('2026-11-10', '08:00:00', 'Realizado', 1),
('2026-11-17', '09:00:00', 'Realizado', 1),
('2026-11-10', '10:00:00', 'Realizado', 2),
('2026-11-12', '08:00:00', 'Realizado', 3),
('2026-11-19', '09:00:00', 'Agendado', 4);

insert into  ficha_atendimento
(dataAtendimento, altura, peso, grauMobilidade,
 desenvolvimentoCog, obsEnfermeira, id_agendamento,
 id_enfermeira, id_profissionalSaude, id_comportamento)
VALUES
('2026-11-10', 1.10, 20.5, 'Normal', 'Adequado',
 'Primeiro atendimento', 1, 1, 2, 1),

('2026-11-17', 1.12, 21.0, 'Normal', 'Boa evolução',
 'Atendimento de acompanhamento', 2, 1, 2, 4),

('2026-11-10', 1.15, 22.0, 'Normal', 'Adequado',
 'Sem observações', 3, 1, 2, 2),

('2026-11-12', 1.05, 18.5, 'Em desenvolvimento',
 'Em acompanhamento', 'Necessita acompanhamento', 4, 1, 3, 3);


-- =====================================================
-- 3) CONSULTA DE 2 TABELAS (JOIN)
-- =====================================================

SELECT
    crianca.nome AS crianca,
    agendamento.data,
    agendamento.horario
FROM crianca
INNER JOIN agendamento
    ON crianca.id = agendamento.id_crianca;

-- Explicação:
-- Relaciona as tabelas crianca e agendamento.
-- Apresenta o nome da criança, a data e o horário
-- dos seus agendamentos.


-- =====================================================
-- 4) CONSULTA DE 3 TABELAS (JOIN)
-- =====================================================

SELECT
    crianca.nome AS crianca,
    agendamento.data,
    ficha_atendimento.peso,
    ficha_atendimento.altura
FROM crianca
INNER JOIN agendamento
    ON crianca.id = agendamento.id_crianca
INNER JOIN ficha_atendimento
    ON agendamento.id = ficha_atendimento.id_agendamento;

-- Explicação:
-- Relaciona crianca, agendamento e ficha_atendimento.
-- Apresenta a criança, a data do atendimento,
-- o peso e a altura registrados na ficha.


-- =====================================================
-- 5) UNION
-- =====================================================

SELECT nome AS pessoa
FROM crianca

UNION

SELECT nome AS pessoa
FROM profissional;

-- Explicação:
-- Une os nomes cadastrados nas tabelas crianca
-- e profissional em um único resultado.
-- O UNION elimina os nomes duplicados.


-- =====================================================
-- 6) INTERSECT
-- =====================================================

SELECT id, nome
FROM crianca
WHERE id IN (
    SELECT id_crianca
    FROM agendamento
)

INTERSECT

SELECT id, nome
FROM crianca
WHERE id IN (
    SELECT agendamento.id_crianca
    FROM agendamento
    INNER JOIN ficha_atendimento
        ON agendamento.id = ficha_atendimento.id_agendamento
);

-- Explicação:
-- Identifica as crianças que possuem agendamento
-- e também possuem ficha de atendimento registrada.
-- O INTERSECT retorna somente os registros presentes
-- nos dois resultados.


-- =====================================================
-- 7) EXCEPT
-- =====================================================

SELECT id, nome
FROM crianca

EXCEPT

SELECT crianca.id, crianca.nome
FROM crianca
INNER JOIN agendamento
    ON crianca.id = agendamento.id_crianca
INNER JOIN ficha_atendimento
    ON agendamento.id = ficha_atendimento.id_agendamento;

-- Explicação:
-- Identifica as crianças que ainda não possuem
-- nenhuma ficha de atendimento registrada.
-- O EXCEPT retorna os registros da primeira consulta
-- que não aparecem na segunda consulta.


-- =====================================================
-- 8) CASE
-- =====================================================

SELECT
    nome,
    dataNascimento,

    CASE
        WHEN TIMESTAMPDIFF(YEAR, dataNascimento, CURDATE()) <= 3
            THEN 'Primeira infância'

        WHEN TIMESTAMPDIFF(YEAR, dataNascimento, CURDATE()) <= 6
            THEN 'Infância'

        ELSE 'Acima de 6 anos'
    END AS faixaEtaria

FROM crianca;

-- Explicação:
-- Utiliza o CASE para classificar as crianças
-- de acordo com a idade calculada.
-- Cada condição apresenta uma classificação diferente.


-- =====================================================
-- 9) COUNT
-- =====================================================

SELECT
    COUNT(*) AS totalCriancas
FROM crianca;

-- Explicação:
-- Utiliza COUNT para contar a quantidade total
-- de crianças cadastradas no sistema.


-- =====================================================
-- 10) HAVING
-- =====================================================

SELECT
    crianca.nome,
    COUNT(agendamento.id) AS totalAgendamentos

FROM crianca

INNER JOIN agendamento
    ON crianca.id = agendamento.id_crianca

GROUP BY crianca.id, crianca.nome

HAVING COUNT(agendamento.id) >= 2;

-- Explicação:
-- Agrupa os agendamentos por criança.
-- O HAVING filtra os grupos e apresenta somente
-- as crianças que possuem dois ou mais agendamentos.


-- =====================================================
-- 11) SUBQUERY
-- =====================================================

SELECT nome
FROM crianca

WHERE id IN (

    SELECT id_crianca
    FROM agendamento
    GROUP BY id_crianca
    HAVING COUNT(*) >= 2

);

-- Explicação:
-- A consulta interna identifica as crianças que possuem
-- dois ou mais agendamentos.
-- A consulta externa apresenta os nomes dessas crianças.


-- =====================================================
-- 12) VIEW
-- =====================================================

CREATE VIEW view_historico_atendimentos AS

SELECT
    crianca.nome AS crianca,
    agendamento.data,
    agendamento.horario,
    profissional.nome AS profissionalSaude,
    ficha_atendimento.peso,
    ficha_atendimento.altura,
    ficha_atendimento.grauMobilidade,
    ficha_atendimento.desenvolvimentoCog

FROM crianca

INNER JOIN agendamento
    ON crianca.id = agendamento.id_crianca

INNER JOIN ficha_atendimento
    ON agendamento.id = ficha_atendimento.id_agendamento

INNER JOIN profissional
    ON ficha_atendimento.id_profissionalSaude = profissional.id;

-- Consultar a VIEW:
SELECT * FROM view_historico_atendimentos;

-- Explicação:
-- Cria uma visualização com informações de quatro tabelas.
-- Permite consultar o histórico dos atendimentos,
-- identificando a criança, o profissional e os dados
-- registrados durante cada atendimento.


-- =====================================================
-- 13) TRIGGER BEFORE INSERT
-- =====================================================

DELIMITER //

CREATE TRIGGER validar_ficha
BEFORE INSERT ON ficha_atendimento
FOR EACH ROW

BEGIN

    IF NEW.peso IS NULL OR NEW.peso <= 0
       OR NEW.altura IS NULL OR NEW.altura <= 0 THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT =
        'Peso e altura devem ser maiores que zero';

    END IF;

END //

DELIMITER ;

-- Explicação:
-- Executa uma validação antes de inserir uma ficha.
-- Verifica se o peso e a altura são maiores que zero.
-- Caso algum valor seja inválido, impede a inserção.


-- =====================================================
-- 14) TRIGGER AFTER INSERT
-- =====================================================

DELIMITER //

CREATE TRIGGER registrar_ficha
AFTER INSERT ON ficha_atendimento
FOR EACH ROW

BEGIN

    INSERT INTO log_ficha
    (id_ficha, dataRegistro, descricao)

    VALUES
    (
        NEW.id,
        NOW(),
        'Nova ficha de atendimento cadastrada'
    );

END //

DELIMITER ;

-- Explicação:
-- Executa uma ação depois da inserção de uma ficha.
-- Registra automaticamente na tabela log_ficha
-- o identificador da ficha, a data e uma descrição.


-- =====================================================
-- 15) FUNCTION
-- =====================================================

DELIMITER //

CREATE FUNCTION contar_atendimentos(p_id_crianca INT)

RETURNS INT
READS SQL DATA

BEGIN

    DECLARE total INT;

    SELECT COUNT(*)
    INTO total

    FROM ficha_atendimento

    INNER JOIN agendamento
        ON ficha_atendimento.id_agendamento = agendamento.id

    WHERE agendamento.id_crianca = p_id_crianca;

    RETURN total;

END //

DELIMITER ;

-- Utilizar a FUNCTION:
SELECT contar_atendimentos(1) AS totalAtendimentos;

-- Explicação:
-- Recebe o identificador de uma criança.
-- Conta quantas fichas de atendimento ela possui.
-- Retorna a quantidade encontrada.


-- =====================================================
-- 16) STORED PROCEDURE
-- =====================================================

DELIMITER //

CREATE PROCEDURE consultar_historico(IN p_id_crianca INT)

BEGIN

    SELECT
        crianca.nome AS crianca,
        ficha_atendimento.dataAtendimento,
        ficha_atendimento.altura,
        ficha_atendimento.peso,
        ficha_atendimento.grauMobilidade,
        ficha_atendimento.desenvolvimentoCog,
        ficha_atendimento.obsEnfermeira

    FROM crianca

    INNER JOIN agendamento
        ON crianca.id = agendamento.id_crianca

    INNER JOIN ficha_atendimento
        ON agendamento.id = ficha_atendimento.id_agendamento

    WHERE crianca.id = p_id_crianca;

END //

DELIMITER ;

-- Executar a STORED PROCEDURE:
CALL consultar_historico(1);

-- Explicação:
-- Recebe o identificador de uma criança.
-- Apresenta todas as fichas de atendimento registradas
-- para ela, permitindo consultar seu histórico de evolução.


-- =====================================================
-- FIM DO ARQUIVO SQL
-- =====================================================
