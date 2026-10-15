create database if not exists ong_conecta;
use ong_conecta;

set foreign_key_checks = 0;
drop table if exists log_evento;
drop table if exists vaga_habilidade;
drop table if exists curso_habilidade;
drop table if exists pessoa_curso;
drop table if exists empresa_vaga;
drop table if exists voluntariado;
drop table if exists historico;
drop table if exists pessoa;
drop table if exists vaga;
drop table if exists curso;
drop table if exists voluntario;
drop table if exists funcionario;
drop table if exists empresa;
drop table if exists endereco;
drop table if exists habilidade;
drop table if exists cargo;
drop table if exists cidade;
drop table if exists estado_civil;
set foreign_key_checks = 1;

create table estado_civil(
id int auto_increment primary key,
descricao varchar(30) not null unique
);

create table cidade(
id int auto_increment primary key,
nome varchar(80) not null,
uf char(2) not null
);

create table endereco(
id int auto_increment primary key,
rua varchar(100) not null,
numero varchar(10) not null,
bairro varchar(60) not null,
cep varchar(9) not null,
id_cidade int not null,
foreign key (id_cidade) references cidade(id)
);

create table cargo(
id int auto_increment primary key,
nome varchar(60) not null unique
);

create table habilidade(
id int auto_increment primary key,
nome varchar(60) not null unique
);

create table empresa(
id int auto_increment primary key,
cnpj varchar(18) not null unique,
nome_oficial varchar(100) not null,
nome_fantasia varchar(100) not null,
responsavel_rh varchar(100) not null,
telefone_rh varchar(15) not null,
id_endereco int not null,
foreign key (id_endereco) references endereco(id)
);

create table funcionario(
id int auto_increment primary key,
nome varchar(100) not null,
sexo char(1) not null,
data_nascimento date not null,
cpf varchar(14) not null unique,
telefone varchar(15) not null,
id_estado_civil int not null,
id_empresa int null,
foreign key (id_estado_civil) references estado_civil(id),
foreign key (id_empresa) references empresa(id)
);

create table historico(
id int auto_increment primary key,
id_funcionario int not null,
id_cargo int not null,
salario decimal(10,2) not null,
data_inicio date not null,
data_mudanca date null,
descricao_mudanca varchar(100) null,
foreign key (id_funcionario) references funcionario(id),
foreign key (id_cargo) references cargo(id)
);

create table voluntario(
id int auto_increment primary key,
nome varchar(100) not null,
sexo char(1) not null,
data_nascimento date not null,
cpf varchar(14) not null unique,
telefone varchar(15) not null,
id_estado_civil int not null,
foreign key (id_estado_civil) references estado_civil(id)
);

create table voluntariado(
id int auto_increment primary key,
id_funcionario int not null,
id_voluntario int not null,
dia_semana varchar(15) not null,
horario_inicio time not null,
horario_fim time not null,
foreign key (id_funcionario) references funcionario(id),
foreign key (id_voluntario) references voluntario(id)
);

create table vaga(
id int auto_increment primary key,
titulo varchar(80) not null,
carga_horaria int not null,
salario decimal(10,2) not null
);

create table empresa_vaga(
id_empresa int not null,
id_vaga int not null,
primary key (id_empresa, id_vaga),
foreign key (id_empresa) references empresa(id),
foreign key (id_vaga) references vaga(id)
);

create table vaga_habilidade(
id_vaga int not null,
id_habilidade int not null,
primary key (id_vaga, id_habilidade),
foreign key (id_vaga) references vaga(id),
foreign key (id_habilidade) references habilidade(id)
);

create table pessoa(
id int auto_increment primary key,
nome varchar(100) not null,
data_nascimento date not null,
cpf varchar(14) not null unique,
telefone varchar(15) not null,
ultima_profissao varchar(60),
renda_familiar decimal(10,2) not null,
quantidade_filhos int not null default 0,
id_endereco int not null,
id_vaga int null,
foreign key (id_endereco) references endereco(id),
foreign key (id_vaga) references vaga(id)
);

create table curso(
id int auto_increment primary key,
nome varchar(80) not null,
data_curso date not null,
horario time not null,
quantidade_vagas int not null
);

