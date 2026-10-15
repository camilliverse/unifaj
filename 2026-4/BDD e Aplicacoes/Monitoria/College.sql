create database college;
use college;

drop table if exists study;

create table study(
	id int primary key auto_increment,
    nome varchar(250) not null,
    date_of_birth date not null,
    sex varchar(1) not null,
    graduate varchar(1) not null
);

create table discipline (
	id int primary key auto_increment,
    nome varchar(50) not null,
    semester int not null
);

create table study_discipline (
	id_study int,
    id_discipline int, 
    primary key (id_study , id_discipline) , 
    
    foreign key(id_study) references study (id),
    foreign key(id_discipline) references discipline (id)
);

insert into study(nome ,  date_of_birth , sex, graduate) values ('')