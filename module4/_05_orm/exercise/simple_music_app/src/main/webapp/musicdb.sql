drop database if exists musicdb;
create database musicdb;
use musicdb;
create table music(
	id int primary key auto_increment,
	name varchar(255) ,
	singer varchar(255) ,
	type varchar(255) ,
	url varchar(255)
);

insert music values
(1,"nam lay tay anh", "Tuan Hung", "tru tinh", "https://nhac.vn/bai-hat/nam-lay-tay-anh-tuan-hung-sodQR"),
(2, "suy nghi trong anh", "khac viet", "vpop", "https://nhac.vn/search?q=suy+nghi+trong+anh");