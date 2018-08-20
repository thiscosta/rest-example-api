insert into usuario (nome, login, senha, ativo,permissao) values ('Administrador', 'admin', '123', true, 'ROLE_ADMIN'), ('Usuario', 'user', '123', true, 'ROLE_USER');

insert into cliente (nome, cpf, endereco, usuario_id) values ('Cliente 1', '123456789-00','Rua Luiza Lopes Garcia',1), ('Cliente 2', '987654321-00','Rua Vilson de Oliveira',2);

insert into produto (nome, descricao, preco) values ('UltraBook', 'Notebook para uso pessoal', 4000), ('iPhone X', 'Smartphone da Apple', 8000), ('SanDisk Cruzer Blade', 'PenDrive de 16GB', 80);

insert into venda (cliente_id, total, frete) values (1,8000,100), (1,8000,100) , (2,800,50), (2,20000,400);

insert into item (produto_id, quantidade, total, venda_id) values (1, 2, 8000, 1),(1, 3, 12000, 1), (2, 1, 8000,2), (3,10,800,3), (1,5,20000,4);



