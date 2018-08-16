create table carcass (
   id serial primary key,
   carcass_type varchar(100)
);
insert into carcass (carcass_type) values 
	('седан'),
	('хэтчбек'),
	('универсал'),
	('купе');
create table motor (
   id serial primary key,
   motor_type varchar(100)
);
insert into motor (motor_type) values
	('дизель'),
	('бензин');
create table transmission (
   id serial primary key,
   transmission_type varchar(100)
);
insert into transmission (transmission_type) values
	('механика'),
	('автомат'),
	('робот');

create table car (
   id serial primary key,
   car_type varchar(100),
	motor_id int references motor(id),
	carcass_id int references carcass(id),
	transmission_id int references transmission(id)
);
insert into car (car_type, motor_id, carcass_id, transmission_id) values 
	('BMW', 1, 1, 1),
	('Audi', 1, 2, 2),
	('Bentley', 1, 3, 3),
	('Zaporozhets', 1, 4, 1);
select car.car_type, c.carcass_type, m.motor_type, t.transmission_type from car 
left outer join carcass as c on car.carcass_id = c.id
left outer join motor as m on car.motor_id = m.id
left outer join transmission as t on car.transmission_id = t.id;

select c.carcass_type  from carcass as c 
left outer join car on car.carcass_id = c.id where car.carcass_id is null;

select m.motor_type  from motor as m 
left outer join car on car.motor_id = m.id where car.motor_id is null;

select t.transmission_type  from transmission as t 
left outer join car on car.transmission_id = t.id where car.transmission_id is null;
