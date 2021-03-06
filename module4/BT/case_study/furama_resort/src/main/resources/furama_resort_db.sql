drop database if exists furama_resort_md4;
create database furama_resort_md4;
use furama_resort_md4;

create table `position`(
id_position int primary key,
name_position varchar(50)
);
 
 create table education_degree(
 id_education_degree int primary key,
 education_degree varchar(50)
 );
 
 create table division(
 id_division int primary key,
 name_division varchar(50)
 );
 
create table employee(
id_employee int,
full_name varchar(50),
id_position int,
id_education_degree int,
id_division int,
birthday date,
id_card varchar(45),
salary varchar(45),
`number` varchar(45),
email varchar(45),
`address` varchar(45),
primary key (id_employee),
foreign key (id_position) references `position`(id_position)  on delete cascade,
foreign key (id_education_degree) references education_degree(id_education_degree)  on delete cascade,
foreign key (id_division) references division(id_division)  on delete cascade
 );
 
 create table customer_type(
 id_customer_type int primary key,
 name_customer_type varchar(50)
 );
 
create table customer(
id_customer int,
id_customer_type int,
full_name varchar(50),
birthday date,
id_card varchar(45),
`number` varchar(45),
email varchar(45),
`address` varchar(45),
primary key (id_customer),
foreign key (id_customer_type) references customer_type(id_customer_type)  on delete cascade
);

 
create table rental_type(
id_rental_type int primary key,
name_rental_type varchar(50),
price int
);

create table service_type(
id_service_type int primary key,
name_service_type varchar(50)
);

create table `service`(
id_service int,
name_service varchar(45),
area int,
floor_number int,
max_people varchar(45),
rental_cost varchar(45),
id_rental_type int,
id_service_type int,
`status` varchar(45),
primary key (id_service),
foreign key (id_rental_type) references rental_type(id_rental_type)  on delete cascade,
foreign key (id_service_type) references service_type(id_service_type)  on delete cascade
);

create table contract(
id_contract int,
id_employee int,
id_customer int,
id_service int,
contract_start_date date,
contrac_end_day date,
deposit int,
toltal_cost int, 	
primary key (id_contract),
foreign key (id_employee) references employee(id_employee)  on delete cascade,
foreign key (id_customer) references customer(id_customer)  on delete cascade,
foreign key (id_service) references `service`(id_service)  on delete cascade
);

create table attach_service(
id_attach_service int primary key ,
name_attach_service varchar(45),
price int,
unit int,
`status` varchar(45)
);

create table detail_contract(
id_detail_contract int,
id_contract int,
id_attach_service int,
amount int,
primary key (id_detail_contract),
foreign key (id_contract) references contract(id_contract)  on delete cascade,
foreign key (id_attach_service) references attach_service(id_attach_service)  on delete cascade
);

-- task 1: Th??m m???i th??ng tin cho t???t c??? c??c b???ng c?? trong CSDL ????? c?? th??? th??a m??n c??c y??u c???u b??n d?????i.
insert position values 
(1,'Manager'),(2,'HR'),(3,'Chef'),(4,'Staff');

insert education_degree values
(1,'DH'),(2,'CD'),(3,'TC'),(4,'SDH');

insert division values 
(1,'operation'),(2,'Service'),(3,'Administrative'), (4,'Sale-Marketing');

 insert employee values
	(101,'Kh???i',1,2,1,'1998-09-09','123456789','6000','123456789','khai@gmail.com','Qu???ng Ng??i'),
	(102,'Nam',2,1,1,'1988-02-09','123456789','4000','123456789','namh@gmail.com','H???i ch??u'),
	(103,'Hi???n',3,3,1,'1978-01-09','123456789','8000','123456789','hien@gmail.com','H???i ch??u'),
	(104,'Th??ng',4,2,1,'1996-08-09','123456789','9000','123456789','thong@gmail.com','Qu???ng Tr???'),
	(105,'H???p',2,3,1,'1997-10-09','123456789','10000','123456789','hop@gmail.com','H???i ch??u'),
	(106,'Nguy??n',1,3,1,'1978-12-09','123456789','5000','123456789','nguyen@gmail.com','???? N???ng');
      