create table curso_habilidade(
id_curso int not null,
id_habilidade int not null,
primary key (id_curso, id_habilidade),
foreign key (id_curso) references curso(id),
foreign key (id_habilidade) references habilidade(id)
);

create table pessoa_curso(
id_pessoa int not null,
id_curso int not null,
data_cadastro date null,
comparecimento boolean not null default 0,
certificado boolean not null default 0,
motivo_ausencia varchar(150) null,
primary key (id_pessoa, id_curso),
foreign key (id_pessoa) references pessoa(id),
foreign key (id_curso) references curso(id)
);

create table log_evento(
id int auto_increment primary key,
tabela varchar(40) not null,
descricao varchar(200) not null,
data_evento datetime not null default current_timestamp
);


insert into estado_civil (id, descricao) values
(1, 'Solteiro'), (2, 'Casado'), (3, 'Divorciado'), (4, 'Viuvo');

insert into cidade (id, nome, uf) values
(1, 'Sao Paulo', 'SP'),(2, 'Sumare', 'SP'),(3, 'Campinas', 'SP'),(4, 'Hortolandia', 'SP');

insert into endereco (id, rua, numero, bairro, cep, id_cidade) values
(1, 'Av. Paulista', '1000', 'Bela Vista', '01310-100', 1),(2, 'Rua das Flores', '250', 'Centro', '13170-000', 2),(3, 'Av. Brasil', '500', 'Cambui', '13025-000', 3),(4, 'Rua Sete', '12', 'Jardim Nova', '13170-111', 2),
(5, 'Rua Oito', '45', 'Jardim Bela', '13170-222', 2),(6, 'Rua Nove', '78', 'Vila Rica', '13180-333', 4),(7, 'Rua Dez', '90', 'Taquaral', '13025-444', 3),(8, 'Rua Onze', '33', 'Mooca', '03100-555', 1),
(9, 'Rua Doze', '65', 'Jardim Alto', '13170-666', 2),(10, 'Rua Treze', '81', 'Vila Nova', '13180-777', 4);

insert into cargo (id, nome) values
(1, 'Psicologo'), (2, 'Coordenador'), (3, 'Assistente Administrativo'), (4, 'Instrutor');

insert into habilidade (id, nome) values
(1, 'Excel'), (2, 'Atendimento ao Cliente'), (3, 'Informatica Basica'),
(4, 'Costura Industrial'), (5, 'Logistica');

insert into empresa (id, cnpj, nome_oficial, nome_fantasia, responsavel_rh, telefone_rh, id_endereco) values
(1, '11.111.111/0001-11', 'Comercial Alfa Ltda', 'Alfa Store', 'Carla Souza', '(11) 90000-0001', 1),
(2, '22.222.222/0001-22', 'Textil Beta S.A.', 'Beta Textil', 'Marcos Lima', '(19) 90000-0002', 2),
(3, '33.333.333/0001-33', 'Logistica Gama Ltda', 'Gama Log', 'Renata Dias', '(19) 90000-0003', 3);

insert into funcionario (id, nome, sexo, data_nascimento, cpf, telefone, id_estado_civil, id_empresa) values
(1, 'Monica Ferreira', 'F', '2000-04-15', '111.111.111-11', '(19) 91111-0001', 1, null),
(2, 'Roberto Alves', 'M', '1985-09-20', '222.222.222-22', '(19) 91111-0002', 2, null),
(3, 'Juliana Costa', 'F', '1992-01-10', '333.333.333-33', '(19) 91111-0003', 3, null);

insert into historico (id, id_funcionario, id_cargo, salario, data_inicio, data_mudanca, descricao_mudanca) values
(1, 1, 1, 3000.00, '2023-02-01', '2024-02-01', 'Reajuste anual'),
(2, 1, 1, 3300.00, '2024-02-01', null, null),
(3, 2, 2, 5000.00, '2021-06-01', '2023-06-01', 'Promocao de cargo'),
(4, 2, 2, 5800.00, '2023-06-01', null, null),
(5, 3, 3, 2500.00, '2024-03-01', null, null);

