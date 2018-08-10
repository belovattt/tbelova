create table typee (
   type_id serial primary key,
   typ varchar(2000)
);
insert into typee (typ) values 
	('cheese'),
	('milk'),
	("drink"),
	('vegetables');
create table product (
   product_id serial primary key,
   product_name varchar(2000),
   type_id int references typee(type_id),
	expired_date date,
	price numeric(6, 2)
);
insert into product (product_name, type_id, expired_date, price) values
('Эдам', 1, '2019-09-08', 590.00),
('Маасдам', 1, '2018-01-12', 1000.00),
('Российский', 1, '2019-08-11', 450.50),
('Домик в деревне', 2, '2018-01-09', 75.70),
('Замороженное молоко', 2, '2018-09-12', 66.60),
('Авида', 2, '2018-03-10', 67.00),
('Водка', 3, '2020-01-01', 314.00),
('Отмороженное ухо', 3, '2018-09-11', 1200.00),
('Капуста', 4, '2018-01-09', 40.50),
('Репа', 4, '2018-12-09', 35.90),
('Подмороженное авокадо', 4, '2018-09-13', 13.70);

select product_name from product as p inner join typee as t on p.type_id = t.type_id
where t.typ = 'cheese';

select p.product_name from product as p 
where p.product_name like '%мороженное%';

select p.product_name from product as p 
where extract(month from p.expired_date) - extract(month from current_date) = 1 
and extract(year from p.expired_date) = extract(year from current_date);

select p.product_name from product as p
order by p.price limit 1;

select t.typ, count(p.product_name) from product as p inner join typee as t on p.type_id = t.type_id
group by t.typ;

select product_name from product as p inner join typee as t on p.type_id = t.type_id
where (t.typ = 'cheese' or t.typ = 'milk');

select t.typ from typee as t inner join product as p on t.type_id = p.type_id
group by t.typ having count(p.product_name) < 10;

select p.product_name, t.typ from product as p inner join typee as t on p.type_id = t.type_id;



	 