insert customer_type value
	(1,'Diamond'),
    (2,'Platium'),
    (3,'Gold'),
    (4,'Sliver'),
    (5,'Member');

insert customer(id_customer,id_customer_type,full_name,birthday,`address`) values
(101,2,'Nguyen An', '1980-10-20', 'Da Nang'),
(102,3,'Nguyen Binh', '1989-10-20', 'Quang Tri'),
(103,1,'Nguyen An', '1965-10-20', 'Vinh'),
(104,2,'Nguyen Trung', '1988-11-20', 'Quang Ngai'),
(105,1,'Nguyen Thinh', '1989-10-20', 'Ha Noi'),
(106,1,'Nguyen Tung', '1965-10-20', 'Da Nang');


insert attach_service() value 
	(1, 'massage',500,1,1),
    (2, 'karaoke',500,1,1),
    (3, 'th???c ??n',500,2,1),
    (4, 'n?????c u???ng',500,4,1),
	(5, 'thu?? xe di chuy???n ',500,2,1);
    

insert service_type() value
	(1,'Room'),
    (2,'House'),
    (3,'Villa');

	insert rental_type() value
    (1,'Ng??y',1000),
    (2,'Tu???n',2000),
    (3,'Th??ng',3000);


insert into `service`() value
	(101,'Villa_A',50, 2,10, 3000,1,3,null),
	(102,'Villa_B',60, 2,8, 3500,1,3,null),
	(103,'House_A',30, 1,4, 1500,2,2,null),
	(104,'House_B',40, 2,2, 2000,1,2,null),
	(105,'Room_A',20, 1,2, 800,1,1,null);

insert contract values 
	(1,102,103,101,'2018-12-12','2020-10-11',1000,'4000000'),
	(2,103,104,102,'2019-05-15','2021-10-18',400,10000000),
	(3,103,104,102,'2018-08-15','2021-09-18',400,4000000),
    (4,103,106,105,'2019-02-24','2021-03-18',400,4000000),
    (5,103,106,105,'2019-05-24','2021-03-18',400,4000000),
    (6,101,106,105,'2018-03-02','2021-03-18',400,4000000),
	(7,103,101,105,'2019-05-24','2021-03-18',400,4000000),
    (8,102,101,105,'2019-12-12','2021-03-18',400,4000000),
    (9,103,101,105,'2019-12-12','2021-03-18',400,4000000),
    (10,105,102,105,'2015-12-02','2021-03-18',400,4000000);

insert detail_contract values
(1,1,1,1),(2,3,2,1),(3,2,3,2),(4,3,2,1),(5,2,1,3),(6,4,3,2),(7,5,4,3),(8,6,5,4),(9,8,4,3),(10,9,4,4),(11,10,4,4);

-- task 2.	Hi???n th??? th??ng tin c???a t???t c??? nh??n vi??n c?? trong h??? th???ng c?? t??n b???t ?????u l?? m???t trong c??c k?? t??? ???H???, ???T??? ho???c ???K??? v?? c?? t???i ??a 15 k?? t???.: 
select *
from employee
where (full_name like 'H%' or full_name like'N%' or full_name like 'K%') and length(full_name) < 15;

-- task 3.	Hi???n th??? th??ng tin c???a t???t c??? kh??ch h??ng c?? ????? tu???i t??? 18 ?????n 50 tu???i v?? c?? ?????a ch??? ??? ??????? N???ng??? ho???c ???Qu???ng Tr??????.
SELECT *
from customer kh
where (timestampdiff(year,kh.birthday,current_date()) between 18 and 50) and kh.`address` in('Da Nang','Quang Tri');

-- task 4.	?????m xem t????ng ???ng v???i m???i kh??ch h??ng ???? t???ng ?????t ph??ng bao nhi??u l???n. 
-- K???t qu??? hi???n th??? ???????c s???p x???p t??ng d???n theo s??? l???n ?????t ph??ng c???a kh??ch h??ng. 
-- Ch??? ?????m nh???ng kh??ch h??ng n??o c?? T??n lo???i kh??ch h??ng l?? ???Diamond???.
SELECT kh.full_name as 'name khach hang', lk.name_customer_type, count(kh.id_customer) as 'so lan dat phong' 
from customer kh
join contract hd on kh.id_customer = hd.id_customer
join customer_type lk on lk.id_customer_type = kh.id_customer_type
where kh.id_customer_type = 1
group by kh.id_customer
order by count(kh.id_customer);

