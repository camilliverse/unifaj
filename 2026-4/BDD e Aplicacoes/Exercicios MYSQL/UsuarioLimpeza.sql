
use hospital;

create user if not exists 'limpeza_user'@'localhost'
identified by 'Limpeza@123';

grant select
on hospital.horarios_livres
to 'limpeza_user'@'localhost';

grant select
on hospital.agenda
to 'limpeza_user'@'localhost';

grant select
on hospital.agenda
to 'limpeza_user'@'localhost';

show grants for 'limpeza_user'@'localhost';

insert into agenda
(num_consultorio, data_agenda, horario,
 id_paciente, id_medico, tipo_agenda)
select
    1,
    '2025-10-01',
    12,
    null,
    null,
    'LIMPEZA'
where not exists (
    select 1
    from agenda
    where num_consultorio = 1
      and data_agenda = '2025-10-01'
      and horario = 12
      and tipo_agenda IN ('CONSULTA', 'LIMPEZA')
);

select
    id,
    num_consultorio,
    data_agenda,
    horario
from horarios_livres
order by data_agenda, horario;

select distinct
    p.nome AS paciente
from agenda a
inner join paciente p
    on a.id_paciente = p.id
where a.data_agenda = '2025-10-01'
  and a.tipo_agenda = 'CONSULTA'
order by p.nome;

