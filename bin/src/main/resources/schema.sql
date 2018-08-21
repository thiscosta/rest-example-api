drop table if exists usuario_grupo;
drop table if exists usuario_permissao;
drop table if exists grupo_permissao;
drop table if exists permissao;
drop table if exists grupo;
drop table if exists usuario;
drop table if exists cliente;
drop table if exists produto;
drop table if exists item;
drop table if exists venda;

create table if not exists usuario (
	id bigint not null auto_increment,
	nome varchar(100) not null,
	login varchar(50) not null,
	senha varchar(100) not null,
	ativo boolean default false,
	permissao varchar(15),
	primary key (id),
	unique key un_usuario_login (login)
);


create table if not exists cliente (
	id bigint not null auto_increment,
	nome varchar(120),
	cpf varchar(15),
	endereco varchar(150),
	usuario_id bigint not null,
	primary key(id, usuario_id),
	constraint fk_cliente_usuario foreign key (usuario_id) references usuario(id)
);

create table if not exists produto(
	id bigint not null auto_increment,
	nome varchar(100),
	descricao varchar(500),
	preco double,
	primary key(id)	
);

create table if not exists venda(
	id bigint not null auto_increment,
	cliente_id bigint not null,
	total double,
	frete double,
	primary key(id, cliente_id),
	constraint fk_venda_cliente foreign key (cliente_id) references cliente(id),
);

create table if not exists item(
	id bigint not null auto_increment,
	produto_id bigint not null,
	quantidade bigint not null,
	total double,
	venda_id bigint not null,
	primary key(id, produto_id,venda_id),
	constraint fk_item_produto foreign key(produto_id) references produto(id),
	constraint fk_item_venda foreign key (venda_id) references venda(id)
);



