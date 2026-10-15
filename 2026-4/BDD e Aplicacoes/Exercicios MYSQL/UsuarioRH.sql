use hospital;

create user if not exists 'rh_user'@'localhost'
identified by 'RH@123';

grant select, insert, update, delete
on hospital.medico
to 'rh_user'@'localhost';

grant select
on hospital.paciente
to 'rh_user'@'localhost';

grant select
on hospital.agenda
to 'rh_user'@'localhost';

show grants for 'rh_user'@'localhost';

insert into medico (nome, salario, ano_ingresso)
values ('Juliana Martins', 6800.00, 2025);

select * from medico
where nome = 'Juliana Martins';

update medico
set salario = 7500.00
where nome = 'Juliana Martins';

select * from medico
where nome = 'Juliana Martins';

select
    m.id,
    m.nome as medico,
    COUNT(a.id) as total_consultas
from medico m
left join agenda a
    on m.id = a.id_medico
   and a.tipo_agenda = 'CONSULTA'
group by m.id, m.nome;

select *
from paciente
where nome like '%Maria%';