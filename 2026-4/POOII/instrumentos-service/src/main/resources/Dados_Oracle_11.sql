--Oracle 11
CREATE TABLE Instrumento (
    id INTEGER,
    nome VARCHAR2(50) NOT NULL,
    tipo VARCHAR2(50) NOT NULL,
    descricao VARCHAR2(100) NOT NULL,
    preco number(10,2) NOT NULL
);
ALTER TABLE Instrumento ADD ( CONSTRAINT id_pk PRIMARY KEY (id) );
CREATE SEQUENCE instrumento_sequence;
CREATE OR REPLACE TRIGGER Intrumento_on_insert
  BEFORE INSERT ON Instrumento
  FOR EACH ROW
BEGIN
  SELECT instrumento_sequence.nextval
  INTO :new.id
  FROM dual;
END;


INSERT INTO Instrumento (nome, tipo, descricao, preco) VALUES ('Violao Cordas', 'Violão', 'Violao Cordas', 500.5);
INSERT INTO Instrumento (nome, tipo, descricao, preco) VALUES ('Teclado Yamara', 'Teclado', 'Teclado Yamara', 900.0);
INSERT INTO Instrumento (nome, tipo, descricao, preco) VALUES ('Tecaldo Korn', 'Tecaldo', 'Tecaldo Korn', 1200.3);


CREATE TABLE Usuario (
    id INTEGER NOT NULL,
    usuario VARCHAR2(50) NOT NULL,
    senha VARCHAR2(50) NOT NULL,
    server VARCHAR2(100),
    token VARCHAR2(100)
);

ALTER TABLE Usuario ADD ( CONSTRAINT id_pk PRIMARY KEY (id) );
CREATE SEQUENCE usuario_sequence;
CREATE OR REPLACE TRIGGER Usuario_on_insert
  BEFORE INSERT ON Usuario
  FOR EACH ROW
BEGIN
  SELECT usuario_sequence.nextval
  INTO :new.id
  FROM dual;
END;

INSERT INTO Usuario (usuario, senha, server, token) VALUES ('maria', '123', '192.168.1.167', null);


