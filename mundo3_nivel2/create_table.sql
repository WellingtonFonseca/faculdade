CREATE TABLE public.usuarios (
	id bigserial NOT NULL,
	usuario varchar(100) NOT NULL,
	senha varchar(100) NOT NULL,
	email_contato varchar(100) NOT NULL,
	nome_completo varchar(100) NOT NULL,
	CONSTRAINT usuarios_pk PRIMARY KEY (id),
	CONSTRAINT usuarios_unique UNIQUE (usuario)
);

CREATE TABLE public.produto (
	id bigserial NOT NULL,
	nome varchar(100) NOT NULL,
	preco_venda float4 DEFAULT 0 NOT NULL,
	quantidade int4 DEFAULT 0 NOT NULL,
	CONSTRAINT produto_id PRIMARY KEY (id)
);

CREATE TABLE public.pessoa (
	id bigserial NOT NULL,
	tipo varchar(20) NOT NULL,
	nome varchar(100) NOT NULL,
	logradouro varchar(150) NOT NULL,
	email varchar(100) NOT NULL,
	telefone varchar(20) NOT NULL,
	CONSTRAINT pessoa_pk PRIMARY KEY (id)
);

CREATE TABLE public.pessoa_fisica (
	id bigserial NOT NULL,
	cpf varchar(20) NOT NULL,
	CONSTRAINT pessoa_fisica_pk PRIMARY KEY (id),
	CONSTRAINT pessoa_fisica_unique UNIQUE (cpf),
	CONSTRAINT pessoa_fisica_pessoa_fk FOREIGN KEY (id) REFERENCES public.pessoa(id) ON DELETE CASCADE
);

CREATE TABLE public.pessoa_juridica (
	id bigserial NOT NULL,
	cpnj varchar(20) NOT NULL,
	CONSTRAINT pessoa_juridica_pk PRIMARY KEY (id),
	CONSTRAINT pessoa_juridica_unique UNIQUE (cpnj),
	CONSTRAINT pessoa_juridica_pessoa_fk FOREIGN KEY (id) REFERENCES public.pessoa(id) ON DELETE CASCADE
);

CREATE TABLE public.movimentos (
	id bigserial NOT NULL,
	id_usuario bigserial NOT NULL,
	id_pessoa bigserial NOT NULL,
	quantidade int4 NOT NULL,
	preco float4 NOT NULL,
	data_movimento timestamp NOT NULL,
	id_produto bigserial NOT NULL,
	tipo varchar(20) NOT NULL,
	CONSTRAINT movimentos_pk PRIMARY KEY (id),
	CONSTRAINT movimentos_pessoa_fk FOREIGN KEY (id_pessoa) REFERENCES public.pessoa(id),
	CONSTRAINT movimentos_produto_fk FOREIGN KEY (id_produto) REFERENCES public.produto(id),
	CONSTRAINT movimentos_usuarios_fk FOREIGN KEY (id_usuario) REFERENCES public.usuarios(id) ON DELETE CASCADE
);