insert into voluntario (id, nome, sexo, data_nascimento, cpf, telefone, id_estado_civil) values
(1, 'Lucas Martins', 'M', '2001-07-07', '444.444.444-44', '(19) 92222-0001', 1),
(2, 'Fernanda Rocha', 'F', '1998-11-30', '555.555.555-55', '(19) 92222-0002', 2),
(3, 'Paulo Nunes', 'M', '1975-03-25', '666.666.666-66', '(19) 92222-0003', 4);

insert into voluntariado (id, id_funcionario, id_voluntario, dia_semana, horario_inicio, horario_fim) values
(1, 1, 1, 'Segunda', '14:00:00', '18:00:00'),
(2, 1, 1, 'Quarta', '14:00:00', '18:00:00'),
(3, 2, 2, 'Sabado', '08:00:00', '12:00:00'),
(4, 3, 3, 'Sexta', '09:00:00', '13:00:00');

insert into vaga (id, titulo, carga_horaria, salario) values
(1, 'Auxiliar Administrativo', 44, 2200.00),
(2, 'Atendente', 40, 1900.00),
(3, 'Costureira', 44, 2000.00),
(4, 'Auxiliar de Logistica', 44, 2400.00);

insert into empresa_vaga (id_empresa, id_vaga) values
(1, 1), (1, 2), (2, 3), (3, 4);

insert into vaga_habilidade (id_vaga, id_habilidade) values
(1, 1), (1, 3), (2, 2), (3, 4), (4, 5);

insert into pessoa (id, nome, data_nascimento, cpf, telefone, ultima_profissao, renda_familiar, quantidade_filhos, id_endereco, id_vaga) values
(1, 'Ana Beatriz', '1995-05-12', '777.777.777-77', '(19) 93333-0001', 'Diarista', 1200.00, 2, 4, 1),(2, 'Bruno Henrique', '1990-08-22', '888.888.888-88', '(19) 93333-0002', 'Ajudante Geral', 1800.00, 0, 5, 1),
(3, 'Carla Regina', '1988-12-01', '999.999.999-99', '(19) 93333-0003', 'Copeira', 900.00, 3, 6, null),(4, 'Diego Santos', '2000-02-17', '101.101.101-01', '(19) 93333-0004', 'Repositor', 2500.00, 1, 7, 2),
(5, 'Eliane Moura', '1985-06-30', '202.202.202-02', '(11) 93333-0005', 'Cozinheira', 700.00, 4, 8, null),(6, 'Fabio Lopes', '1993-10-10', '303.303.303-03', '(19) 93333-0006', 'Vendedor', 1500.00, 1, 9, null),
(7, 'Gisele Prado', '1997-09-05', '404.404.404-04', '(19) 93333-0007', 'Faxineira', 1100.00, 0, 10, null);

insert into curso (id, nome, data_curso, horario, quantidade_vagas) values
(1, 'Excel Basico', '2026-03-10', '09:00:00', 10),
(2, 'Atendimento ao Cliente', '2026-05-05', '14:00:00', 10),
(3, 'Costura Industrial', '2026-10-20', '09:00:00', 2);

insert into curso_habilidade (id_curso, id_habilidade) values
(1, 1), (1, 3), (2, 2), (3, 4);

insert into pessoa_curso (id_pessoa, id_curso, data_cadastro, comparecimento, certificado, motivo_ausencia) values
(1, 1, '2026-03-09', 1, 1, null),(2, 1, '2026-03-09', 1, 1, null),(3, 1, '2026-03-09', 0, 0, 'Doenca na familia'),(4, 1, '2026-03-09', 1, 0, null),(1, 2, '2026-05-04', 1, 1, null),
(4, 2, '2026-05-04', 1, 1, null),(5, 2, '2026-05-04', 0, 0, 'Conseguiu emprego'),(6, 2, '2026-05-04', 1, 0, null),(1, 3, '2026-09-30', 0, 0, null),(2, 3, '2026-09-30', 0, 0, null);

select e.nome_fantasia, en.rua, en.numero, en.bairro
from empresa e
join endereco en on en.id = e.id_endereco;

