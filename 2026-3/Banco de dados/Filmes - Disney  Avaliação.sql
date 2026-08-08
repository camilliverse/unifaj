CREATE DATABASE Filme;
USE Filme;

CREATE TABLE filme (
	id INT NOT NULL PRIMARY KEY,
    titulo VARCHAR(80) NOT NULL
);

CREATE TABLE personagem (
	id INT NOT NULL PRIMARY KEY,
    nome VARCHAR(100),
    caracteristicas VARCHAR(50),
    id_filme INT NOT NULL,
    FOREIGN KEY (id_filme) REFERENCES filme(id)
);

INSERT INTO filme VALUES 
(1, 'A Dama e o Vagabundo'),(2, 'Toy Story');


INSERT INTO personagem VALUES 
(1, 'Mickey Mouse', 'elegante', 1),
(2, 'Nala', 'Inteligente', 2),
(3, 'Baloo', 'Forte', 1);

SELECT * FROM personagem WHERE caracteristicas = 'elegante';

SELECT f.titulo, COUNT(p.id) AS quantidade_personagens FROM filme f LEFT JOIN personagem p ON f.id = p.id_filme
GROUP BY f.titulo;

UPDATE filme
SET titulo = 'Vida de Inseto'
WHERE id = 1;

DELETE FROM personagem
WHERE id = 3;

SELECT f.titulo, p.nome, p.caracteristicas FROM filme f INNER JOIN personagem p ON f.id = p.id_filme
ORDER BY f.titulo ASC, p.nome DESC;

ALTER TABLE filme ADD ano_lancamento INT;

ALTER TABLE filme MODIFY ano_lancamento DATE;