-- task 5.	Hi???n th??? IDKhachHang, Honame, nameLoaiKhach, IDHopDong, nameDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (V???i TongTien ???????c t??nh theo c??ng th???c nh?? sau: ChiPhiThue + Sosalary*price, v???i Sosalary v?? Gi?? l?? t??? b???ng DichVuDiKem) 
-- cho t???t c??? c??c Kh??ch h??ng ???? t???ng ?????t ph???ng. 
-- (Nh???ng Kh??ch h??ng n??o ch??a t???ng ?????t ph??ng c??ng ph???i hi???n th??? ra).
select kh.id_customer, kh.full_name, lk.name_customer_type, hd.id_contract, dv.name_service, hd.contract_start_date, hd.contrac_end_day, 
(dv.rental_cost + hdct.amount * dvdk.price) as 'tong tien'
from customer kh
left join customer_type lk on lk.id_customer_type = kh.id_customer_type
left join contract hd on kh.id_customer = hd.id_customer
left join `service` dv on hd.id_service = dv.id_service
left join detail_contract hdct on hdct.id_contract = hd.id_contract
left join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service;

-- task 6.	Hi???n th??? IDDichVu, nameDichVu, DienTich, ChiPhiThue, nameLoaiDichVu 
-- c???a t???t c??? c??c lo???i D???ch v??? ch??a t???ng ???????c Kh??ch h??ng th???c hi???n ?????t t??? qu?? 1 c???a n??m 2019 
-- (Qu?? 1 l?? th??ng 1, 2, 3).-- 

 select dv.id_service,dv.name_service,area,rental_cost,name_service_type, hd.contract_start_date
 from `service` dv
  left join contract hd on hd.id_service = dv.id_service
  left join service_type ldv on dv.id_service_type = ldv.id_service_type 
 where dv.id_service not in (select hd.id_service
 from contract hd
 where hd.contract_start_date between '2019-1-1' and '2019-3-31')
 group by id_service;
 
 -- task 7.	Hi???n th??? th??ng tin IDDichVu, nameDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, nameLoaiDichVu 
 -- c???a t???t c??? c??c lo???i d???ch v??? ???? t???ng ???????c Kh??ch h??ng ?????t ph??ng trong n??m 2018 
--  nh??ng ch??a t???ng ???????c Kh??ch h??ng ?????t ph??ng  trong n??m 2019.
select dv.id_service, dv.name_service, area, max_people, rental_cost, ldv.name_service_type, hd.contract_start_date
from `service` dv
join contract hd on hd.id_service = dv.id_service
join service_type ldv on dv.id_service_type = ldv.id_service_type 
where year(hd.contract_start_date) = '2018'
	and dv.id_service not in (select hd.id_service
	from contract hd
	where year(hd.contract_start_date) = '2019')
group by id_service;

-- task 8.	Hi???n th??? th??ng tin HonameKhachHang c?? trong h??? th???ng, 
-- v???i y??u c???u HoThenKhachHang kh??ng tr??ng nhau.
-- H???c vi??n s??? d???ng theo 3 c??ch kh??c nhau ????? th???c hi???n y??u c???u tr??n

-- C1: dung group by
select full_name
from customer
group by full_name;

-- C2: su dung UNION
select full_name
from customer
union
select full_name
from customer;
 
 -- C3: su dung distinct 
select distinct full_name
from customer;

-- task 9.	Th???c hi???n th???ng k?? doanh thu theo th??ng, 
-- ngh??a l?? t????ng ???ng v???i m???i th??ng trong n??m 2019 th?? s??? c?? bao nhi??u kh??ch h??ng th???c hi???n ?????t ph??ng.
select month(hd.contract_start_date) as 'thang(nam 2019)', count(month(hd.contract_start_date)) as 'so salary hop dong' 
from contract hd
where year(hd.contract_start_date) = '2019'
group by month(hd.contract_start_date);

