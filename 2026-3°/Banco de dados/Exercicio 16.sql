CREATE DATABASE animal;
USE animal;

CREATE TABLE animal(
	id INT AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	especie VARCHAR(50) NOT NULL,
	raca VARCHAR(50) NOT NULL,
	data_nascimento DATE NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO animal(nome, especie, raca, data_nascimento) VALUES
('Rex', 'cachorro', 'Labrador', '2020-01-01'),
('Bolt', 'cachorro', 'Poodle', '2019-05-10'),
('Pipoca', 'ave', 'calopsita', '2021-03-15'),
('Stuart', 'rato', 'Branco', '2022-07-20'),
('Antonella', 'gato', 'Persa', '2018-11-11');

SELECT * FROM animal;
SELECT nome, raca FROM animal WHERE especie = 'cachorro';
SELECT data_nascimento FROM animal WHERE especie = 'ave' AND raca = 'calopsita';
SELECT * FROM animal WHERE nome = 'Rex';
UPDATE animal SET raca = 'Pastor-australiano' WHERE id = '2';
UPDATE animal SET data_nascimento = '2020-01-01' WHERE id = 1;
SELECT nome, especie, raca FROM animal WHERE especie = 'foca';
SELECT nome, especie, raca FROM animal WHERE especie = 'gato';
SELECT * FROM animal WHERE data_nascimento = '2020-01-01' AND especie = 'cachorro';
SELECT * FROM animal WHERE nome = 'Stuart' AND especie = 'rato';

DELETE FROM animal WHERE id = 2;