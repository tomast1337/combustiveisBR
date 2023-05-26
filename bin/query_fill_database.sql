/*
Query para popular banco de dados

As informações abaixo são ficcionais, criadas apenas para fins de 
testes de inserção e manipulação de dados no database.
Os números de CPNJ, CPF e telefones foram gerados aleatoriamente através
do serviço hospedado em www.4devs.com  
*/

# Table Company
insert into company (country, email, phone_number, state, business_relationship, cnpj, corporate_name) values ('Brazil', 'companysp@email.com', '(12) 2072-1216', 'SP', 'CUSTOMER', '32752152000137', 'SP Company Ltda.');
insert into company (country, email, phone_number, state, business_relationship, cnpj, corporate_name) values ('Brazil', 'spenterprise@email.com', '(12) 3431-2901', 'SP', 'SUPPLIER', '00925854000189', 'Enterprise SP S.A.');
insert into company (country, email, phone_number, state, business_relationship, cnpj, corporate_name) values ('Brazil', 'baenterprise@email.com', '(74) 3227-2555', 'BA', 'CUSTOMER', '04017753000160', 'BA Enterprise S.A.');
insert into company (country, email, phone_number, state, business_relationship, cnpj, corporate_name) values ('Brazil', 'companyrj@email.com', '(22) 3739-4531', 'RJ', 'CUSTOMER', '60859477000159', 'RJ Company Ltda.');
insert into company (country, email, phone_number, state, business_relationship, cnpj, corporate_name) values ('Brazil', 'rjenterprise@email.com', '(21) 2170-1569', 'RJ', 'SUPPLIER', '20540593000196', 'RJ Enterprise S.A.');
insert into company (country, email, phone_number, state, business_relationship, cnpj, corporate_name) values ('Brazil', 'companyce@email.com', '(88) 2136-0179', 'CE', 'CUSTOMER', '85102784000111', 'CE Company Ltda.');
insert into company (country, email, phone_number, state, business_relationship, cnpj, corporate_name) values ('Brazil', 'companymg@email.com', '(37) 3596-8635', 'MG', 'CUSTOMER', '30178362000138', 'MG Company Ltda.');
insert into company (country, email, phone_number, state, business_relationship, cnpj, corporate_name) values ('Brazil', 'mgenterprise@email.com', '(37) 3384-4247', 'MG', 'SUPPLIER', '58930617000196', 'MG Enterprise S.A.');
insert into company (country, email, phone_number, state, business_relationship, cnpj, corporate_name) values ('Brazil', 'companyms@email.com', '(67) 3406-8217', 'MS', 'CUSTOMER', '83184166000132', 'MS Company Ltda.');
insert into company (country, email, phone_number, state, business_relationship, cnpj, corporate_name) values ('Brazil', 'companydf@email.com', '(61) 2147-4626', 'DF', 'CUSTOMER', '41304759000145', 'DF Company Ltda.');

# Table Employee
insert into employee (country, email, phone_number, state, cpf, name, password, position, role, status) values ('Brazil', 'maria@email.com', '(18) 99833-5828', 'SP','58383355050', 'Maria Silva', '1234', 'Analista Adm', 'USER', 1);
insert into employee (country, email, phone_number, state, cpf, name, password, position, role, status) values ('Brazil', 'jose@email.com', '(13) 98141-3954', 'SP','13055891066', 'José Alves', '1234', 'Analista Adm', 'USER', 1);
insert into employee (country, email, phone_number, state, cpf, name, password, position, role, status) values ('Brazil', 'carlos@email.com', '(22) 98619-5073', 'RJ','73735872085', 'Carlos Pereira', '1234', 'Analista Adm', 'USER', 1);
insert into employee (country, email, phone_number, state, cpf, name, password, position, role, status) values ('Brazil', 'cristina@email.com', '(24) 99287-6888', 'RJ','24657534017', 'Cristina Mendes', '1234', 'Analista Adm', 'USER', 1);
insert into employee (country, email, phone_number, state, cpf, name, password, position, role, status) values ('Brazil', 'ricardo@email.com', '(85) 98481-6311', 'CE','34698083095', 'Ricardo Dantas', '1234', 'Analista Adm', 'USER', 1);
insert into employee (country, email, phone_number, state, cpf, name, password, position, role, status) values ('Brazil', 'flavia@email.com', '(85) 98252-5818', 'CE','21602645043', 'Flavia Oliveira', '1234', 'Analista Adm', 'USER', 1);
insert into employee (country, email, phone_number, state, cpf, name, password, position, role, status) values ('Brazil', 'mauricio@email.com', '(75) 98076-0824', 'BA','10230069010', 'Mauricio Costa', '1234', 'Analista Adm', 'USER', 1);
insert into employee (country, email, phone_number, state, cpf, name, password, position, role, status) values ('Brazil', 'ana@email.com', '(61) 97116-4561', 'DF','12932880047', 'Ana Correia', '1234', 'Analista Adm', 'USER', 1);
insert into employee (country, email, phone_number, state, cpf, name, password, position, role, status) values ('Brazil', 'felipe@email.com', '(37) 99453-6377', 'MG','24522720009', 'Felipe Santos', '1234', 'Analista Adm', 'USER', 1);
insert into employee (country, email, phone_number, state, cpf, name, password, position, role, status) values ('Brazil', 'antonio@email.com', '(67) 98264-1794', 'MS','29907799068', 'Antonio Ferreira', '1234', 'Analista Adm', 'USER', 1);