-- task 10.	Hi???n th??? th??ng tin t????ng ???ng v???i t???ng H???p ?????ng th?? ???? s??? d???ng bao nhi??u D???ch v??? ??i k??m. 
-- K???t qu??? hi???n th??? bao g???m IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SosalaryDichVuDiKem 
-- (???????c t??nh d???a tr??n vi???c count c??c IDHopDongChiTiet). 
select hd.id_contract, contract_start_date, contrac_end_day, deposit
, count(hdct.id_contract) amount_attach_service
from contract hd
join detail_contract hdct on hdct.id_contract = hd.id_contract
join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service
group by hdct.id_contract;

-- task 11.	Hi???n th??? th??ng tin c??c D???ch v??? ??i k??m ???? ???????c s??? d???ng b???i nh???ng Kh??ch h??ng c?? 
-- nameLoaiKhachHang l?? ???Diamond??? v?? c?? ?????a ch??? l?? ???Vinh??? ho???c ???Qu???ng Ng??i???.
select kh.full_name, lk.name_customer_type, `address`, name_attach_service, price
from contract hd
left join customer kh on hd.id_customer = kh.id_customer
left join customer_type lk on lk.id_customer_type = kh.id_customer_type
left join detail_contract hdct on hdct.id_contract = hd.id_contract
left join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service
where `address` in ('Quang Ngai', 'Vinh') and name_customer_type = 'Diamond';


-- task 12.	Hi???n th??? th??ng tin IDHopDong, nameNhanVien, nameKhachHang, SoDienThoaiKhachHang, 
-- nameDichVu, SosalaryDichVuDikem (???????c t??nh d???a tr??n t???ng H???p ?????ng chi ti???t),
--  TienDatCoc c???a t???t c??? c??c d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t v??o 3 th??ng cu???i n??m 2019 
--  nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t v??o 6 th??ng ?????u n??m 2019.

select hd.id_contract, nv.full_name 'name nhan vien', kh.full_name 'name khach hang', kh.`number`, name_attach_service
, count(hd.id_contract) amount_attach_service
,deposit, contract_start_date
from contract hd
join employee nv on nv.id_employee = hd.id_employee
join customer kh on kh.id_customer = hd.id_customer
join detail_contract hdct on hdct.id_contract = hd.id_contract
join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service
group by hd.id_contract
having (contract_start_date between '2019-10-1' and '2019-12-31')
and hd.id_contract not in (
	select hd.id_contract
		from contract 
        where contract_start_date between '2019-1-1' and '2019-6-31'
	);
    
-- task  13.	Hi???n th??? th??ng tin c??c D???ch v??? ??i k??m ???????c s??? d???ng nhi???u nh???t b???i c??c Kh??ch h??ng ???? ?????t ph??ng. 
-- (L??u ?? l?? c?? th??? c?? nhi???u d???ch v??? c?? s??? l???n s??? d???ng nhi???u nh?? nhau).
select name_attach_service
, count(name_attach_service) so_lan_su_dung_nhieu_nhat
from detail_contract hdct
join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service
group by name_attach_service
having so_lan_su_dung_nhieu_nhat = 
	(select max(t.so_lan_su_dung)
    from (select count(name_attach_service) so_lan_su_dung
			from detail_contract hdct
			join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service
			group by name_attach_service
            ) t
	);
    
-- task 14.	Hi???n th??? th??ng tin t???t c??? c??c D???ch v??? ??i k??m ch??? m???i ???????c s??? d???ng m???t l???n duy nh???t. 
-- Th??ng tin hi???n th??? bao g???m IDHopDong, nameLoaiDichVu, nameDichVuDiKem, SoLanSuDung. 
select hd.id_contract,name_service_type, name_attach_service
, count(name_attach_service) so_lan_su_dung
from contract hd
join detail_contract hdct on hdct.id_contract = hd.id_contract
join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service
join `service` dv on dv.id_service = hd.id_service
join service_type ldv on ldv.id_service_type = dv.id_service_type
group by name_attach_service
having so_lan_su_dung = 1
;

