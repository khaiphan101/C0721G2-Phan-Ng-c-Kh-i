DROP DATABASE IF EXISTS sale_management;
CREATE DATABASE sale_management;
USE sale_management;
CREATE TABLE customer(
cID 	INT PRIMARY KEY ,
cName	VARCHAR(60),
cAge	VARCHAR(60)
);

CREATE TABLE product(
pID 	INT PRIMARY KEY,
pName	VARCHAR(60),
pPrice	VARCHAR(60)
);

CREATE TABLE `order`(
oID 	INT PRIMARY KEY ,
cID 	INT,
oDate	VARCHAR(60),
oTotalPrice	VARCHAR(60),
foreign key (cID) references customer (cID)
);

CREATE TABLE order_detail(
oID 	INT,
pID 	INT,
primary key (oID, pID),
odQTY	VARCHAR(60),
foreign key (oID) references `order` (oID),
foreign key (pID) references product (pID)
);




