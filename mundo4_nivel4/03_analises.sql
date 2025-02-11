-- Relatório de eficiência de entrega por motorista
SELECT 
    tbl_motoristas.nome as motorista,
    COUNT(tbl_pedidos.id) as total_entregas,
    AVG(DATEDIFF(day, tbl_pedidos.entrega_data, tbl_pedidos.pedido_data)) as media_dias_entrega,
    COUNT(CASE WHEN tbl_pedidos.status = 'pendente' THEN 1 END) as entregas_pendentes,
    COUNT(CASE WHEN tbl_pedidos.status = 'concluido' THEN 1 END) as entregas_concluidas
FROM tbl_motoristas
LEFT JOIN tbl_pedidos ON tbl_motoristas.id = tbl_pedidos.id_motorista
GROUP BY tbl_motoristas.nome
ORDER BY total_entregas DESC;

-- Análise de clientes por volume de pedidos
SELECT 
    tbl_clientes.empresa,
    COUNT(tbl_pedidos.id) as total_pedidos,
    MAX(tbl_pedidos.pedido_data) as ultimo_pedido,
    AVG(DATEDIFF(day, tbl_pedidos.entrega_data, tbl_pedidos.pedido_data)) as tempo_medio_entrega
FROM tbl_clientes
LEFT JOIN tbl_pedidos ON tbl_clientes.id = tbl_pedidos.id_cliente
GROUP BY tbl_clientes.empresa
ORDER BY total_pedidos DESC;

-- Dashboard diário
SELECT
    COUNT(CASE WHEN tbl_pedidos.status = 'pendente' THEN 1 END) as pedidos_pendentes,
    COUNT(CASE WHEN tbl_pedidos.status = 'concluido' THEN 1 END) as pedidos_concluidos,
    COUNT(CASE WHEN tbl_pedidos.entrega_data < GETDATE() AND tbl_pedidos.status = 'pendente' THEN 1 END) as pedidos_atrasados,
    COUNT(DISTINCT tbl_pedidos.id_motorista) as motoristas_ativos,
    COUNT(DISTINCT tbl_pedidos.id_cliente) as clientes_ativos
FROM tbl_pedidos
WHERE tbl_pedidos.pedido_data >= DATEADD(day, -30, GETDATE());