select * from product join type on product.type_id = type.id where type.name = 'cheese';
select * from product where name like '%icecreame%';
select * from product where expired_date = now() + interval '1 month';
select name from product where price = (select max(price) from product);
select t.name, count(p.id) from product as p join type as t on product.type_id = t.id group by t.name;
select * from product join type on product.type_id = type.id where type.name = 'cheese' or type.name = 'milk';
select type.name, count(p.id) from product as p join type on product.type_id = type.id where count(p.id) < 10 ;
select p.name, t.name from product p join type t on p.type_id = t.id;