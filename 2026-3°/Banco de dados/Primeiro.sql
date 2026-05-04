CREATE DATABASE Primeiro;
use Primeiro;

CREATE TABLE aluno(
	id INT auto_increment,
    nome VARCHAR(250) NOT NULL,
    data_nascimento DATE NOT NULL,
    PRIMARY KEY(id)
);
/*Print (descrição) tabela aluno*/
DESC aluno;

CREATE TABLE curso(
	id INT auto_increment,
    descricao VARCHAR(250) NOT NULL,
    carga_horaria INT NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO curso(descricao, carga_horaria)
VALUES('Curso 1', 20);

/*Print das minhas tabelas*/
SELECT * FROM curso;
SELECT descricao FROM curso;
SELECT * FROM curso WHERE carga_horaria > 15;
SELECT * FROM curso WHERE carga_horaria < 15;
SELECT * FROM curso WHERE carga_horaria = 20;
SELECT * FROM curso WHERE carga_horaria <> 20;
SELECT * FROM curso WHERE carga_horaria != 20;

/*Adicionado informações em minhas tabelas pelo ids já existentes */
UPDATE curso SET descricao = 'Curso 4', carga_horaria = 40 
WHERE id = 4; 

/*Deletando as informações desse id q especifiquei*/
DELETE FROM curso WHERE id = 7; 



