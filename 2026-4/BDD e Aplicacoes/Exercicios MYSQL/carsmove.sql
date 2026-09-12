create database if not exists carsmove;
use carsmove;

drop table if exists automovel;
drop table if exists tabuada;

create table tabuada(
	id int auto_increment primary key,
    n1 int not null,
    n2 int not null,
    resultado int not null
);

create table automovel(
	id int auto_increment primary key,
    id_pessoa int,
    placa varchar(10) not null unique,
	carro_moto varchar(10),
    modelo varchar(100),
    preoco decimal(10,2)
);

delimiter $$
drop procedure if exists preencher_tabuada $$

create procedure preencher_tabuada()
	begin 
		declare v_n1 int default 1;
        declare v_n2 int;
        
        while v_n1 <= 10 do
			set v_n2 = 1;
            
		while v_n2 <= 10 do
			insert into tabuada(n1, n2, resultado)
            values (v_n1, v_n2, v_n1 * v_n2);
            
            set v_n2 = v_n2 + 1;
		end while;
        set v_n1 = v_n1 + 1;
	end while;
end$$
delimiter ;

call preencher_tabuada();

select * from tabuada;

delimiter $$
drop procedure if exists bucar_id_tabuada $$

create procedure buscar_id_tabuada(
	in p_n1 int, in p_n2 int, out p_id int
)
begin
	select id into p_id from tabuada where n1 = p_n1 and n2 = p_n2 limit 1;
end $$
delimiter ;

call preencher_tabuada();
select * from tabuada;


delimiter $$
drop procedure if exists buscar_id_tabuada $$

create procedure buscar_id_tabuada(
    in p_n1 int,
    in p_n2 int,
    out p_id int
)
begin

    select id into p_id from tabuada where n1 = p_n1 and n2 = p_n2 limit 1;

end $$
delimiter ;

call buscar_id_tabuada(5, 6, @id_tabuada);
select  @id_tabuada as 'ID DA TABUADA';

delimiter $$
drop procedure if exists verificar_numero $$

create procedure verificar_numero(
    inout p_numero int
)
begin

    declare v_divisores int default 0;
    declare v_contador int default 1;
    declare v_quantidade int default 0;

    while v_contador <= p_numero do

        if mod(p_numero, v_contador) = 0 then
            set v_divisores = v_divisores + 1;
        end if;

        set v_contador = v_contador + 1;

    end while;

    if v_divisores = 2 then

        set p_numero = p_numero;

    else

        select COUNT(*) into v_quantidade from tabuada where resultado = p_numero;
        set p_numero = p_numero * v_quantidade;

    end if;

end $$
delimiter ;

set @numero = 7;
call verificar_numero(@numero);
select @numero as 'RESULTADO';


set @numero = 7;
call verificar_numero(@numero);
select @numero as 'Número primo - Resultado';

set @numero = 20;
call verificar_numero(@numero);
select @numero as 'Número da tabuada - Resultado';


set @numero = 111;
call verificar_numero(@numero);
select @numero as 'Número fora da tabuada - Resultado';

delimiter $$
drop procedure if exists gerenciar_automovel $$

create procedure  gerenciar_automovel(
    in p_acao varchar(20),
    in p_id int,
    in p_id_pessoa int,
    in p_placa varchar(10),
    in p_carro_moto varchar(10),
    in p_modelo varchar(100),
    in p_preco decimal(10,2)
)
begin

    declare v_existe int default 0;

    if UPPER(p_acao) = 'INSERIR' then

        select COUNT(*)
        into v_existe
        from automovel
        where placa = p_placa;

        if v_existe > 0 then

            signal sqlstate '45000'
            set message_text = 'Erro - Placa já cadastrada';
        else
            insert into automovel (
                id_pessoa,
                placa,
                carro_moto,
                modelo,
                preco
            )
            values (
                p_id_pessoa,
                p_placa,
                p_carro_moto,
                p_modelo,
                p_preco
            );

        end if;

    elseif UPPER(p_acao) = 'ATUALIZAR' then

        select COUNT(*)
        into v_existe
        from automovel
        where id = p_id;

        if v_existe = 0 then

            signal sqlstate '45000'
            set message_text = 'Erro - Id não existe';
        else

            update automovel
            set
                id_pessoa = p_id_pessoa,
                placa = p_placa,
                carro_moto = p_carro_moto,
                modelo = p_modelo,
                preco = p_preco
            where id = p_id;

        end if;

    elseif UPPER(p_acao) = 'EXCLUIR' then

        select COUNT(*)
        into v_existe
        from automovel
        where id = p_id;

        if v_existe = 0 then

            signal sqlstate '45000'
            set message_text = 'Erro - Id não existe';
        else

            delete from automovel
            where id = p_id;

        end if;

    else
        signal sqlstate '45000'
        set message_text = 'Erro - Ação desconhecida';

    end if;

end $$
delimiter ;

call gerenciar_automovel(
    'INSERIR',
    null,
    1,
    'ABC1D23',
    'CARRO',
    'Dodge Charger',
    450000.00
);

select * from automovel;

call gerenciar_automovel(
    'INSERIR',
    null,
    2,
    'ABC1D23',
    'CARRO',
    'Nissan Skyline R34',
    600000.00
);

call gerenciar_automovel(
    'INSERIR',
    null,
    3,
    'GHI3F45',
    'MOTO',
    'Honda CB 500',
    45000.00
);

select * from automovel;

call gerenciar_automovel(
    'ATUALIZAR',
    2,
    2,
    'DEF2E34',
    'CARRO',
    'Nissan Skyline R34 GT-R',
    650000.00
);

select * from automovel;

call gerenciar_automovel(
    'ATUALIZAR',
    999,
    2,
    'XXX9X99',
    'CARRO',
    'Carro inexistente',
    100000.00
);

call gerenciar_automovel(
    'EXCLUIR',
    3,
    null,
    null,
    null,
    null,
    null
);

select * from automovel;

CALL gerenciar_automovel(
    'EXCLUIR',
    999,
    null,
    null,
    null,
    null,
    null
);

CALL gerenciar_automovel(
    'DELETAR',
    1,
    null,
    null,
    null,
    null,
    null
);

select * from tabuada;
select * from automovel;

