create database car_parts;
\c car_parts;

create table engine (
    engine_id bigserial not null primary key,
    type varchar(100)
);

create table transmission (
    transmission_id bigserial not null primary key,
    type varchar(100)
);

create table body (
    body_id bigserial not null primary key,
    type varchar(100)
);

create table car (
    car_id bigserial primary key,
    name varchar(200),
    engine_id int references engine(engine_id) not null ,
    transmission_id int references transmission(transmission_id) not null,
    body_id int references body(body_id) not null
);

insert into body(type) values ('sedan'), ('SUV'), ('crossover'), ('hatchback'), ('limousine');
insert into transmission(type) values ('manual'), ('auto'), ('robot'), ('dsg'), ('cvt'), ('single-speed');
insert into engine(type) values ('benzine'), ('diesel'), ('electric'), ('hydrogen');
insert into car(name, engine_id, transmission_id, body_id) values ('toyota', 1, 2, 2);
insert into car(name, engine_id, transmission_id, body_id) values ('bmw', 2, 3, 3);
insert into car(name, engine_id, transmission_id, body_id) values ('tesla', 3, 6, 1);

select car.name, e.type, t.type, b.type from car join engine e on car.engine_id = e.engine_id join transmission t
    on car.transmission_id = t.transmission_id join body b on car.body_id = b.body_id;

select body.type as unused_bodies from body left join car c on body.body_id = c.body_id where c.name is null;
select e.type as unused_engines from engine e left join car c on e.engine_id = c.engine_id where c.name is null;
select t.type as unused_transmissions from transmission t left join car c on t.transmission_id = c.transmission_id where c.name is null;