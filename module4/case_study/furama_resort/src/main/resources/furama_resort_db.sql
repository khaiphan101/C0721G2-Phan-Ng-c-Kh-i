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

-- task 1: Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.
insert position values 
(1,'Manager'),(2,'HR'),(3,'Chef'),(4,'Staff');

insert education_degree values
(1,'DH'),(2,'CD'),(3,'TC'),(4,'SDH');

insert division values 
(1,'operation'),(2,'Service'),(3,'Administrative'), (4,'Sale-Marketing');

 insert employee values
	(101,'Khải',1,2,1,'1998-09-09','123456789','6000','123456789','khai@gmail.com','Quảng Ngãi'),
	(102,'Nam',2,1,1,'1988-02-09','123456789','4000','123456789','namh@gmail.com','Hải châu'),
	(103,'Hiền',3,3,1,'1978-01-09','123456789','8000','123456789','hien@gmail.com','Hải châu'),
	(104,'Thông',4,2,1,'1996-08-09','123456789','9000','123456789','thong@gmail.com','Quảng Trị'),
	(105,'Hợp',2,3,1,'1997-10-09','123456789','10000','123456789','hop@gmail.com','Hải châu'),
	(106,'Nguyên',1,3,1,'1978-12-09','123456789','5000','123456789','nguyen@gmail.com','Đà Nẵng');
      

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
    (3, 'thức ăn',500,2,1),
    (4, 'nước uống',500,4,1),
	(5, 'thuê xe di chuyển ',500,2,1);
    

insert service_type() value
	(1,'Room'),
    (2,'House'),
    (3,'Villa');

	insert rental_type() value
    (1,'Ngày',1000),
    (2,'Tuần',2000),
    (3,'Tháng',3000);


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

-- task 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.: 
select *
from employee
where (full_name like 'H%' or full_name like'N%' or full_name like 'K%') and length(full_name) < 15;

-- task 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT *
from customer kh
where (timestampdiff(year,kh.birthday,current_date()) between 18 and 50) and kh.`address` in('Da Nang','Quang Tri');

-- task 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT kh.full_name as 'name khach hang', lk.name_customer_type, count(kh.id_customer) as 'so lan dat phong' 
from customer kh
join contract hd on kh.id_customer = hd.id_customer
join customer_type lk on lk.id_customer_type = kh.id_customer_type
where kh.id_customer_type = 1
group by kh.id_customer
order by count(kh.id_customer);

-- task 5.	Hiển thị IDKhachHang, Honame, nameLoaiKhach, IDHopDong, nameDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + Sosalary*price, với Sosalary và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. 
-- (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.id_customer, kh.full_name, lk.name_customer_type, hd.id_contract, dv.name_service, hd.contract_start_date, hd.contrac_end_day, 
(dv.rental_cost + hdct.amount * dvdk.price) as 'tong tien'
from customer kh
left join customer_type lk on lk.id_customer_type = kh.id_customer_type
left join contract hd on kh.id_customer = hd.id_customer
left join `service` dv on hd.id_service = dv.id_service
left join detail_contract hdct on hdct.id_contract = hd.id_contract
left join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service;

-- task 6.	Hiển thị IDDichVu, nameDichVu, DienTich, ChiPhiThue, nameLoaiDichVu 
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 
-- (Quý 1 là tháng 1, 2, 3).-- 

 select dv.id_service,dv.name_service,area,rental_cost,name_service_type, hd.contract_start_date
 from `service` dv
  left join contract hd on hd.id_service = dv.id_service
  left join service_type ldv on dv.id_service_type = ldv.id_service_type 
 where dv.id_service not in (select hd.id_service
 from contract hd
 where hd.contract_start_date between '2019-1-1' and '2019-3-31')
 group by id_service;
 
 -- task 7.	Hiển thị thông tin IDDichVu, nameDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, nameLoaiDichVu 
 -- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
--  nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select dv.id_service, dv.name_service, area, max_people, rental_cost, ldv.name_service_type, hd.contract_start_date
from `service` dv
join contract hd on hd.id_service = dv.id_service
join service_type ldv on dv.id_service_type = ldv.id_service_type 
where year(hd.contract_start_date) = '2018'
	and dv.id_service not in (select hd.id_service
	from contract hd
	where year(hd.contract_start_date) = '2019')
group by id_service;

-- task 8.	Hiển thị thông tin HonameKhachHang có trong hệ thống, 
-- với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

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

-- task 9.	Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.contract_start_date) as 'thang(nam 2019)', count(month(hd.contract_start_date)) as 'so salary hop dong' 
from contract hd
where year(hd.contract_start_date) = '2019'
group by month(hd.contract_start_date);

