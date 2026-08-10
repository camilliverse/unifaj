CREATE DATABASE faculdade;

USE faculdade;

CREATE TABLE aluno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    sexo CHAR(1) NOT NULL,
    data_nascimento DATE NOT NULL
);

CREATE TABLE disciplina (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    semestre INT NOT NULL
);

CREATE TABLE aluno_disciplina (
    id_aluno INT,
    id_disciplina INT,

    PRIMARY KEY (id_aluno, id_disciplina),

    FOREIGN KEY (id_aluno) REFERENCES aluno(id),
    FOREIGN KEY (id_disciplina) REFERENCES disciplina(id)
);

INSERT INTO aluno (nome, sexo, data_nascimento) VALUES
('Camila Silva', 'F', '2005-03-15'),
('João Santos', 'M', '2004-07-20'),
('Maria Oliveira', 'F', '2005-11-10'),
('Pedro Souza', 'M', '2003-02-25');

INSERT INTO disciplina (nome, semestre) VALUES
('Banco de Dados', 2),
('Algoritmos e Estruturas de Dados', 1),
('Programação Orientada a Objetos', 3),
('Engenharia de Software', 4),
('Redes de Computadores', 5),
('Desenvolvimento de android', 7);

INSERT INTO aluno_disciplina (id_aluno, id_disciplina) VALUES
(1, 1),
(1, 2),
(1, 3),

(2, 1),
(2, 4),
(2, 5),

(3, 2),
(3, 3),
(3, 5);

SELECT *
FROM aluno;

SELECT *
FROM aluno
WHERE sexo = 'M';

ALTER TABLE aluno
ADD formado BOOLEAN;

UPDATE aluno
SET formado = FALSE
WHERE id > 0;

SELECT nome, formado
FROM aluno
WHERE sexo = 'F';

UPDATE aluno
SET nome = 'Nome alterado'
WHERE id = 3;

INSERT INTO aluno (nome, sexo, data_nascimento)
VALUES ('Ana Costa', 'F', '2006-08-12');

SELECT aluno.nome AS aluno, disciplina.nome AS disciplina FROM aluno INNER JOIN aluno_disciplina ON aluno.id = aluno_disciplina.id_aluno
INNER JOIN disciplina ON disciplina.id = aluno_disciplina.id_disciplina;

SELECT aluno.id AS id_aluno, aluno.nome AS nome_aluno, aluno.data_nascimento, disciplina.id AS id_disciplina, disciplina.nome AS nome_disciplina FROM aluno
LEFT JOIN aluno_disciplina ON aluno.id = aluno_disciplina.id_aluno
LEFT JOIN disciplina ON disciplina.id = aluno_disciplina.id_disciplina;

INSERT INTO disciplina (nome, semestre)
VALUES ('Inteligência Artificial', 6);

SELECT aluno.id AS id_aluno, aluno.nome AS nome_aluno, disciplina.id AS id_disciplina, disciplina.nome AS nome_disciplina FROM aluno LEFT JOIN aluno_disciplina ON aluno.id = aluno_disciplina.id_aluno
LEFT JOIN disciplina ON disciplina.id = aluno_disciplina.id_disciplina

UNION

SELECT aluno.id AS id_aluno, aluno.nome AS nome_aluno, disciplina.id AS id_disciplina, disciplina.nome AS nome_disciplina FROM aluno
RIGHT JOIN aluno_disciplina ON aluno.id = aluno_disciplina.id_aluno
RIGHT JOIN disciplina ON disciplina.id = aluno_disciplina.id_disciplina;

SELECT nome FROM disciplina WHERE semestre % 2 <> 0;

SELECT id, nome FROM disciplina WHERE nome LIKE '%de%';

SELECT DISTINCT aluno.nome FROM aluno INNER JOIN aluno_disciplina ON aluno.id = aluno_disciplina.id_aluno
INNER JOIN disciplina ON disciplina.id = aluno_disciplina.id_disciplina
WHERE disciplina.semestre IN (1, 3, 5, 7);