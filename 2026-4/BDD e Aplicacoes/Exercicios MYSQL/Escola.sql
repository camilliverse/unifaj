create database escola;
use escola;

create table disciplina (
    id int primary key auto_increment,
    nome varchar(100) not null,
    professor varchar(100) not null
);

create table aluno (
    id int primary key auto_increment,
    nome varchar(100) not null,
    ano int not null
);

create table  nota (
    id int primary key auto_increment,
    nota decimal(5,2) not null,
    id_disciplina int not null,
    id_aluno int not null,
    foreign key (id_disciplina) references disciplina(id),
    foreign key  (id_aluno) references aluno(id)
);

insert into disciplina (nome, professor) values
('Matematica', 'Carlos'),
('Portugues', 'Fernanda'),
('Programacao', 'Roberto');


insert into aluno (nome, ano) values
('Ana', 2026),
('Bruno', 2026),
('Camila', 2026),
('Daniel', 2026),
('Eduardo', 2026);

insert into nota (nota, id_disciplina, id_aluno) values
(8.0, 1, 1),
(7.0, 2, 1),
(9.0, 1, 2),
(6.0, 3, 2),
(5.0, 2, 3),
(8.0, 3, 3),
(7.0, 1, 4),
(6.0, 2, 4),
(4.0, 3, 5),
(5.0, 1, 5);

select
    a.nome as aluno,
    d.nome as disciplina,
    d.professor,
    n.nota
from nota n
inner join aluno a
    on n.id_aluno = a.id
inner join disciplina d
    on n.id_disciplina = d.id;
    
select
    a.nome as aluno,
    d.nome as disciplina,
    sum(n.nota) as soma_notas
from nota n
inner join aluno a
    on n.id_aluno = a.id
inner join disciplina d
    on n.id_disciplina = d.id
group by a.id, a.nome, d.id, d.nome
order by a.nome, d.nome;

select
    d.professor,
    d.nome as disciplina,
    avg(n.nota) as media_notas
from disciplina d
inner join nota n
    on d.id = n.id_disciplina
group by d.id, d.professor, d.nome;

create view view_aluno_disciplina as
select
    a.nome as aluno,
    d.nome as disciplina,
    d.professor
from nota n
inner join aluno a
    on n.id_aluno = a.id
 inner join disciplina d
    on n.id_disciplina = d.id;
    
select * from view_aluno_disciplina;
    
select aluno as nome
from view_aluno_disciplina

union

select professor as nome
from view_aluno_disciplina;

select * from nota;

start transaction;

update nota
set nota = 100
where id_aluno = 5;

select * from nota;

rollback;

select * from nota;

select
    a.id,
    a.nome,
    coalesce(sum(n.nota), 0) as soma_notas
from aluno a
left join nota n
    on a.id = n.id_aluno
group by a.id, a.nome
order by soma_notas desc;

start transaction;

insert into nota (nota, id_disciplina, id_aluno)
values (10.00, 3, 5);


select
    a.id,
    a.nome,
    coalesce(sum(n.nota), 0) as soma_notas
from aluno 
left join nota n
    on a.id = n.id_aluno
group by a.id, a.nome
order by soma_notas desc;

commit;