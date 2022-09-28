use db_restaurant;

insert into category (name) values ('pizza');
insert into category (name) values ('dessert');
insert into category (name) values ('vine');
insert into category (name) values ('pasta');
insert into category (name) values ('coffee');

insert into item (name, price, category_id) values ('pizza romana', 5.5, 1);
insert into item (name, price, category_id) values ('panna cotta', 3.5, 2);
insert into item (name, price, category_id) values ('pizza viennese', 6.0, 1);
insert into item (name, price, category_id) values ('pizza capriccosa', 5.5, 1);
insert into item (name, price, category_id) values ('pizza quattro stagioni', 7.0, 1);
insert into item (name, price, category_id) values ('tiramisu', 4.0, 2);
insert into item (name, price, category_id) values ('cannelloni al forno', 6.0, 4);
insert into item (name, price, category_id) values ('cappuccino', 1.5, 5);
insert into item (name, price, category_id) values ('chiati conte(0.175)', 3.5, 3);
insert into item (name, price, category_id) values ('chiati conte(0.75)', 10.0, 3);

insert into user (username, password) values ('pera', '123');

