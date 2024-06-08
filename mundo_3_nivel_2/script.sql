-- Dados completos de pessoas físicas.
select *
from
	pessoa
where
	tipo = 'pf';

-- Dados completos de pessoas jurídicas.
select *
from
	pessoa
where
	tipo = 'pj';

-- Movimentações de entrada, com produto, fornecedor, quantidade, preço unitário e valor total.
select
	a.tipo
	, c.nome produto
	, b.nome  fornecedor
	, a.quantidade 
	, a.preco 
	, a.quantidade * a.preco valor_total 
from
	movimentos a
inner join
	pessoa b
on
	a.id_pessoa  = b.id
inner join
	produto c
on
	a.id_produto = c.id
where
	a.tipo = 'e'
group by
	a.tipo
	, c.nome
	, b.nome
	, a.quantidade 
	, a.preco ;

-- Movimentações de saída, com produto, comprador, quantidade, preço unitário e valor total.
select
	a.tipo
	, c.nome produto
	, b.nome  comprador
	, a.quantidade 
	, a.preco 
	, a.quantidade * a.preco valor_total 
from
	movimentos a
inner join
	pessoa b
on
	a.id_pessoa  = b.id
inner join
	produto c
on
	a.id_produto = c.id
where
	a.tipo = 's'
group by
	a.tipo
	, c.nome
	, b.nome
	, a.quantidade 
	, a.preco ;

-- Valor total das entradas agrupadas por produto.
select
	a.tipo
	, c.nome produto
	, a.quantidade * a.preco valor_total 
from
	movimentos a
inner join
	pessoa b
on
	a.id_pessoa  = b.id
inner join
	produto c
on
	a.id_produto = c.id
where
	a.tipo = 'e'
group by
	a.tipo
	, c.nome
	, a.quantidade 
	, a.preco ;

-- Valor total das saídas agrupadas por produto.
select
	a.tipo
	, c.nome produto
	, a.quantidade * a.preco valor_total 
from
	movimentos a
inner join
	pessoa b
on
	a.id_pessoa  = b.id
inner join
	produto c
on
	a.id_produto = c.id
where
	a.tipo = 's'
group by
	a.tipo
	, c.nome
	, a.quantidade 
	, a.preco ;

-- Operadores que não efetuaram movimentações de entrada (compra).
select *
from
	usuarios a
where
	a.id not in (
		select
			id_usuario
		from
			movimentos
		where
			tipo = 'e'
	);

-- Valor total de entrada, agrupado por operador.
select
	id_usuario
	, quantidade * preco valor_total
from
	movimentos
where
	tipo = 'e'
group by
	id_usuario
	, quantidade
	, preco
			
-- Valor total de saída, agrupado por operador.
select
	id_usuario
	, quantidade * preco valor_total
from
	movimentos
where
	tipo = 's'
group by
	id_usuario
	, quantidade
	, preco
	
-- Valor médio de venda por produto, utilizando média ponderada.
select
	id_produto 
	, sum(quantidade * preco) / sum(quantidade) valor_total
from
	movimentos
where
	tipo = 's'
group by
	id_produto
	, quantidade
	, preco