-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

with nova_pessoa as (insert into pessoa_juridica (nome, cnpj, telefone) values('Kabum', '12345678901234', '123456789') returning id) insert into fornecedor (id) select id from nova_pessoa;
with nova_pessoa as (insert into pessoa_juridica (nome, cnpj, telefone) values('Terabyte', '98765432109876', '987654321') returning id) insert into fornecedor (id) select id from nova_pessoa;
insert into memoria (marca, modelo, gigas, velocidade, fornecedor_id) values('Kingston', 'DDR4', '16GB', '3600Mhz', 1);
insert into memoria (marca, modelo, gigas, velocidade, fornecedor_id) values('Corsair', 'DDR5', '32GB', '5600Mhz', 2);
insert into memoria (marca, modelo, gigas, velocidade, fornecedor_id) values('Aitek', 'DDR3', '8GB', '1600Mhz', 1);
insert into memoria (marca, modelo, gigas, velocidade, fornecedor_id) values('T-Force', 'DDR4', '8GB', '3200Mhz', 2);