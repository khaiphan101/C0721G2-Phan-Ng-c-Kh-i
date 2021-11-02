drop database if exists demo;
CREATE DATABASE demo;
USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

DELIMITER $$
CREATE PROCEDURE get_all_users()
BEGIN
    SELECT * 
    FROM users;
    END$$
DELIMITER ;

  

DELIMITER $$

CREATE PROCEDURE edit_user(


IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50),

in user_id int

)

BEGIN
    update users 
    set name = user_name, email = user_email, country = user_country
    where id = user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE delete_user(in user_id int)

BEGIN
    delete from users
    where id = user_id;
    END$$
DELIMITER ;

-- call edit_user("1","1","1",1);
-- call get_all_user