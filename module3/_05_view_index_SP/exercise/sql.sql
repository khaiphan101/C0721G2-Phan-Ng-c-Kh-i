drop database if exists  demo;
create database demo;
use demo;
create table products(
	id int primary key,
	product_code int,
	product_name varchar(45),
	product_price varchar(45),
	product_amount varchar(45),
	product_description varchar(45),
	product_status varchar(45)
);
insert into products
values(1,101,'iphone 11', '10000', '100', 'camera 12.px', 'ok'),
(2,102,'samsung A31', '29000', '100', 'camera 15.px', 'ok');

ALTER TABLE products ADD unique index_product_code(product_code);

ALTER TABLE products ADD unique c_index_product(product_name, product_price);

 explain select * from products where product_code = '101';
 
   select * from products where product_name = 'samsung a31' or product_price = '29000';
   
CREATE OR REPLACE VIEW product_views AS 
select product_code, product_name, product_price, product_status
from products;

DROP VIEW product_views;


DELIMITER //
CREATE PROCEDURE find_all_product()
BEGIn
  SELECT * FROM products;
END //
DELIMITER ;
call find_all_product();

DELIMITER //
create procedure insert_product(p_id int,p_code int,p_name varchar(45),p_price varchar(45))
	begin 
		insert into products(id,product_code,product_name, product_price)
        value(p_id,p_code,p_name,p_price);
    end //
DELIMITER ;
call insert_product(3,103,'sony xz1', '10000000');
Select * from products;

DELIMITER //
create procedure edit_product_by_id(p_id int, p_name varchar(45))
	begin
		update products
			set product_name = p_name
            where id = p_id;
	end //
DELIMITER ;
call edit_product_by_id(1,'oppo a1k');
Select * from products;

DELIMITER //
create procedure delete_product_by_id(p_id int)
	begin
		delete from products
            where id = p_id;
	end //
DELIMITER ;
call delete_product_by_id(1);
Select * from products;