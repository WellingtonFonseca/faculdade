--CREATE DATABASE db_logi_move;
--GO
-- USE db_logi_move;
-- GO

-- Criar tabela de Motoristas
DROP TABLE IF EXISTS tbl_motoristas;

CREATE TABLE tbl_motoristas (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnh VARCHAR(20) NOT NULL UNIQUE,
    endereco VARCHAR(200) NOT NULL,
    contato VARCHAR(50) NOT NULL,
    data_contratacao DATE DEFAULT GETDATE(),
    status VARCHAR(20) DEFAULT 'ativo'
);

-- Criar tabela de Clientes
DROP TABLE IF EXISTS tbl_clientes;

CREATE TABLE tbl_clientes (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    empresa VARCHAR(100) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    contato VARCHAR(50) NOT NULL,
    data_cadastro DATE DEFAULT GETDATE(),
    status VARCHAR(20) DEFAULT 'ativo'
);

-- Criar tabela de Pedidos
DROP TABLE IF EXISTS tbl_pedidos;

CREATE TABLE tbl_pedidos (
    id INT IDENTITY(1,1) PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_motorista INT,
    pedido_data DATE DEFAULT GETDATE(),
    pedido_detalhes TEXT NOT NULL,
    entrega_data DATE,
    entrega_detalhes TEXT,
    Status VARCHAR(50) DEFAULT 'pendente',
    FOREIGN KEY (id_cliente) REFERENCES tbl_clientes(id),
    FOREIGN KEY (id_motorista) REFERENCES tbl_motoristas(id)
);

-- Criar índices para melhorar performance
CREATE INDEX idx_motorista_status ON tbl_motoristas(status);
CREATE INDEX idx_clientes_empresa ON tbl_clientes(empresa);
CREATE INDEX idx_pedidos_status ON tbl_pedidos(Status);
CREATE INDEX idx_pedidos_datas ON tbl_pedidos(pedido_data, entrega_data);