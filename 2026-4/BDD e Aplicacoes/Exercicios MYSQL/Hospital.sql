create database hospital;
use hospital;

create table paciente (
	id int primary key auto_increment,
    nome varchar(100) not null, 
    data_nascimento date not null
);

create table medico(
	id int primary key auto_increment,
	nome varchar(100) not null,
    salario decimal(10,2) not null,
    ano_ingresso year not null
);

drop table if exists agenda;

create table agenda (
    id int primary key auto_increment,
    num_consultorio int not null,
    data_agenda date not null,
    horario int not null,
    id_paciente int,
    id_medico int,
    tipo_agenda enum('CONSULTA', 'LIMPEZA', 'LIVRE')
       not null default 'LIVRE',
    foreign key (id_paciente) references paciente(id),
    foreign key (id_medico) references medico(id)
);

insert into paciente (nome, data_nascimento) values
('Maria Silva', '1990-05-12'),
('Joao Santos', '1985-08-20'),
('Ana Oliveira', '2000-02-15'),
('Pedro Souza', '1978-11-03'),
('Maria Costa', '1995-07-25');

insert into medico (nome, salario, ano_ingresso) values
('Carlos Mendes', 6500.00, 2020),
('Fernanda Lima', 7200.00, 2018),
('Roberto Alves', 5800.00, 2022);

insert into agenda
(num_consultorio, data_agenda, horario, id_paciente, id_medico, tipo_agenda)
values
(1, '2025-10-01', 8,  1, 1, 'CONSULTA'),
(1, '2025-10-01', 9,  2, 2, 'CONSULTA'),
(1, '2025-10-01', 10, null, null, 'LIVRE'),
(1, '2025-10-01', 11, 3, 1, 'CONSULTA'),
(1, '2025-10-01', 12, null, null, 'LIVRE'),
(1, '2025-10-01', 13, null, null, 'LIVRE'),
(1, '2025-10-01', 14, 4, 3, 'CONSULTA'),
(1, '2025-10-01', 15, null, null, 'LIVRE'),
(1, '2025-10-01', 16, null, null, 'LIVRE'),
(1, '2025-10-01', 17, null, null, 'LIVRE');

create view horarios_livres as
select
    id,
    num_consultorio,
    data_agenda,
    horario
from agenda
where id_paciente is null
  and id_medico is null
  and tipo_agenda = 'LIVRE';

select * from paciente;

select * from medico;

select * from agenda;

select * from horarios_livres;