-- task 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SosalaryDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet). 
select hd.id_contract, contract_start_date, contrac_end_day, deposit
, count(hdct.id_contract) amount_attach_service
from contract hd
join detail_contract hdct on hdct.id_contract = hd.id_contract
join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service
group by hdct.id_contract;

-- task 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
-- nameLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select kh.full_name, lk.name_customer_type, `address`, name_attach_service, price
from contract hd
left join customer kh on hd.id_customer = kh.id_customer
left join customer_type lk on lk.id_customer_type = kh.id_customer_type
left join detail_contract hdct on hdct.id_contract = hd.id_contract
left join attach_service dvdk on dvdk.id_attach_service = hdct.id_attach_service
where `address` in ('Quang Ngai', 'Vinh') and name_customer_type = 'Diamond';


-- task 12.	Hiển thị thông tin IDHopDong, nameNhanVien, nameKhachHang, SoDienThoaiKhachHang, 
-- nameDichVu, SosalaryDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết),
--  TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
--  nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

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
    
-- task  13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
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
    
-- task 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, nameLoaiDichVu, nameDichVuDiKem, SoLanSuDung. 
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

-- task 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, Honame, TrinhDo, 
-- nameBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select nv.id_employee, nv.full_name, education_degree, name_division, nv.`number`, `address`
from employee nv
left join contract hd on hd.id_employee = nv.id_employee
left join education_degree td on td.id_education_degree = nv.id_education_degree
left join division bp on bp.id_division = nv.id_division
where year(contract_start_date) between 2018 and 2019 
or contract_start_date is null
group by nv.id_employee
having count(nv.id_employee) <=3;

-- task 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

-- delete from employee
-- where id_employee not in (
-- select id_employee
-- from contract
-- where year(contract_start_date) between '2019' and '2020' 
-- );

 -- task 17. Cập nhật thông tin những khách hàng có nameLoaiKhachHang 
--  từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng 
--  với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.         
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

-- dùng lệnh dưới để check trước và sau khi update khashc hàng từ platinum -> diamond 

-- select kh.full_name, kh.id_customer_type, name_customer_type
-- from customer kh
-- join customer_type lk on lk.id_customer_type = kh.id_customer_type;
 
-- task 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).

-- SET FOREIGN_KEY_CHECKS=0;
-- delete from customer 
-- where id_customer in 
-- 	(select id_customer
-- 	from contract
-- 	where year(contract_start_date) < 2016
-- 	);
-- SET FOREIGN_KEY_CHECKS=1; 

-- task 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 4 lần trong năm 2019 lên gấp đôi. 
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

-- task 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), Honame, Email, SoDienThoai, NgaySinh, DiaChi. 

select id_employee as id,full_name,email,`number`,birthday,`address`, 'employee'
from employee
union all
select id_customer,full_name,email,`number`,birthday,`address`, 'khach hang'
from customer;

-- task 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ 
-- là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”

create view v_employee as
select nv.id_employee, nv.full_name, `address`, contract_start_date
from employee nv
join contract hd on nv.id_employee = hd.id_employee
where contract_start_date = '2019/12/12' and `address` = 'Hai chau'
group by full_name
;
-- drop view v_employee;

 -- task 2.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả 
 -- các Nhân viên được nhìn thấy bởi khung nhìn này. 
 
 
 
--  select * from v_employee;
--  
--   SET SQL_SAFE_UPDATES = 0;    
--   
--  update v_employee
-- 	set `address` = 'Liên Chiểu' 
--     where id_employee in (
-- 		select id_employee
--         from v_employee);

 
-- task 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với 
-- Id Khách hàng được truyền vào như là 1 tham số của Sp_1
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

--  24.	Tạp Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 
-- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được 
-- trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

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

-- task 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị 
-- tổng số lượng bản ghi còn lại có trong bảng HopDong ra priceo diện console của database 

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