# Table Product
insert into product (category, name, price, stock, storage_capacity) values ('REGULAR_GASOLINE', 'Gasolina Comum', 5.50, 500000.0, 500000.0);
insert into product (category, name, price, stock, storage_capacity) values ('ADD_GASOLINE', 'Gasolina Aditivada', 6.50, 500000.0, 500000.0);
insert into product (category, name, price, stock, storage_capacity) values ('PREMIUM_GASOLINE', 'Gasolina Premium', 7.50, 500000.0, 500000.0);
insert into product (category, name, price, stock, storage_capacity) values ('REFORMULATED_GASOLINE', 'Gasolina Formulada', 6.50, 500000.0, 500000.0);
insert into product (category, name, price, stock, storage_capacity) values ('ETHANOL', 'Etanol', 4.20, 500000.0, 500000.0);
insert into product (category, name, price, stock, storage_capacity) values ('CNG', 'GNV - Gás Natural Veicular', 3.80, 500000.0, 500000.0);
insert into product (category, name, price, stock, storage_capacity) values ('DIESEL', 'Diesel', 6.70, 500000.0, 500000.0);

# Table Orders
insert into orders (order_date, total_value, type, company_id) values ('2023-01-01', 38500.0, 'SALE', 1);
insert into orders (order_date, total_value, type, company_id) values ('2023-02-02', 325000.0, 'PURCHASE', 2);
insert into orders (order_date, total_value, type, company_id) values ('2023-03-03', 375000.0, 'PURCHASE', 3);
insert into orders (order_date, total_value, type, company_id) values ('2023-04-04', 46900.0, 'SALE', 4);
insert into orders (order_date, total_value, type, company_id) values ('2023-05-05', 210000.0, 'PURCHASE', 5);
insert into orders (order_date, total_value, type, company_id) values ('2023-05-06', 26600.0, 'SALE', 6);
insert into orders (order_date, total_value, type, company_id) values ('2023-05-07', 46900.0, 'SALE', 7);
insert into orders (order_date, total_value, type, company_id) values ('2023-05-08', 275000.0, 'PURCHASE', 8);
insert into orders (order_date, total_value, type, company_id) values ('2023-05-09', 45500.0, 'SALE', 9);
insert into orders (order_date, total_value, type, company_id) values ('2023-05-10', 393750.0, 'SALE', 10);

# Table Item
insert into item (quantity, unit_value, product_id, order_id) values (7000, 38500.0, 1, 1); 
insert into item (quantity, unit_value, product_id, order_id) values (50000, 325000.0, 2, 2); 
insert into item (quantity, unit_value, product_id, order_id) values (50000, 375000.0, 3, 3); 
insert into item (quantity, unit_value, product_id, order_id) values (7000, 46900.0, 4, 4); 
insert into item (quantity, unit_value, product_id, order_id) values (50000, 210000.0, 5, 5); 
insert into item (quantity, unit_value, product_id, order_id) values (7000, 26600.0, 6, 6); 
insert into item (quantity, unit_value, product_id, order_id) values (7000, 46900.0, 7, 7); 
insert into item (quantity, unit_value, product_id, order_id) values (50000, 275000.0, 1, 8); 
insert into item (quantity, unit_value, product_id, order_id) values (7000, 45500.0, 2, 9); 
insert into item (quantity, unit_value, product_id, order_id) values (7000, 393750.0, 3, 10); 




