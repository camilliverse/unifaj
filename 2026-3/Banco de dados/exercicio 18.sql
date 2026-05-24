drop database if exists exercicio18;
create database if not exists exercicio18;
use exercicio18;
drop table if exists responsavel, cachorro, agenda;

create table if not exists responsavel(
	id int auto_increment primary key,
    nome varchar(50) not null,
    telefone varchar(45) not null,
    email varchar(100) not null
);

create table if not exists cachorro(
	id int auto_increment primary key,
    nome varchar(50) not null,
    raca varchar(50) not null,
    temperamento varchar(20) not null,
    id_responsavel int,
    foreign key (id_responsavel) references responsavel(id)
);

create table if not exists agenda(
	id int auto_increment primary key,
    data_agenda date not null,
    horario_agenda time not null,
	id_cachorro int,
    foreign key (id_cachorro) references cachorro(id)
);


insert into responsavel (nome, telefone, email) values
('Carlos Silva', '19999990001', 'carlos.silva@email.com'),
('Mariana Souza', '19999990002', 'mariana.souza@email.com'),
('João Pereira', '19999990003', 'joao.pereira@email.com');


insert into cachorro (nome, raca, temperamento, id_responsavel) values
('Rex', 'Pastor Alemão', 'Docíl', 1),
('Luna', 'Labrador', 'Docíl', 2),
('Thor', 'Bulldog', 'Calmo', 1),
('Mel', 'Poodle', 'Bravo', 3),
('Bob', 'Vira-lata', 'Medroso', 2);


insert into agenda (data_agenda, horario_agenda, id_cachorro) values
('2025-03-12', '09:00:00', 1),
('2025-03-12', '10:30:00', 2),
('2025-03-13', '14:00:00', 3),
('2025-03-13', '15:30:00', 4),
('2025-03-14', '08:00:00', 5),
('2025-03-14', '11:00:00', 1),
('2025-03-15', '13:00:00', 2),
('2025-03-15', '16:00:00', 3),
('2025-03-16', '09:30:00', 4),
('2025-03-16', '17:00:00', 5);

select * from responsavel inner join cachorro on cachorro.id_responsavel = responsavel.id;

select responsavel.nome as nome_responsavel, cachorro.nome as nome_cachorro, cachorro.temperamento from responsavel
	inner join cachorro on cachorro.id_responsavel = responsavel.id where temperamento != 'Docíl';
     
select cachorro.nome as nome_cachorro, data_agenda, horario_agenda from cachorro
	inner join agenda on agenda.id_cachorro = cachorro.id;
    
select cachorro.nome as nome_cachorro, raca from cachorro
	inner join agenda on agenda.id_cachorro = cachorro.id where data_agenda = '2025-03-12';

select responsavel.nome as nome_responsavel, email from responsavel
	inner join cachorro on cachorro.id_responsavel = responsavel.id
    inner join agenda on agenda.id_cachorro = cachorro.id where data_agenda = '2025-03-12';