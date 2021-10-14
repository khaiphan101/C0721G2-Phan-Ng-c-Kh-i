drop database if exists sale_management;
create database sale_management;
use sale_management;
create table customer (
cId int not null auto_increment primary key,
cName varchar(50) not null,
cAge int null
);
insert into customer value 
(1, 'Minh Quan', 10),
(2, 'Ngoc Oanh', 20),
(3, 'Hong Ha', 50),
(10, 'Hong Hanh', 50);
create table `order` (
oId int not null auto_increment primary key,
cId int not null,
oDate date not null,
oTotalPrice double null,
foreign key (cId) references customer(cId)
);
insert into `order` values
(1,1,'2006-03-21',null),
(2,2,'2006-03-23',null),
(3,1,'2006-03-16',null);
create table product (
pId int not null auto_increment primary key,
pName varchar (50) not null,
pPrice double not null
);
insert into product values
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);
create table order_detail(
oId int not null,
pId int not null,
orderQty int null,
primary key (oId,pId),
foreign key (oId) references `order`(oId),
foreign key (pId) references product(pId)
);
insert into order_detail values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
select oId, oDate, oTotalPrice
from `order`;
select customer.cId,  customer.cName, product.pName
from customer 
join `order` on customer.cId = `order`.cId 
join order_detail on `order`.oId = order_detail.oId 
join product on order_detail.pId = product.pId ;
select customer.cName
from customer
where customer.cName not in 
(select customer.cName  from `order` where `order`.cId = customer.cId );
select `order`.oId, `order`.oDate, sum(product.pPrice*order_detail.orderQty) as oTotalPrice
from `order`
join order_detail on order_detail.oId = `order`.oId
join product on product.pId = order_detail.pId
group by `order`.oId