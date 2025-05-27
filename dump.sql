-- Criação do Banco de Dados
CREATE DATABASE IF NOT EXISTS loja;
USE loja;

-- Tabela Cliente
CREATE TABLE IF NOT EXISTS cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(20)
);

-- Tabela Funcionario
CREATE TABLE IF NOT EXISTS funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(50),
    salario DOUBLE
);

-- Tabela Produto
CREATE TABLE IF NOT EXISTS produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE,
    estoque INT
);

-- Tabela Pedido
CREATE TABLE IF NOT EXISTS pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255),
    valor_total DOUBLE
);

-- Dados de exemplo

INSERT INTO cliente (nome, email, telefone) VALUES
('Ana Silva', 'ana@gmail.com', '11999999999'),
('Bruno Souza', 'bruno@gmail.com', '11988888888');

INSERT INTO funcionario (nome, cargo, salario) VALUES
('Carlos Lima', 'Vendedor', 2500.00),
('Fernanda Rocha', 'Gerente', 4500.00);

INSERT INTO produto (nome, preco, estoque) VALUES
('Notebook', 3500.00, 10),
('Mouse', 80.00, 50),
('Teclado', 120.00, 40);

INSERT INTO pedido (descricao, valor_total) VALUES
('Pedido de Ana Silva', 3580.00),
('Pedido de Bruno Souza', 80.00);
