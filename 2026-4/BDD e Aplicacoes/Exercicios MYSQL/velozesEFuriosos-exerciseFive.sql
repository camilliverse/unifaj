create database valozesEFuriosos;
use valozesEFuriosos;

create table pessoa(
	id int primary key auto_increment,
    nome varchar(100) not null,
    profissao varchar(45),
    cnh varchar(1)
);

create table automovel(
	id int primary key auto_increment,
    carro_moto varchar(1),
    modelo varchar(45),
    preco decimal,
    
	id_pessoa int,
	foreign key(id_pessoa) references pessoa(id)
);

insert into pessoa (nome) VALUES
('Vin Diesel'), ('Dominic Toretto'), ('Paul Walker '), (' Brian OConner'),('Jordana Brewster');

insert into automovel (carro_moto) VALUES
('Toyota Supra MK IV'),('Nissan Skyline GT-R'),('Mazda RX-7'),('Mitsubishi Eclipse'),('Dodge Charger R/T');

select 