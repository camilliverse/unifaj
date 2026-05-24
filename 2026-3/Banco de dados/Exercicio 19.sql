CREATE DATABASE feira_db;

USE feira_db;

CREATE TABLE feira (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    bairro VARCHAR(45) NOT NULL,
    dia_semana VARCHAR(45) NOT NULL,
    horario_inicio TIME NOT NULL,
    horario_termino TIME NOT NULL
);

CREATE TABLE categoria(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    tipo_produto VARCHAR(45),
    tamanho_barraca INT
);

CREATE TABLE barraca(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(45) NOT NULL,
    dono VARCHAR(45) NOT NULL,
    id_categoria INT,
    
    FOREIGN KEY (id_categoria)
    REFERENCES categoria(id)
);

CREATE TABLE funcionario (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(45) NOT NULL,
	sexo VARCHAR(1),
	funcao VARCHAR(45) NOT NULL,
    salario DECIMAL(9,2),
    id_barraca INT,
    
    FOREIGN KEY (id_barraca)
    REFERENCES barraca(id)
    
);

CREATE TABLE feira_barraca(
	id_feira INT NOT NULL,
    id_barraca INT NOT NULL,
    posicao_barraca INT, 
    
	FOREIGN KEY (id_feira)
    REFERENCES feira(id),

    FOREIGN KEY (id_barraca)
    REFERENCES barraca(id)
);

INSERT INTO feira (bairro, dia_semana, horario_inicio, horario_termino)
VALUES
('Centro', 'sábado', '06:00:00', '12:00:00'),
('Jardim América', 'segunda-feira', '07:00:00', '13:00:00');

INSERT INTO categoria (tipo_produto, tamanho_barraca)
VALUES
('Frutas', 10),
('Pastel', 15);

INSERT INTO barraca (nome, dono, id_categoria)
VALUES
('Barraca do João', 'João Silva', 1),
('Barraca da Maria', 'Maria Souza', 2),
('Barraca do Pedro', 'Pedro Silva', 1),
('Barraca da Ana', 'Ana Lima', 2);

INSERT INTO feira_barraca (id_feira, id_barraca, posicao_barraca)
VALUES
(1, 1, 1),
(1, 2, 2),
(1, 3, 3),
(1, 4, 4),

(2, 1, 1),
(2, 2, 2);

INSERT INTO funcionario
(nome, sexo, funcao, salario, id_barraca)
VALUES
('Carlos Silva', 'M', 'Caixa', 1800.00, 1),
('Mariana Souza', 'F', 'Vendedor', 1700.00, 1),
('Pedro Lima', 'M', 'Gerente', 2500.00, 2),
('Ana Silva', 'F', 'Caixa', 1900.00, 2),
('João Santos', 'M', 'Vendedor', 1600.00, 3),
('Fernanda Silva', 'F', 'Vendedor', 1750.00, 3),
('Lucas Oliveira', 'M', 'Estoquista', 1500.00, 4),
('Camila Rocha', 'F', 'Caixa', 1850.00, 4),
('Roberto Silva', 'M', 'Vendedor', 2000.00, 1),
('Juliana Alves', 'F', 'Gerente', 2600.00, 2);

SELECT * FROM feira WHERE dia_semana = 'sábado';

SELECT * FROM feira WHERE dia_semana LIKE '%-feira';
--
SELECT
    feira.bairro,
    feira_barraca.posicao_barraca,
    barraca.nome
FROM feira
JOIN feira_barraca
ON feira.id = feira_barraca.id_feira

JOIN barraca
ON barraca.id = feira_barraca.id_barraca

WHERE feira_barraca.posicao_barraca BETWEEN 1 AND 5;

--
SELECT dono AS nomes
FROM barraca

UNION

SELECT nome
FROM funcionario;
--
SELECT
    funcionario.*,
    categoria.tipo_produto
FROM funcionario

JOIN barraca
ON funcionario.id_barraca = barraca.id

JOIN categoria
ON barraca.id_categoria = categoria.id;
--
SELECT *
FROM barraca

RIGHT JOIN categoria
ON barraca.id_categoria = categoria.id;

SELECT * FROM funcionario WHERE funcao = 'Caixa' OR funcao = 'Vendedor';

SELECT * FROM funcionario WHERE funcao IN ('Caixa', 'Vendedor');

SELECT * FROM funcionario WHERE nome LIKE '%Silva%';
