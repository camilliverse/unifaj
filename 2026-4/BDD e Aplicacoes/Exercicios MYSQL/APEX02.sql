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

insert into endereco (rua, numero, bairro, cidade, cep) values
('Rua das Flores', '100', 'Centro', 'Sumaré', '13170-000'),
('Rua Azul', '200', 'Matão', 'Sumaré', '13170-001'),
('Rua Verde', '300', 'Nova Veneza', 'Sumaré', '13170-002'),
('Rua das Acácias', '400', 'Centro', 'Sumaré', '13170-003'),
('Rua Primavera', '500', 'Centro', 'Sumaré', '13170-004'),
('Rua do Sol', '600', 'Matão', 'Sumaré', '13170-005'),
('Rua das Palmeiras', '700', 'Nova Veneza', 'Sumaré', '13170-006');

insert into  ong (nome) values
('ONG Criança Feliz'),
('ONG Novo Amanhã');

insert into  unidade
(identificacao, tipoAtendimento, publicoAlvo, id_ong) values
('Unidade Central', 'Atendimento pediátrico', 'Crianças de 0 a 6 anos', 1),
('Unidade Norte', 'Acompanhamento infantil', 'Crianças de 7 a 12 anos', 1),
('Unidade Sul', 'Atendimento psicológico', 'Crianças e adolescentes', 2);

insert into formacao (nome, diploma) values
('Enfermagem', 'Bacharelado'),
('Medicina', 'Bacharelado'),
('Psicologia', 'Bacharelado'),
('Fisioterapia', 'Bacharelado');

insert into  profissional
(nome, CPF, dataNascimento, telefone, id_endereco) values
('Ana Souza', '111.111.111-11', '1990-05-10', '19999990001', 1),
('Carlos Lima', '222.222.222-22', '1985-08-15', '19999990002', 2),
('Mariana Alves', '333.333.333-33', '1992-03-20', '19999990003', 3);

insert into  profissional_formacao values
(1, 1),
(2, 2),
(3, 3),
(3, 4);

insert into  profissional_ong values
(1, 1, 'CLT', 'Enfermeira'),
(2, 1, 'CLT', 'Médico'),
(3, 2, 'Voluntário', 'Psicóloga');

insert into  unidade_profissional values
(1, 1),
(1, 2),
(2, 3);

insert into  usuario (nome, senha, id_profissional) values
('ana.souza', 'senha123', 1),
('carlos.lima', 'senha456', 2),
('mariana.alves', 'senha789', 3);

insert into crianca
(nome, dataNascimento, nomePai, nomeMae, telefone, id_endereco) values
('Lucas Silva', '2019-04-10', 'João Silva', 'Maria Silva', '19988880001', 4),
('Pedro Santos', '2018-06-15', 'Paulo Santos', 'Ana Santos', '19988880002', 5),
('Julia Oliveira', '2020-02-20', 'Carlos Oliveira', 'Fernanda Oliveira', '19988880003', 6),
('Beatriz Costa', '2017-09-12', 'Roberto Costa', 'Camila Costa', '19988880004', 7);

insert into  comportamento (descricao) values
('Calmo e participativo'),
('Agitado'),
('Tímido'),
('Comunicativo');

insert into agendamento
(data, horario, situacao, id_crianca) values
('2026-11-10', '08:00:00', 'Realizado', 1),
('2026-11-17', '09:00:00', 'Realizado', 1),
('2026-11-10', '10:00:00', 'Realizado', 2),
('2026-11-12', '08:00:00', 'Realizado', 3),
('2026-11-19', '09:00:00', 'Agendado', 4);

insert into  ficha_atendimento
(dataAtendimento, altura, peso, grauMobilidade,
 desenvolvimentoCog, obsEnfermeira, id_agendamento,
 id_enfermeira, id_profissionalSaude, id_comportamento)
values
('2026-11-10', 1.10, 20.5, 'Normal', 'Adequado',
 'Primeiro atendimento', 1, 1, 2, 1),

('2026-11-17', 1.12, 21.0, 'Normal', 'Boa evolução',
 'Atendimento de acompanhamento', 2, 1, 2, 4),

('2026-11-10', 1.15, 22.0, 'Normal', 'Adequado',
 'Sem observações', 3, 1, 2, 2),

('2026-11-12', 1.05, 18.5, 'Em desenvolvimento',
 'Em acompanhamento', 'Necessita acompanhamento', 4, 1, 3, 3);


-- 3 - consulta

select
    crianca.nome as crianca,
    agendamento.data,
    agendamento.horario
from crianca
inner join agendamento
    on crianca.id = agendamento.id_crianca;

-- explicacao:
-- relaciona as tabelas crianca e agendamento apresenta o nome da criança, a data e o horário dos seus agendamentos.

-- 4 consulta tabelas join

select
    crianca.nome as crianca,
    agendamento.data,
    ficha_atendimento.peso,
    ficha_atendimento.altura
from crianca
inner join  agendamento
    ON crianca.id = agendamento.id_crianca
inner join  ficha_atendimento
    on agendamento.id = ficha_atendimento.id_agendamento;

-- explicacao:
-- relaciona crianca, agendamento e ficha_atendimento apresenta a criança, a data do atendimento, o peso e a altura registrados na ficha.

-- 5 - union

select nome as pessoa
from crianca

union

select nome as pessoa
from profissional;

-- explicacao:
-- Une os nomes cadastrados nas tabelas crianca
-- e profissional em um único resultado.
-- O UNION elimina os nomes duplicados.

-- 6 interset

select id, nome
from crianca
where id in (
    select id_crianca
    from agendamento
)

