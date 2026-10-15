use hospital;

create user if not exists 'medico_user'@'localhost'
identified by 'Medico@123';

grant select, insert, update
on hospital.paciente
to 'medico_user'@'localhost';


grant select, insert, update, delete
on hospital.agenda
to 'medico_user'@'localhost';

grant delete
on hospital.paciente
to 'medico_user'@'localhost';

show grants for 'medico_user'@'localhost';

use hospital;

insert into paciente (nome, data_nascimento)
values ('Lucas Pereira', '2001-04-18');

select * from paciente
where nome = 'Lucas Pereira';

update paciente
set nome = 'Lucas Pereira Silva'
where nome = 'Lucas Pereira';

select * from paciente
where nome = 'Lucas Pereira Silva';

delete from paciente
where nome = 'Lucas Pereira Silva';

insert into agenda
(num_consultorio, data_agenda, horario,
 id_paciente, id_medico, tipo_agenda)
values
(2, '2025-10-01', 15, 5, 2, 'CONSULTA');

select
    p.nome as paciente,
    a.data_agenda as data_consulta,
    a.horario as horario_consulta
from agenda a
inner join paciente p
    on a.id_paciente = p.id
where a.tipo_agenda = 'CONSULTA';
