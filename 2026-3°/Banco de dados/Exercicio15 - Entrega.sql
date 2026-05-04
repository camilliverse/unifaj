CREATE DATABASE pessoa;
use pessoa; 

CREATE TABLE pessoa(
	id INT auto_increment,
	nome VARCHAR(250),
	data_nascimento DATE, 
	quantidade_irmaos INT NOT NULL,
	rua VARCHAR(250) NOT NULL,
	numero VARCHAR(10) NOT NULL,
	bairro VARCHAR(45) NOT NULL,
	cidade VARCHAR(45) NOT NULL,
	cep VARCHAR(9) NOT NULL , 
    PRIMARY KEY(id) 
);

INSERT INTO pessoa(nome, data_nascimento, quantidade_irmaos, rua, numero, bairro, cidade, cep)
VALUES('Cabrita', '2002-02-20', 12, 'Rua dos breginhos', '10', 'Amazoinas', 'Marula', '12345-678'),
('Coelito', '1998-05-10', 3, 'Rua Andar pulando', '5', 'Pulindo', 'Norte dos pullos', '12815-859'),
('Jaccarezito', '2000-07-20', 1, 'Rua Barganca', '12', 'ComerCarne', 'Carnes', '13000-000'),
('Alex', '1999-12-31', 6, 'Rua Planar ', '22', 'Grandes Asas', 'Ratinhos', '12345-678'),
('Cavalito', '1999-12-31', 5, 'Rua Corra muito', '22', 'Pasto', 'Grande galope', '12345-678');

SELECT * FROM pessoa;
SELECT nome FROM pessoa WHERE quantidade_irmaos > 2;
SELECT * FROM pessoa WHERE numero % 2 = 0 AND cidade = 'Marula';
SELECT rua, numero, bairro, cidade, cep FROM pessoa WHERE nome = 'Cabrita';
UPDATE pessoa SET bairro = 'Bairro das flores' WHERE id = 4;
UPDATE pessoa SET bairro = 'Cacasem' WHERE id = 3;
SELECT nome, quantidade_irmaos FROM pessoa WHERE quantidade_irmaos > 4;
UPDATE pessoa SET quantidade_irmaos = 20 WHERE id = 25; 
SELECT * FROM pessoa WHERE cep = '12345-678';

DELETE FROM pessoa WHERE id = 3; 
/*Como teste acabei exluindo a pessoa 2*/






