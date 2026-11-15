create database if not exists hospital;
use hospital;

create table if not exists paciente_hospital (
    id int auto_increment primary key,
    nome varchar(100) not null,
    data_nascimento date not null
);

create table if not exists medico_hospital (
    id int auto_increment primary key,
    nome varchar(100) not null,
    salario decimal(10,2) not null,
    ano_ingresso year not null
);

create table if not exists agenda_hospital (
    id int auto_increment primary key,
    num_consultorio int not null,
    data_agenda date not null,
    horario int not null,

    id_paciente int null,
    id_medico int null,

    status enum('livre', 'consulta', 'limpeza')
        not null default 'livre',

    foreign key (id_paciente)
        references paciente_hospital(id),

    foreign key (id_medico)
        references medico_hospital(id),

    unique (num_consultorio, data_agenda, horario)
);

create or replace view mostrar_registros_hospital as
select
    id,
    num_consultorio,
    data_agenda,
    horario,
    status
from agenda_hospital
where status = 'livre';


insert into paciente_hospital (nome, data_nascimento) values
('Maria Silva', '1990-05-12'),
('João Santos', '1985-08-20'),
('Ana Oliveira', '2000-03-15'),
('Pedro Costa', '1978-11-02'),
('Maria Souza', '1995-10-01');

insert into medico_hospital (nome, salario, ano_ingresso) values
('Carlos Almeida', 8500.00, 2018),
('Fernanda Lima', 9200.00, 2020),
('Roberto Mendes', 7800.00, 2015);

insert into agenda_hospital
(num_consultorio, data_agenda, horario, status) values
(1, '2025-10-01', 8, 'livre'),
(1, '2025-10-01', 9, 'livre'),
(1, '2025-10-01', 10, 'livre'),
(1, '2025-10-01', 11, 'livre'),
(1, '2025-10-01', 12, 'livre'),
(1, '2025-10-01', 13, 'livre'),
(1, '2025-10-01', 14, 'livre'),
(1, '2025-10-01', 15, 'livre'),
(1, '2025-10-01', 16, 'livre'),
(1, '2025-10-01', 17, 'livre');

update agenda_hospital
set id_paciente = 1,
    id_medico = 1,
    status = 'consulta'
where num_consultorio = 1
and data_agenda = '2025-10-01'
and horario = 8;

update agenda_hospital
set id_paciente = 2,
    id_medico = 2,
    status = 'consulta'
where num_consultorio = 1
and data_agenda = '2025-10-01'
and horario = 10;

update agenda_hospital
set id_paciente = 3,
    id_medico = 3,
    status = 'consulta'
where num_consultorio = 1
and data_agenda = '2025-10-01'
and horario = 13;

update agenda_hospital
set id_paciente = 4,
    id_medico = 1,
    status = 'consulta'
where num_consultorio = 1
and data_agenda = '2025-10-01'
and horario = 15;

create user if not exists 'medico'@'localhost'
identified by 'Medico@123';

create user if not exists 'rh'@'localhost'
identified by 'Rh@123';

create user if not exists 'limpeza'@'localhost'
identified by 'Limpeza@123';

-- =====================================================
-- permissões do usuário médico
-- =====================================================

grant select, insert, update, delete
on hospital.paciente_hospital
to 'medico'@'localhost';

grant select, insert, update, delete
on hospital.agenda_hospital
to 'medico'@'localhost';

grant select
on hospital.medico_hospital
to 'medico'@'localhost';

grant select, insert, update, delete
on hospital.medico_hospital
to 'rh'@'localhost';

grant select
on hospital.paciente_hospital
to 'rh'@'localhost';

grant select
on hospital.agenda_hospital
to 'rh'@'localhost';

grant select
on hospital.mostrar_registros_hospital
to 'limpeza'@'localhost';

grant select (id, nome)
on hospital.paciente_hospital
to 'limpeza'@'localhost';

grant select (id_paciente, data_agenda, status)
on hospital.agenda_hospital
to 'limpeza'@'localhost';

grant insert (num_consultorio, data_agenda, horario, status)
on hospital.agenda_hospital
to 'limpeza'@'localhost';

grant update (status)
on hospital.agenda_hospital
to 'limpeza'@'localhost';

select * from paciente_hospital;
select * from medico_hospital;
select * from agenda_hospital;
select * from mostrar_registros_hospital;