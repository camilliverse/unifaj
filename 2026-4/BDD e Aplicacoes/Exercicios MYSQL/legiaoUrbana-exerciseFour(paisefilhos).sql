create database legiaoUrbana;
USE legiaoUrbana;

CREATE TABLE pais(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE filhos(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    id_pai INT,
    FOREIGN KEY (id_pai) REFERENCES pais(id)
);

INSERT INTO pais (nome) VALUES
('Renato'),
('Marcelo'),
('Adalto'),
('Carlos'),
('Paulo');

INSERT INTO filhos (nome, id_pai) VALUES
('Gabriel', 1),
('Lucas', 1),
('Marcelo', 2),
('Ana', 2),
('Renato', 3),
('Julia', 4),
('Pedro', 5);

SELECT 
    pais.nome AS pais,
    filhos.nome AS filhos
FROM pais
INNER JOIN filhos
    ON pais.id = filhos.id_pai;
    
SELECT nome FROM pais
UNION ALL

SELECT nome FROM filhos
ORDER BY nome ASC;

SELECT pais.nome
FROM pais
INNER JOIN filhos ON pais.nome = filhos.nome;

SELECT pais.nome FROM pais LEFT JOIN filhos ON pais.nome = filhos.nome
WHERE filhos.id IS NULL;

SELECT pais.nome
FROM pais
LEFT JOIN filhos
    ON pais.nome = filhos.nome
WHERE filhos.id IS NULL

UNION
SELECT filhos.nome FROM filhos LEFT JOIN pais ON filhos.nome = pais.nome
WHERE pais.id IS NULL;

SELECT  pais.nome, COUNT(filhos.id) AS qnt_filhos FROM pais
LEFT JOIN filhos ON pais.id = filhos.id_pai
GROUP BY pais.id, pais.nome;

SELECT 
    nome,
    COUNT(*) AS quantidade
FROM (
    SELECT nome FROM pais
    UNION ALL
    SELECT nome FROM filhos
) AS pessoas
GROUP BY nome
ORDER BY nome ASC;

SELECT pais.nome,COUNT(filhos.id) AS qnt_filhos
FROM pais
LEFT JOIN filhos ON pais.id = filhos.id_pai
GROUP BY pais.id, pais.nome
HAVING COUNT(filhos.id) >= 2;

WITH quantidade_filhos AS (
    SELECT 
        pais.nome,
        COUNT(filhos.id) AS qnt_filhos
    FROM pais
    LEFT JOIN filhos
        ON pais.id = filhos.id_pai
    GROUP BY pais.id, pais.nome
)

SELECT nome, qnt_filhos
FROM quantidade_filhos
WHERE qnt_filhos >= 2;

CREATE TABLE pai_filho(
    nome_pai VARCHAR(100),
    nome_filho VARCHAR(100)
);

INSERT INTO pai_filho (nome_pai, nome_filho)

WITH dados AS (
    SELECT pais.nome AS nome_pai, filhos.nome AS nome_filho
    FROM pais
    INNER JOIN filhos
        ON pais.id = filhos.id_pai
)
SELECT nome_pai, nome_filho
FROM dados;

SELECT * FROM pai_filho;