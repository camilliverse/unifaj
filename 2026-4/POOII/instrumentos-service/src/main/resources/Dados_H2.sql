CREATE TABLE Instrumento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    preco number(10,2) NOT NULL
);

INSERT INTO Instrumento (nome, tipo, descricao, preco) VALUES ('Violão Cordas', 'Violão', '', 500.5);
INSERT INTO Instrumento (nome, tipo, descricao, preco) VALUES ('Teclado Yamara', 'Teclado', '', 900.0);
INSERT INTO Instrumento (nome, tipo, descricao, preco) VALUES ('Teclado Korn', 'Teclado', '', 1200.3);


CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    server VARCHAR(100),
    token VARCHAR(100)
);

INSERT INTO Usuario (usuario, senha, server, token) VALUES ('maria', '123', '192.168.1.167', null);

CREATE TABLE IMAGENS (
   id INT AUTO_INCREMENT PRIMARY KEY,
   arquivo VARCHAR(255) UNIQUE NOT NULL,
   type INT NOT NULL,
   data BLOB NOT NULL
);
--Não dá para gerar um INSERT na imagens porque este arquivo é binário.
