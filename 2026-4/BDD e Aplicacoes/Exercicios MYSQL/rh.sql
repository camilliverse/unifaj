use hospital;

insert into medico_hospital
(nome, salario, ano_ingresso)
values
('Juliana Martins', 8800.00, 2025);

-- armazenando o id do médico inserido
set @id_novo_medico = last_insert_id();

update medico_hospital
set salario = 9500.00
where id = @id_novo_medico;

select
    m.nome,
    count(a.id) as total_consultas
from medico_hospital m
left join agenda_hospital a
    on m.id = a.id_medico
    and a.status = 'consulta'
group by m.id, m.nome;

select *
from paciente_hospital
where nome like '%Maria%';