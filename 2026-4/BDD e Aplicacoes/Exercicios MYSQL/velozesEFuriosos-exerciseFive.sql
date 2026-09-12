create database if not exists valozesefuriosos;
use valozesefuriosos;

drop table if exists pessoa_automovel;
drop table if exists automovel;
drop table if exists pessoa;

create table pessoa(
	id int primary key auto_increment,
    nome varchar(100) not null,
    profissao varchar(45),
    cnh varchar(1)
);

create table automovel (
    id int auto_increment primary key,
    id_pessoa int not null,
    carro_moto varchar(10) not null,
    modelo varchar(45) not null,
    preco decimal(10,2) not null,

    foreign key (id_pessoa) references pessoa(id)
);

insert into pessoa (nome, profissao, cnh) values
('dominic toretto', 'mecânico', 's'), ('brian oconner', 'policial', 's'), ('letty ortiz', 'piloto', 's'),
('roman pearce', 'motorista', 's'),('te j parker', 'programador', 's'),('han seoul-oh', 'mecânico', 's'),
('mia toretto', 'gerente', 'n');


insert into automovel (id_pessoa, carro_moto, modelo, preco) values
(1, 'carro', 'dodge charger r/t', 450000.00), (1, 'carro', 'plymouth roadrunner', 280000.00), (2, 'carro', 'nissan skyline r34', 600000.00),
(3, 'carro', 'nissan silvia s15', 250000.00), (4, 'carro', 'bugatti veyron', 1500000.00),(5, 'carro', 'toyota supra mk4', 500000.00),
(6, 'carro', 'mazda rx-7', 350000.00),(6, 'moto', 'yamaha mt-09', 70000.00);


select id, nome,profissao,
case
   when cnh = 's' then 'sim'
   when cnh = 'n' then 'não'
   else 'não informado'
    end as cnh
from pessoa;

select
    p.nome,
    count(a.id) as qtd_automoveis
from pessoa p
left join automovel a
    on p.id = a.id_pessoa
group by p.id, p.nome;

select
    p.nome,
    case
        when a.id is null then 'sem automóvel'
        else concat(a.carro_moto, ' - ', a.modelo)
    end as automovel
from pessoa p
left join automovel a
    on p.id = a.id_pessoa;

create table pessoa_automovel (
    nome varchar(100) not null,
    modelo varchar(45) not null,
    preco decimal(10,2) not null
);

insert into pessoa_automovel (nome, modelo, preco)
select
    (
        select p.nome
        from pessoa p
        where p.id = a.id_pessoa
    ) as nome,
    a.modelo,
    a.preco
from automovel a
where a.id_pessoa in (
    select p.id
    from pessoa p
);

select
    p.nome,
    sum(a.preco) as preco_total
from pessoa p
join automovel a
    on p.id = a.id_pessoa
group by p.id, p.nome
order by preco_total desc;

update automovel
set preco = 480000.00
where modelo = 'dodge charger r/t'
and id_pessoa = 1;

update pessoa_automovel
set preco = (
    select a.preco
    from automovel a
    where a.modelo = pessoa_automovel.modelo
    and a.id_pessoa = 1
)
where modelo = 'dodge charger r/t';

select * from pessoa_automovel
where nome in (
    select p.nome
    from pessoa p
    where p.profissao in ('mecânico', 'policial')
);

create index idx_modelo on pessoa_automovel(modelo);

select p.nome, p.profissao from pessoa p
where p.id not in (
    select a.id_pessoa
    from automovel a
);

