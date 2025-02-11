-- Consultar pedidos pendentes com detalhes do cliente e motorista
SELECT 
    tbl_pedidos.id,
    tbl_clientes.nome as cliente,
    tbl_clientes.empresa,
    tbl_motoristas.Nome as motorista,
    tbl_pedidos.pedido_detalhes,
    tbl_pedidos.entrega_data,
    tbl_pedidos.status
FROM tbl_pedidos
JOIN tbl_clientes ON tbl_pedidos.id_cliente = tbl_clientes.id
LEFT JOIN tbl_motoristas ON tbl_pedidos.id_motorista = tbl_motoristas.id
WHERE tbl_pedidos.status = 'pendente'
ORDER BY tbl_pedidos.entrega_data;

-- Consultar quantidade de pedidos por cliente
SELECT 
    tbl_clientes.nome,
    tbl_clientes.empresa,
    COUNT(tbl_pedidos.id) as total_pedidos
FROM tbl_clientes
LEFT JOIN tbl_pedidos ON tbl_clientes.id = tbl_pedidos.id_cliente
GROUP BY tbl_clientes.nome, tbl_clientes.empresa;

-- Consultar motoristas disponíveis (sem pedidos pendentes)
SELECT 
    tbl_motoristas.nome,
    tbl_motoristas.cnh,
    tbl_motoristas.contato
FROM tbl_motoristas
WHERE NOT EXISTS (
    SELECT 1 FROM tbl_pedidos
    WHERE tbl_pedidos.id_motorista = tbl_motoristas.id
    AND tbl_pedidos.status = 'pendente'
);