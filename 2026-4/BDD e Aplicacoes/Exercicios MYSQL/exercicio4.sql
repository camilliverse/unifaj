drop database if exists	exercicio4;
create database if not exists exercicio4;
use exercicio4;

create table pai(
	id int primary key auto_increment,
    nome varchar(100)
);

create table filho(
	id int primary key auto_increment,
    nome varchar(100),
    id_pai int, 
		foreign key (id_pai) references pai(id)
);

INSERT INTO pai (nome) VALUES
('Carlos'),
('Joao'),
('Marcos'),
('Ricardo'),
('Fernando');

INSERT INTO filho (nome, id_pai) VALUES
('Pedro', 1),
('Lucas', 2),
('Gabriel', 3),
('Ricardo', 4),
('Mateus', 5);

select * from pai;
select * from filho;
select pai.nome as pais, filho.nome as filhos from pai inner join filho on pai.id = filho.id_pai;

select nome from pai
union all 
select nome from filho
group by nome order by nome asc;

select nome from pai
union 
select nome from filho;

select pai.nome from pai
inner join filho
    on pai.nome = filho.nome;

select pai.nome from pai
left join filho
    on pai.nome = filho.nome
where filho.id is null;

select pai.nome from pai
left join filho
    on pai.nome = filho.nome
	where filho.id is null
union
select filho.nome from filho
left join pai
	on filho.nome = pai.nome
	where pai.id is null;
    
select pai.nome, count(filho.id) as qnt_filhos from pai
left join filho
	on pai.id = filho.id_pai
    group by pai.id, pai.nome;
    
select nome, count(*) as quantidade
from (
    select nome from pai
    union all
    select nome from filho
) as pessoas
group by nome;

select nome, count(*) as quantidade
from (
    select nome from pai
    union all
    select nome from filho
) as pessoas
group by nome
order by nome asc;

select pai.nome, count(filho.id) as qnt_filhos
from pai
left join filho
    on pai.id = filho.id_pai
group by pai.id, pai.nome
having count(filho.id) >= 2;

with quantidade_filhos as (
    select pai.nome, count(filho.id) as qnt_filhos
    from pai
    left join filho
        on pai.id = filho.id_pai
    group by pai.id, pai.nome
)
select nome, qnt_filhos
from quantidade_filhos
where qnt_filhos >= 2;

create table pai_filho (
    nome_pai varchar(100),
    nome_filho varchar(100)
);

insert into pai_filho (nome_pai, nome_filho)
with dados as (
    select 
        pai.nome as nome_pai,
        filho.nome as nome_filho
    from pai
    inner join filho
        on pai.id = filho.id_pai
)
select nome_pai, nome_filho
from dados;