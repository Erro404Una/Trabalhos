


#FERRAMENTAS
GitHub Desktop
Postman
Visual Studio Code
MySQL

#Extensão
LiveShare

#FRAMEWORKS
MAVEM

#Comandos MySQL

-- Criação do Banco de Dados
CREATE DATABASE locadoradeveiculos;
USE locadoradeveiculos;

-- Criação da Tabela Associado
CREATE TABLE Associado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cpf VARCHAR(15) NOT NULL
);

-- Criação da Tabela TabelaPrecos
CREATE TABLE TabelaPrecos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    categoria ENUM('Sedã', 'Picape', 'Hatch', 'Esportivo', 'SUV') NOT NULL UNIQUE,
    preco_por_dia DECIMAL(10, 2) NOT NULL
);

-- Criação da Tabela Veiculos
CREATE TABLE Veiculos (    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    placa VARCHAR(10) NOT NULL,
    disponivel TINYINT(1) NOT NULL,
    categoria ENUM('Sedã', 'Picape', 'Hatch', 'Esportivo', 'SUV') NOT NULL,
    url_veiculo VARCHAR(500),
    preco DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_categoria FOREIGN KEY (categoria) REFERENCES TabelaPrecos(categoria)
);