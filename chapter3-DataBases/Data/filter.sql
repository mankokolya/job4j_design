select * from product where type = 'cheese' join type on product.type_id = type.id;
select * from product where name like '%icecreame%';
select * from product where expired_date = now() + interval '1 month';
select max(price) from product;
select type, count(type) from product group by type join type on product.type_id = type.id;
select * from product where type = 'cheese' or type = 'milk' join type on product.type_id = type.id;
select type, count(type) from product where count(type) < 10 join type on product.type_id = type.id;