drop database if exists library_management;
create database library_management;
use library_management;

create table `status`(
id_status varchar(50) primary key,
name_status varchar(50)
);
 
create table book(
id_book varchar(50),
name_book varchar(50),
actor varchar(50),
amount varchar(50),
`description` varchar(50),
primary key (id_book)
 );
 
 create table student(
id_student varchar(50),
name_student varchar(50),
class varchar(50),
primary key (id_student)
);
 
  create table card(
id_card varchar(50),
id_book varchar(50),
id_student varchar(50),
id_status varchar(50),
borrow_day date,
return_day date,
primary key (id_card),
foreign key (id_book) references book(id_book) on delete cascade,
foreign key (id_student) references student(id_student)  on delete cascade,
foreign key (id_status) references status(id_status)  on delete cascade
-- on delete cascade -- 
);
 
 insert `status` values
 ('1', 'borrowing'),
 ('2', 'returned');
 
 insert book values
 ('S-0001', 'So do', 'Vu Trong Phung','10','nhan vat chinh la xuan toc do va...'),
 ('S-0002', 'Truyen Kieu','Nguyen Du', '15', 'cuoc doi Thuy Kieu...');
 
  insert student values 
  ('1','Nguyen Van A', '10A1');
  
  SET FOREIGN_KEY_CHECKS=0;
  insert card values
 ('MS-0001','S-0001', '1','1', '2020-10-10','2020-10-15'),
 ('MS-0002','S-0001', '1','1', '2020-10-10','2020-10-15'),
 ('MS-0003','S-0001', '1','1', '2020-10-10','2020-10-15'),
 ('MS-0004','S-0001', '1','1', '2020-10-10','2020-10-15'),
 ('MS-0005','S-0001', '1','1', '2020-10-10','2020-10-15'),
 ('MS-0006','S-0001', '1','1', '2020-10-10','2020-10-15');
 SET FOREIGN_KEY_CHECKS=1;
 
 select id_card, name_book, actor, name_student, class, borrow_day,return_day
 from card c join book b on b.id_book = c.id_book
 join student s on s.id_student = c.id_student;
 