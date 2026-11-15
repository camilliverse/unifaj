use hospital;

insert into paciente_hospital (nome, data_nascimento)
values ('Lucas Ferreira', '2002-06-15');

-- armazenando o id do paciente inserido
set @id_novo_paciente = last_insert_id();

update paciente_hospital
set nome = 'Lucas Ferreira Silva'
where id = @id_novo_paciente;

delete from paciente_hospital
where id = @id_novo_paciente;

insert into agenda_hospital
(num_consultorio, data_agenda, horario,
 id_paciente, id_medico, status)
values
(2, '2025-10-01', 9, 5, 1, 'consulta');

select
    p.nome,
    a.data_agenda,
    concat(lpad(a.horario, 2, '0'), ':00') as horario
from agenda_hospital a
inner join paciente_hospital p
    on a.id_paciente = p.id
where a.status = 'consulta';