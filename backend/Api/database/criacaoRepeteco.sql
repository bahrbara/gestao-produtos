CREATE TABLE Anuncio (
    id_anuncio INTEGER PRIMARY KEY,
    id_escola INTEGER,
    id_client INTEGER,
    titulo VARCHAR,
    descricao VARCHAR,
    dt_inicial DATE,
    dt_final DATE,
    valor VARCHAR,
    tamanho VARCHAR,
    conservacao VARCHAR,
    imagem1 BYTEA,
    imagem2 BYTEA,
    imagem3 BYTEA,
    imagem4 BYTEA,
    imagem5 BYTEA,
    type VARCHAR,
    UNIQUE (id_anuncio)
);

CREATE TABLE Client (
    id_client INTEGER PRIMARY KEY,
    name VARCHAR,
    cpf VARCHAR,
    gender CHAR CHECK (gender='F' OR gender='M'),
    age INTEGER,
    birth_date DATE,
    email VARCHAR,
    phone_number VARCHAR,
    address VARCHAR,
    password VARCHAR,
    type VARCHAR DEFAULT 'user',
    UNIQUE (id_client, cpf, email)
);

CREATE TABLE Escola (
    id_escola INTEGER PRIMARY KEY,
    name VARCHAR,
    neighborhood VARCHAR,
    city VARCHAR,
    UNIQUE (id_escola, name)
);

ALTER TABLE Anuncio ADD CONSTRAINT FK_Anuncio_0
    FOREIGN KEY (id_client)
    REFERENCES Client (id_client);
 
ALTER TABLE Anuncio ADD CONSTRAINT FK_Anuncio_1
    FOREIGN KEY (id_escola)
    REFERENCES Escola (id_escola);

CREATE SEQUENCE hibernate_sequence START 1;