intersect

select id, nome
from crianca
where id in (
    select agendamento.id_crianca
    from agendamento
    inner join ficha_atendimento
        on agendamento.id = ficha_atendimento.id_agendamento
);

-- explicacao:
-- identifica as crianças que possuem agendamento e também possuem ficha de atendimento registrada O INTERSECT retorna somente os registros presentes nos dois resultados.

-- 7 except

select id, nome
from crianca

except

select crianca.id, crianca.nome
from crianca
inner join agendamento
    on crianca.id = agendamento.id_crianca
inner join ficha_atendimento
    on agendamento.id = ficha_atendimento.id_agendamento;

-- explicacao:
-- Identifica as crianças que ainda não possuem nenhuma ficha de atendimento registrada O EXCEPT retorna os registros da primeira consulta que não aparecem na segunda consulta.

-- 8 - case

select
    nome,
    dataNascimento,

    case
        when timestampdiff(year, dataNascimento, CURDATE()) <= 3
            then 'Primeira infância'

        when timestampdiff(year, dataNascimento, CURDATE()) <= 6
            then 'Infância'

        else 'Acima de 6 anos'
    end as faixaEtaria

from crianca;

-- explicacao:
-- CASE para classificar as crianças de acordo com a idade calculada cada condição apresenta uma classificação diferente.

-- 9 - count

select
    COUNT(*) as totalCriancas
from crianca;

-- explicao:
-- COUNT para contar a quantidade total de crianças cadastradas no sistema.


-- 10 - having

select
    crianca.nome,
    COUNT(agendamento.id) as totalAgendamentos

from crianca

inner join agendamento
    on crianca.id = agendamento.id_crianca

group by crianca.id, crianca.nome

having COUNT(agendamento.id) >= 2;

-- explicao:
-- Agrupa os agendamentos por criança HAVING filtra os grupos e apresenta somente as crianças que possuem dois ou mais agendamentos.

-- 11 - subquery

select nome
from crianca

where id in (

    select id_crianca
    from agendamento
    group by id_crianca
    having COUNT(*) >= 2
);

-- explicao:
-- A consulta interna identifica as crianças que possuem dois ou mais agendamentos consulta externa apresenta os nomes dessas crianças.

-- 12 - view

create view view_historico_atendimentos as

select
    crianca.nome as crianca,
    agendamento.data,
    agendamento.horario,
    profissional.nome as profissionalSaude,
    ficha_atendimento.peso,
    ficha_atendimento.altura,
    ficha_atendimento.grauMobilidade,
    ficha_atendimento.desenvolvimentoCog

from crianca

inner join agendamento
    on crianca.id = agendamento.id_crianca

inner join ficha_atendimento
    on agendamento.id = ficha_atendimento.id_agendamento

inner join profissional
    on ficha_atendimento.id_profissionalSaude = profissional.id;

-- Consultar a view:
select * from view_historico_atendimentos;

-- explicacao:
-- cria uma visualização com informações de quatro tabelas permite consultar o histórico dos atendimentos,identificando a criança, o profissional e os dados
-- registrados durante cada atendimento.


-- 13 - trigger before insert

delimiter //

create trigger validar_ficha
before insert on ficha_atendimento
for each row

begin

    if new.peso is null or new.peso <= 0
       or new.altura is null or new.altura <= 0 then

        signal sqlstate '45000'
        set message_text =
        'Peso e altura devem ser maiores que zero';

    end if;

end //

delimiter ;

-- explicacao:
-- executa uma validação antes de inserir uma ficha verifica se o peso e a altura são maiores que zero caso algum valor seja inválido, impede a inserção.

-- 14 - trigger after insert

delimiter //

create trigger registrar_ficha
after insert on ficha_atendimento
for each row

begin

    insert into log_ficha
    (id_ficha, dataRegistro, descricao)

    values
    (
        new.id,
        NOW(),
        'Nova ficha de atendimento cadastrada'
    );

end //

delimiter ;

-- explicação:
-- executa uma ação depois da inserção de uma ficha registra automaticamente na tabela log_ficha o identificador da ficha, a data e uma descrição.

-- 15 - function

delimiter //

create function contar_atendimentos(p_id_crianca int)

returns int
reads sql data

begin

    declare total int;

    select COUNT(*)
    into total

    from ficha_atendimento

    inner join agendamento
        on ficha_atendimento.id_agendamento = agendamento.id

    where agendamento.id_crianca = p_id_crianca;

    return total;

end //

delimiter ;

 -- ultilizando funtiojn
 
select contar_atendimentos(1) as totalAtendimentos;

-- explcacao:
-- recebe o identificador de uma criança conta quantas fichas de atendimento ela possui retorna a quantidade encontrada.

-- 16 - stored produce

delimiter //

create procedure consultar_historico(in p_id_crianca int)

begin

    select
        crianca.nome as crianca,
        ficha_atendimento.dataAtendimento,
        ficha_atendimento.altura,
        ficha_atendimento.peso,
        ficha_atendimento.grauMobilidade,
        ficha_atendimento.desenvolvimentoCog,
        ficha_atendimento.obsEnfermeira

    from crianca

    inner join agendamento
        on crianca.id = agendamento.id_crianca

    inner join ficha_atendimento
        on agendamento.id = ficha_atendimento.id_agendamento

    where crianca.id = p_id_crianca;

end //

delimiter ;

-- executar a stored procedure:
call consultar_historico(1);

-- explicação:
-- recebe o identificador de uma criança apresenta todas as fichas de atendimento registradas para ela, permitindo consultar seu histórico de evolução.
