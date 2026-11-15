use hospital;

insert into agenda_hospital
(num_consultorio, data_agenda, horario, status)
values
(2, '2025-10-01', 12, 'limpeza');

select
    num_consultorio,
    data_agenda,
    concat(lpad(horario, 2, '0'), ':00') as horario
from mostrar_registros_hospital
order by data_agenda, num_consultorio, horario;

select distinct
    p.nome
from agenda_hospital a
inner join paciente_hospital p
    on a.id_paciente = p.id
where a.data_agenda = '2025-10-01'
and a.status = 'consulta';