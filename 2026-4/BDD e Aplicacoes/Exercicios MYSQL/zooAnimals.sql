drop database if exists zooanimals;

create database if not exists zooanimals;
use zooanimals;

create table animal (
id int auto_increment primary key,
especie varchar(50) not null,
tipo varchar(20) not null,
nivel_feroz int not null
);

create table animal_feroz(
id_animal int primary key,
registros int default 1,
foreign key(id_animal) references animal(id) on delete cascade
);

delimiter $$

create trigger antes_inserir_animal
before insert on animal
for each row
begin
if new.nivel_feroz < 1 then
set new.nivel_feroz = 1;
elseif new.nivel_feroz > 5 then
set new.nivel_feroz = 5;
end if;
end$$

delimiter ;

delimiter $$

create trigger depois_inserirr_animal
after insert on animal
for each row
begin
if new.nivel_feroz = 4 or new.nivel_feroz = 5 then
insert into animal_feroz(id_animal, registros)
values (new.id, 1);
end if;
end$$

delimiter ;

insert into animal (especie, tipo, nivel_feroz)
values ('Leão', 'Carnívoro', 5), ('Tigre', 'Carnívoro', 4),('Elefante', 'Herbívoro', 2),('Girafa', 'Herbívoro',1),
('Lobo', 'Carnívoro', 3), ('Dragão', 'Carnívoro', 8);

select * from animal;

select * from animal_feroz;

delimiter $$

create trigger antes_atualizar_animal
before update on animal
for each row
begin
if old.especie <> new.especie then
set new.especie = old.especie;
end if;
end$$

delimiter ;

update animal
set especie = 'especie invalida'
where id = 1;

delimiter $$

create trigger depois_atualizar_animal
after update on animal
for each row
begin
if new.nivel_feroz = 4 or new.nivel_feroz = 5 then
update animal_feroz
set registros = registros + 1
where id_animal = new.id;
end if;
end$$

delimiter ;

delete from animal
where id = 2;

delimiter $$

create trigger depois_deletar_animal
after delete on animal
for each row
begin
delete from animal_feroz
where id_animal = old.id;
end$$

delimiter ;

delete from animal
where id = 1;

select * from animal;

select * from animal_feroz;

delimiter $$

create function verificar_feroz(p_especie varchar(50))
returns varchar(30)
deterministic
begin
declare resultado varchar(30);

if exists(
select 1
from animal a
inner join animal_feroz af
on a.id = af.id_animal
where a.especie = p_especie
) then
set resultado = 'animal feroz';
else
set resultado = 'animal não feroz';
end if;

return resultado;
end$$

delimiter ;

select id, especie, tipo, nivel_feroz,
verificar_feroz(especie) as classificacao
from animal;

delimiter $$

create function verificar_tipo(p_tipo char(1))
returns varchar(20)
deterministic
begin
if upper(p_tipo) = 'H' then
return 'herbivoro';
elseif upper(p_tipo) = 'C' then
return 'carnivoro';
else
return 'tipo invalido';
end if;
end$$

delimiter ;

select especie,
verificar_tipo(left(tipo,1)) as tipo_animal
from animal;