select p.nome as pessoa, c.nome as curso, pc.data_cadastro
from pessoa p
join pessoa_curso pc on pc.id_pessoa = p.id
join curso c on c.id = pc.id_curso
order by c.nome, p.nome;

select c.nome as cidade
from empresa e
join endereco en on en.id = e.id_endereco
join cidade c on c.id = en.id_cidade
union
select c.nome
from pessoa p
join endereco en on en.id = p.id_endereco
join cidade c on c.id = en.id_cidade;

select nome, telefone, 'Funcionario' as tipo from funcionario
union all
select nome, telefone, 'Voluntario' as tipo from voluntario;

select distinct c.nome as cidade
from empresa e
join endereco en on en.id = e.id_endereco
join cidade c on c.id = en.id_cidade
where c.id in (
    select en2.id_cidade
    from pessoa p
    join endereco en2 on en2.id = p.id_endereco
);

select p.id, p.nome
from pessoa p
where not exists (
    select 1 from pessoa_curso pc where pc.id_pessoa = p.id
);

select nome, renda_familiar,
    case
        when renda_familiar < 1000 then 'Prioridade alta'
        when renda_familiar < 2000 then 'Prioridade media'
        else 'Prioridade baixa'
    end as prioridade
from pessoa;

select p.nome, c.nome as curso,
    case
        when pc.certificado = 1 then 'Certificado emitido'
        when pc.comparecimento = 1 then 'Concluiu, sem certificado'
        when pc.motivo_ausencia is not null then 'Ausente com motivo registrado'
        else 'Inscrito'
    end as status
from pessoa_curso pc
join pessoa p on p.id = pc.id_pessoa
join curso c on c.id = pc.id_curso;

select c.nome, count(pc.id_pessoa) as total_inscritos
from curso c
left join pessoa_curso pc on pc.id_curso = c.id
group by c.id, c.nome;


select ca.nome as cargo, avg(h.salario) as salario_medio
from historico h
join cargo ca on ca.id = h.id_cargo
group by ca.id, ca.nome;

select e.nome_fantasia, sum(v.salario) as total_salarios_ofertados
from empresa e
join empresa_vaga ev on ev.id_empresa = e.id
join vaga v on v.id = ev.id_vaga
group by e.id, e.nome_fantasia;

select c.nome, sum(pc.certificado) as certificados_emitidos
from curso c
join pessoa_curso pc on pc.id_curso = c.id
group by c.id, c.nome
having sum(pc.certificado) >= 2;

select e.nome_fantasia, count(ev.id_vaga) as total_vagas
from empresa e
join empresa_vaga ev on ev.id_empresa = e.id
group by e.id, e.nome_fantasia
having count(ev.id_vaga) > 1;

select c.nome, c.quantidade_vagas,
    (select count(*) from pessoa_curso pc where pc.id_curso = c.id) as inscritos
from curso c;

select nome, renda_familiar
from pessoa
where renda_familiar < (select avg(renda_familiar) from pessoa);

select c.nome, t.total
from curso c
join (
    select id_curso, count(*) as total
    from pessoa_curso
    group by id_curso
) t on t.id_curso = c.id;

select c.nome
from curso c
order by (select count(*) from pessoa_curso pc where pc.id_curso = c.id) desc;

update pessoa_curso
set certificado = 1
where comparecimento = 1
  and certificado = 0
  and id_curso in (select id from curso where nome like 'Atendimento%');

create index idx_pessoa_nome on pessoa(nome);

drop view if exists vw_funcionario_publico;
create view vw_funcionario_publico as
select f.id, f.nome, f.sexo, ec.descricao as estado_civil
from funcionario f
join estado_civil ec on ec.id = f.id_estado_civil;

select * from vw_funcionario_publico;

drop view if exists vw_inscricoes_cursos;
create view vw_inscricoes_cursos as
select p.id as id_pessoa, p.nome as pessoa, p.telefone,
       c.id as id_curso, c.nome as curso,
       pc.comparecimento, pc.certificado, pc.motivo_ausencia
from pessoa_curso pc
join pessoa p on p.id = pc.id_pessoa
join curso c on c.id = pc.id_curso;