-- task 15.	Hi???n thi th??ng tin c???a t???t c??? nh??n vi??n bao g???m IDNhanVien, Honame, TrinhDo, 
-- nameBoPhan, SoDienThoai, DiaChi m???i ch??? l???p ???????c t???i ??a 3 h???p ?????ng t??? n??m 2018 ?????n 2019.
select nv.id_employee, nv.full_name, education_degree, name_division, nv.`number`, `address`
from employee nv
left join contract hd on hd.id_employee = nv.id_employee
left join education_degree td on td.id_education_degree = nv.id_education_degree
left join division bp on bp.id_division = nv.id_division
where year(contract_start_date) between 2018 and 2019 
or contract_start_date is null
group by nv.id_employee
having count(nv.id_employee) <=3;

-- task 16.	X??a nh???ng Nh??n vi??n ch??a t???ng l???p ???????c h???p ?????ng n??o t??? n??m 2017 ?????n n??m 2019.

-- delete from employee
-- where id_employee not in (
-- select id_employee
-- from contract
-- where year(contract_start_date) between '2019' and '2020' 
-- );

 -- task 17. C???p nh???t th??ng tin nh???ng kh??ch h??ng c?? nameLoaiKhachHang 
--  t???  Platinium l??n Diamond, ch??? c???p nh???t nh???ng kh??ch h??ng ???? t???ng ?????t ph??ng 
--  v???i t???ng Ti???n thanh to??n trong n??m 2019 l?? l???n h??n 10.000.000 VN??.         
-- 		SET SQL_SAFE_UPDATES = 0;       
-- 	 	update customer kh
-- 		set kh.id_customer_type = 1
-- 		where id_customer in 
-- 			(select id_customer
-- 				from contract hd
-- 				where year(contract_start_date) = '2019'
-- 				group by id_customer
-- 				having sum(toltal_cost) >= 10000000
-- 			);
--             SET SQL_SAFE_UPDATES = 0;

-- d??ng l???nh d?????i ????? check tr?????c v?? sau khi update khashc h??ng t??? platinum -> diamond 

-- select kh.full_name, kh.id_customer_type, name_customer_type
-- from customer kh
-- join customer_type lk on lk.id_customer_type = kh.id_customer_type;
 
-- task 18.	X??a nh???ng kh??ch h??ng c?? h???p ?????ng tr?????c n??m 2016 (ch?? ?? r??ng bu???c gi???a c??c b???ng).

-- SET FOREIGN_KEY_CHECKS=0;
-- delete from customer 
-- where id_customer in 
-- 	(select id_customer
-- 	from contract
-- 	where year(contract_start_date) < 2016
-- 	);
-- SET FOREIGN_KEY_CHECKS=1; 

-- task 19.	C???p nh???t gi?? cho c??c D???ch v??? ??i k??m ???????c s??? d???ng tr??n 4 l???n trong n??m 2019 l??n g???p ????i. 
-- 	SET SQL_SAFE_UPDATES = 0;
-- 	update attach_service
-- 	set price = price*2
-- 	where id_attach_service in (select* from(
-- 	select dvdk.id_attach_service
-- 	from detail_contract hdct
-- 	join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service
-- 	group by name_attach_service
-- 	having count(name_attach_service) >= 2)tblTmc);
-- 	SET SQL_SAFE_UPDATES = 1;	

-- task 20.	Hi???n th??? th??ng tin c???a t???t c??? c??c Nh??n vi??n v?? Kh??ch h??ng c?? trong h??? th???ng, 
-- th??ng tin hi???n th??? bao g???m ID (IDNhanVien, IDKhachHang), Honame, Email, SoDienThoai, NgaySinh, DiaChi. 

select id_employee as id,full_name,email,`number`,birthday,`address`, 'employee'
from employee
union all
select id_customer,full_name,email,`number`,birthday,`address`, 'khach hang'
from customer;

-- task 21.	T???o khung nh??n c?? t??n l?? V_NHANVIEN ????? l???y ???????c th??ng tin c???a t???t c??? c??c nh??n vi??n c?? ?????a ch??? 
-- l?? ???H???i Ch??u??? v?? ???? t???ng l???p h???p ?????ng cho 1 ho???c nhi???u Kh??ch h??ng b???t k???  v???i ng??y l???p h???p ?????ng l?? ???12/12/2019???

