CREATE DATABASE Personagem;
USE Personagem;

CREATE TABLE personagem(
	id INT AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL,
	desenho VARCHAR(45) NOT NULL,
	especie VARCHAR(45) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO personagem(nome, desenho, especie)
VALUES('Stitch', 'Lilo & Stitch', 'Alienígena'),
('Roger Rabbit', 'Quem Enquadrou Roger Rabbit', 'Coelho'),
('Ariel', 'A Pequena Sereia', 'Sereia'),
('Buzz Lightyear', 'Toy Story', 'Humano'),
('Rapunzel', 'Enrolados', 'Humano');

SELECT * FROM personagem;

ALTER TABLE personagem ADD COLUMN ano_desenho INT;
ALTER TABLE personagem ADD COLUMN sexo VARCHAR(10);

UPDATE personagem SET ano_desenho = 2002, sexo = 'masculino' WHERE id = 1;
UPDATE personagem SET ano_desenho = 1988, sexo = 'masculino' WHERE id = 2;
UPDATE personagem SET ano_desenho = 1989, sexo = 'feminino' WHERE id = 3;
UPDATE personagem SET ano_desenho = 1995, sexo = 'masculino' WHERE id = 4;
UPDATE personagem SET ano_desenho = 2010, sexo = 'feminino' WHERE id = 5;

SELECT * FROM personagem WHERE ano_desenho BETWEEN 2000 AND 2009 AND nome LIKE '%R%';

SELECT nome, especie, desenho FROM personagem WHERE sexo = 'feminino';

UPDATE personagem SET sexo = LEFT(sexo, 1) WHERE id > 0;
ALTER TABLE personagem MODIFY COLUMN sexo VARCHAR(1);

ALTER TABLE personagem RENAME COLUMN ano_desenho TO ano_lancamento_desenho;

SELECT * FROM personagem WHERE sexo = 'm' AND ano_lancamento_desenho < 2000;

ALTER TABLE personagem DROP COLUMN ano_lancamento_desenho;

DROP USER IF EXISTS 'exercicio20'@'localhost';
CREATE USER 'exercicio20'@'localhost' IDENTIFIED WITH mysql_native_password BY 'senha123';
GRANT SELECT, INSERT ON Personagem.personagem TO 'exercicio20'@'localhost';
FLUSH PRIVILEGES;

INSERT INTO personagem(nome, desenho, especie, sexo) VALUES ('Usuário teste', 'Teste', 'Alienígena', 'm');

SELECT id, nome FROM personagem WHERE especie = 'Alienígena';

UPDATE personagem SET nome = 'Usuário novo' WHERE id = (SELECT MAX(id) FROM personagem);

DELETE FROM personagem WHERE id = (SELECT MAX(id) FROM personagem);