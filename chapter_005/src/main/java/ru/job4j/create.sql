CREATE DATABASE "ItemsSystem"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
create table roots (
   root_id serial primary key,
   root varchar(2000)
)
create table roles (
   role_id serial primary key,
   role_name varchar(2000)
)
create table role_roots (
   rr_id serial primary key,
   role_id int references roles(role_id),
   root_id int references roots(root_id) 
)
create table users (
   user_id serial primary key,
   user_name varchar(2000), 
   role_id int references roles(role_id)
)
create table states (
   status_id serial primary key,
   status_name varchar(2000) 
)
create table category (
   category_id serial primary key,
   category_name varchar(2000) 
)
create table items (
   item_id serial primary key,
   item_name varchar(2000),
   user_id int references users(user_id),
    category_id int references category(category_id),
    status_id int references states(status_id)
)
create table attachs (
   file_id serial primary key,
   file_name varchar(2000),
   item_id int references items(item_id)
)
create table comments (
   comment_id serial primary key,
   comment_text text,
   item_id int references items(item_id)
)
insert into roles (role_name) values ('admin');
insert into roles (role_name) values ('user');
insert into roots (root) values ('read');
insert into roots (root) values ('write');
insert into roots (root) values ('delete');
insert into roots (root) values ('change');
insert into role_roots (role_id, root_id) values (1, 1);
insert into role_roots (role_id, root_id) values (1, 2);
insert into role_roots (role_id, root_id) values (1, 3);
insert into role_roots (role_id, root_id) values (1, 4);
insert into role_roots (role_id, root_id) values (2, 1);
insert into role_roots (role_id, root_id) values (2, 2);
insert into users (user_name, role_id) values ('Vasya', 1);
insert into users (user_name, role_id) values ('Vanya', 2);
insert into states (status_name) values ('opened');
insert into states (status_name) values ('executed');
insert into states (status_name) values ('closed');
insert into category (category_name) values ('important');
insert into category (category_name) values ('normal');
insert into items (item_name, user_id, category_id, status_id) values ('изменить что-то', 1, 1, 1);
insert into items (item_name, user_id, category_id, status_id) values ('сделать что-нибудь', 2, 2, 2);
insert into comments (comment_text, item_id) values 
('странная просьба', 1),
('повторная заявка', 2);
insert into attachs (file_name, item_id) values 
('c:\\Items\files\file1.ipg', 1),
('c:\\Items\files\file1.ipg', 2);

