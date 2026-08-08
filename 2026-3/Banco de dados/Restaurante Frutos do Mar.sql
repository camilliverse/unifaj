CREATE DATABASE Restaurante;
USE Restaurante;

CREATE TABLE restaurante (
	id INT NOT NULL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE unidade (
	id INT NOT NULL PRIMARY KEY,
    proprietario VARCHAR(100),
    numero INT NOT NULL,
    id_restaurante INT NOT NULL,
    FOREIGN KEY (id_restaurante) REFERENCES restaurante(id)
);

CREATE TABLE prato (
	id INT NOT NULL PRIMARY KEY,
    nome VARCHAR(100),
    custo_producao INT NOT NULL,
    custo_venda INT NOT NULL,
    id_unidade INT NOT NULL,
    FOREIGN KEY (id_unidade) REFERENCES unidade(id)
);

INSERT INTO restaurante VALUES 
(1, 'Coco Bambu'),(2, 'Amadeus');

INSERT INTO unidade VALUES
(1, 'Amelia', 101, 1),
(2, 'Arthur', 102, 1),
(3, 'Augusto', 201, 2);

INSERT INTO prato VALUES
(1, 'Moqueca de Camarão', 20, 40, 1),
(2, 'Mariscada', 25, 50, 2),
(3, 'Camarão na Moranga', 15, 30, 3),
(4, 'Salmon', 30, 70, 1);

SELECT * FROM prato WHERE nome LIKE '%s%';

SELECT r.nome AS restaurante, p.nome AS prato, p.custo_venda FROM restaurante r
INNER JOIN unidade u ON r.id = u.id_restaurante
INNER JOIN prato p ON u.id = p.id_unidade
WHERE p.custo_venda = p.custo_producao * 2
ORDER BY p.custo_venda ASC;

SELECT u.proprietario, u.numero, SUM(p.custo_venda) AS total_vendas
FROM unidade u
INNER JOIN prato p
ON u.id = p.id_unidade
GROUP BY u.proprietario, u.numero;

SELECT r.nome, COUNT(u.id) AS quantidade_unidades
FROM restaurante r
LEFT JOIN unidade u
ON r.id = u.id_restaurante
GROUP BY r.nome;

SELECT DISTINCT r.nome FROM restaurante r INNER JOIN unidade u ON r.id = u.id_restaurante
INNER JOIN prato p ON u.id = p.id_unidade
WHERE p.custo_venda > 50;

SELECT u.proprietario,p.nome, p.custo_producao, p.custo_venda FROM prato p
INNER JOIN unidade u ON p.id_unidade = u.id
WHERE p.nome LIKE '%o%'
ORDER BY u.proprietario ASC;