create view v_employee as
select nv.id_employee, nv.full_name, `address`, contract_start_date
from employee nv
join contract hd on nv.id_employee = hd.id_employee
where contract_start_date = '2019/12/12' and `address` = 'Hai chau'
group by full_name
;
-- drop view v_employee;

 -- task 2.	Th??ng qua khung nh??n V_NHANVIEN th???c hi???n c???p nh???t ?????a ch??? th??nh ???Li??n Chi???u??? ?????i v???i t???t c??? 
 -- c??c Nh??n vi??n ???????c nh??n th???y b???i khung nh??n n??y. 
 
 
 
--  select * from v_employee;
--  
--   SET SQL_SAFE_UPDATES = 0;    
--   
--  update v_employee
-- 	set `address` = 'Li??n Chi???u' 
--     where id_employee in (
-- 		select id_employee
--         from v_employee);

 
-- task 23.	T???o Store procedure Sp_1 D??ng ????? x??a th??ng tin c???a m???t Kh??ch h??ng n??o ???? v???i 
-- Id Kh??ch h??ng ???????c truy???n v??o nh?? l?? 1 tham s??? c???a Sp_1
-- DELIMITER //
-- create procedure sp_1(p_id int)
-- begin 
-- 	set foreign_key_checks = 0;
-- 	delete from customer
--     where id_customer = p_id;
--     set foreign_key_checks = 1;
-- end //
-- DELIMITER ;
-- call sp_1(103);

--  24.	T???p Store procedure Sp_2 D??ng ????? th??m m???i v??o b???ng HopDong v???i y??u c???u Sp_2 
-- ph???i th???c hi???n ki???m tra t??nh h???p l??? c???a d??? li???u b??? sung, v???i nguy??n t???c kh??ng ???????c 
-- tr??ng kh??a ch??nh v?? ?????m b???o to??n v???n tham chi???u ?????n c??c b???ng li??n quan.

DELIMITER //
create procedure sp_2(p_id_hd int,p_id_nv int, p_id_kh int, p_id_dv int, p_contract_start_date date,p_contrac_end_day date,p_deposit int, p_toltal_cost int)
begin
	SET FOREIGN_KEY_CHECKS=0 ;
	if p_id_hd in (select hd.id_contract from contract hd) then
		select concat('p_id_hd', ' is duplicate') as 'error id_contract';
	elseif p_id_nv not in (select nv.id_employee from employee nv) then
		select concat('p_id_nv', ' is not exist') as 'error id_employee';
	elseif p_id_kh not in (select kh.id_customer from customer kh) then
		select concat('p_id_kh', ' is not exist') as 'error id_customer';
	elseif p_id_dv not in (select dv.id_service from `service` dv) then
		select concat('p_id_dv', ' is not exist') as 'error id_service'; 
	else
		insert into contract 
		value(p_id_hd, p_id_nv, p_id_kh, p_id_dv, p_contract_start_date, p_contrac_end_day, p_deposit, p_toltal_cost);
		SET FOREIGN_KEY_CHECKS=1;
        select 'completed add new `service`';
	end if;
end //
DELIMITER ;
call sp_2(11,105,104,4,'2018-12-1','2019-12-10',7,8); -- hien thong bao them loi~ 
call sp_2(12,105,104,103,'2018-12-1','2019-12-10',7,8);--  
drop procedure sp_2;

-- task 25.	T???o triggers c?? t??n Tr_1 X??a b???n ghi trong b???ng HopDong th?? hi???n th??? 
-- t???ng s??? l?????ng b???n ghi c??n l???i c?? trong b???ng HopDong ra priceo di???n console c???a database 

-- DELIMITER //
-- create trigger tr_1
-- before delete
-- on contract for each row
-- begin
-- 	INSERT INTO contract(id_contract)
--     VALUES(OLD.id_contract);
-- end //
-- DELIMITER ;
-- 	set foreign_key_checks = 0;
-- 	delete from contract
-- 		where id_contract = 8;
--     set foreign_key_checks = 1;
--     drop trigger tr_1;

