CREATE DATABASE AdultoPessoa; 
USE AdultoPessoa;

CREATE TABLE Adulto(
	id INT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
	data_nascimento DATE NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    estado_civil VARCHAR(20) NOT NULL
);

CREATE TABLE Bebe(
	id INT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
	id_Adulto INT,
    FOREIGN KEY (id_Adulto) REFERENCES Adulto(id)
);

INSERT INTO Adulto VALUES (1, 'Ana', '2000-05-10', 'F', 'solteiro');
INSERT INTO Adulto VALUES (2, 'Bruno', '1995-03-20', 'M', 'casado');
INSERT INTO Adulto VALUES (3, 'Carla', '2001-07-15', 'F', 'solteiro');
INSERT INTO Adulto VALUES (4, 'Daniel', '1990-11-02', 'M', 'divorciado');
INSERT INTO Adulto VALUES (5, 'Eduarda', '1998-09-25', 'F', 'casado');
INSERT INTO Adulto VALUES (6, 'Felipe', '1993-06-18', 'M', 'solteiro');
INSERT INTO Adulto VALUES (7, 'Gabriela', '1997-01-30', 'F', 'casado');
INSERT INTO Adulto VALUES (8, 'Henrique', '1989-12-12', 'M', 'solteiro');
INSERT INTO Adulto VALUES (9, 'Isabela', '1996-04-08', 'F', 'divorciado');
INSERT INTO Adulto VALUES (10, 'João', '1992-08-22', 'M', 'casado');

INSERT INTO Bebe VALUES (1, 'Lucas', 1);
INSERT INTO Bebe VALUES (2, 'Maria', 1);
INSERT INTO Bebe VALUES (3, 'Pedro', 3);
INSERT INTO Bebe VALUES (4, 'Julia', 5);
INSERT INTO Bebe VALUES (5, 'Rafael', 7);
INSERT INTO Bebe VALUES (6, 'Sofia', 2);
INSERT INTO Bebe VALUES (7, 'Miguel', 9);
INSERT INTO Bebe VALUES (8, 'Helena', 6);

SELECT * FROM Adulto
WHERE estado_civil = 'solteiro';

SELECT * FROM Adulto
WHERE sexo = 'F';

SELECT nome FROM Bebe WHERE MOD(id, 2) = 1 AND MOD(id_Adulto, 2) = 1;

SELECT a.*, b.* FROM Adulto a INNER JOIN Bebe b 
ON a.id = b.id_Adulto;

SELECT b.nome AS bebe, a.nome AS adulto FROM Bebe b INNER JOIN Adulto a 
ON b.id_Adulto = a.id;

SELECT a.nome, a.estado_civil, b.nome AS bebe FROM Adulto a LEFT JOIN Bebe b 
ON a.id = b.id_Adulto;

