-- Inserir motoristas de teste
INSERT INTO tbl_motoristas (nome, cnh, endereco, contato)
VALUES 
    ('João Silva', '12345678901', 'Rua A, 123, São Paulo', '(11) 98765-4321'),
    ('Maria Santos', '98765432109', 'Av B, 456, Rio de Janeiro', '(21) 98765-4321'),
    ('Carlos Oliveira', '45678901234', 'Rua C, 789, Curitiba', '(41) 98765-4321');

-- Inserir clientes de teste
INSERT INTO tbl_clientes (nome, empresa, endereco, contato)
VALUES 
    ('Amanda Costa', 'TechCorp', 'Rua X, 100, São Paulo', '(11) 91234-5678'),
    ('Ricardo Souza', 'LogiTech', 'Av Y, 200, Rio de Janeiro', '(21) 91234-5678'),
    ('Patricia Lima', 'TransportesBR', 'Rua Z, 300, Curitiba', '(41) 91234-5678');

-- Inserir pedidos de teste
INSERT INTO tbl_pedidos (id_cliente, id_motorista, pedido_data, pedido_detalhes)
VALUES 
    (1, 1, DATEADD(day, 2, GETDATE()), 'Entrega de equipamentos eletrônicos - 10 caixas'),
    (2, 2, DATEADD(day, 1, GETDATE()), 'Transporte de materiais de escritório'),
    (3, 3, DATEADD(day, 1, GETDATE()), 'Entrega expressa de documentos');
    
    -- UPDATE: Atualizar status de um pedido para 'concluido'
UPDATE tbl_pedidos
SET 
    status = 'concluido',
    entrega_data = GETDATE(),
    entrega_detalhes = 'Entrega realizada com sucesso'
WHERE id = 1;

-- UPDATE: Atualizar informações de contato de um cliente
UPDATE tbl_clientes
SET 
    contato = '(11) 99999-8888',
    endereco = 'Nova Rua X, 200, São Paulo'
WHERE id = 1;

-- UPDATE: Atualizar status de um motorista para 'inativo'
UPDATE tbl_motoristas
SET 
    status = 'inativo'
WHERE id = 2;

-- DELETE: Remover um pedido (apenas se necessário e se não violar integridade referencial)
DELETE FROM tbl_pedidos
WHERE id = 3;

-- Consulta para verificar as alterações
SELECT 'Pedidos' as tabela, COUNT(*) as registros FROM tbl_pedidos
UNION ALL
SELECT 'Clientes', COUNT(*) FROM tbl_clientes
UNION ALL
SELECT 'Motoristas', COUNT(*) FROM tbl_motoristas;

-- Verificar detalhes do pedido atualizado
SELECT 
    tbl_pedidos.id,
    tbl_clientes.nome as cliente,
    tbl_motoristas.nome as motorista,
    tbl_pedidos.status,
    tbl_pedidos.entrega_data,
    tbl_pedidos.entrega_detalhes
FROM tbl_pedidos
JOIN tbl_clientes ON tbl_pedidos.id_cliente = tbl_clientes.id
JOIN tbl_motoristas ON tbl_pedidos.id_motorista = tbl_motoristas.id
WHERE tbl_pedidos.id = 1;