select * from vw_inscricoes_cursos;

delimiter $$
drop trigger if exists trg_pessoa_curso_before_insert $$

create trigger trg_pessoa_curso_before_insert
before insert on pessoa_curso
for each row
begin
    declare v_inscritos int default 0;
    declare v_vagas int default 0;

    select count(*) into v_inscritos from pessoa_curso where id_curso = new.id_curso;
    select quantidade_vagas into v_vagas from curso where id = new.id_curso;

    if v_inscritos >= v_vagas then
        signal sqlstate '45000'
        set message_text = 'Erro - Curso sem vagas disponiveis';
    end if;

    if new.data_cadastro is null then
        set new.data_cadastro = curdate();
    end if;
end $$
delimiter ;

delimiter $$
drop trigger if exists trg_vaga_after_insert $$

create trigger trg_vaga_after_insert
after insert on vaga
for each row
begin
    insert into log_evento (tabela, descricao)
    values ('vaga', concat('Nova vaga cadastrada: ', new.titulo, ' (id ', new.id, ')'));
end $$
delimiter ;

delimiter $$
drop trigger if exists trg_pessoa_curso_after_update $$

create trigger trg_pessoa_curso_after_update
after update on pessoa_curso
for each row
begin
    if old.certificado = 0 and new.certificado = 1 then
        insert into log_evento (tabela, descricao)
        values ('pessoa_curso',
                concat('Certificado emitido - pessoa ', new.id_pessoa, ', curso ', new.id_curso));
    end if;
end $$
delimiter ;

delimiter $$
drop function if exists fn_idade $$

create function fn_idade(p_data date)
returns int
no sql
begin
    return timestampdiff(year, p_data, curdate());
end $$
delimiter ;

select nome, fn_idade(data_nascimento) as idade from pessoa;

delimiter $$
drop function if exists fn_vagas_restantes $$

create function fn_vagas_restantes(p_id_curso int)
returns int
reads sql data
begin
    declare v_vagas int default 0;
    declare v_inscritos int default 0;

    select quantidade_vagas into v_vagas from curso where id = p_id_curso;
    select count(*) into v_inscritos from pessoa_curso where id_curso = p_id_curso;

    return v_vagas - v_inscritos;
end $$
delimiter ;

select nome, fn_vagas_restantes(id) as vagas_restantes from curso;

delimiter $$
drop procedure if exists sp_inscrever_pessoa $$

create procedure sp_inscrever_pessoa(
in p_id_pessoa int,
in p_id_curso int
)
begin
    declare v_existe int default 0;

    select count(*) into v_existe
    from pessoa_curso
    where id_pessoa = p_id_pessoa and id_curso = p_id_curso;

    if v_existe > 0 then
        signal sqlstate '45000'
        set message_text = 'Erro - Pessoa ja inscrita neste curso';
    else
        insert into pessoa_curso (id_pessoa, id_curso) values (p_id_pessoa, p_id_curso);
    end if;
end $$
delimiter ;

delimiter $$
drop procedure if exists sp_pessoas_capacitadas $$

create procedure sp_pessoas_capacitadas(
in p_id_vaga int
)
begin
    select p.id, p.nome, p.telefone
    from pessoa p
    join pessoa_curso pc on pc.id_pessoa = p.id and pc.certificado = 1
    join curso_habilidade ch on ch.id_curso = pc.id_curso
    join vaga_habilidade vh on vh.id_habilidade = ch.id_habilidade
                           and vh.id_vaga = p_id_vaga
    group by p.id, p.nome, p.telefone
    having count(distinct vh.id_habilidade) =
           (select count(*) from vaga_habilidade where id_vaga = p_id_vaga);
end $$
delimiter ;

call sp_inscrever_pessoa(7, 1);
select * from pessoa_curso where id_pessoa = 7;

update pessoa_curso set certificado = 1 where id_pessoa = 4 and id_curso = 1;

insert into vaga (titulo, carga_horaria, salario) values ('Recepcionista', 40, 2000.00);

select * from log_evento;

call sp_pessoas_capacitadas(1);
call sp_pessoas_capacitadas(2);