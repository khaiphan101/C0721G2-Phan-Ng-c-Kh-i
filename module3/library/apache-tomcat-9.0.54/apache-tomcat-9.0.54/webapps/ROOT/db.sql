drop database if exists premises_rental_management;
create database premises_rental_management;
use premises_rental_management;

create table `status`(
id_status int primary key,
name_status varchar(50)
);
 
 create table premise_type(
 id_premise_type int primary key,
 name_premise_type varchar(50)
 );
 
create table premise(
id_premise varchar(50),
id_status int,
area double,
floor int,
id_premise_type int,
price int,
start_day date,
end_day date,
primary key (id_premise),
foreign key (id_status) references `status`(id_status)  on delete cascade,
foreign key (id_premise_type) references premise_type(id_premise_type)  on delete cascade
 );
 insert `status` values
 (1, 'Empty'),
 (2, 'Infrastructure'),
 (3, 'Full');
 
 insert premise_type values
 (1, 'Shared office'),
 (2, 'Infrastructure'),
 (3, 'All-inclusive office');
 
  insert premise values 
  ('LDH-00-10', 1, 35, 15, 1, 2000000, 2019-11-1, 2021-11-1),
  ('LDH-00-11', 2, 40, 15, 3, 3000000, 2019-8-1, 2021-8-1),
  ('LDH-00-13', 3, 21, 15, 2, 1500000, 2019-7-1, 2021-7-1),
  ('LDH-00-14', 1, 30, 15, 2, 2500000, 2019-3-1, 2021-3-1);
  