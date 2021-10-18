drop database if exists furama_resort;
create database furama_resort;
use furama_resort;

create table vi_tri(
id_vi_tri int primary key,
ten_vi_tri varchar(50)
);
 
 create table trinh_do(
 id_trinh_do int primary key,
 trinh_do varchar(50)
 );
 
 create table bo_phan(
 id_bo_phan int primary key,
 ten_bo_phan varchar(50)
 );
 
create table nhan_vien(
id_nhan_vien int,
ho_ten varchar(50),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_CMNTND varchar(45),
luong varchar(45),
SDT varchar(45),
email varchar(45),
dia_chi varchar(45),
primary key (id_nhan_vien),
foreign key (id_vi_tri) references vi_tri(id_vi_tri),
foreign key (id_trinh_do) references trinh_do(id_trinh_do),
foreign key (id_bo_phan) references bo_phan(id_bo_phan)
 );
 
 create table loai_khach(
 id_loai_khach int primary key,
 ten_loai_khach varchar(50)
 );
 
create table khach_hang(
id_khach_hang int,
id_loai_khach int,
ho_ten varchar(50),
ngay_sinh date,
so_CMNTND varchar(45),
SDT varchar(45),
email varchar(45),
dia_chi varchar(45),
primary key (id_khach_hang),
foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);

 
create table kieu_thue(
id_kieu_thue int primary key,
ten_kieu_thue varchar(50),
gia int
);

create table loai_dich_vu(
id_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(50)
);

create table dich_vu(
id_dich_vu int,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai varchar(45),
primary key (id_dich_vu),
foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

create table hop_dong(
id_hop_dong int,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int, 	
primary key (id_hop_dong),
foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key (id_khach_hang) references khach_hang(id_khach_hang),
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int primary key ,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
primary key (id_hop_dong_chi_tiet),
foreign key (id_hop_dong) references hop_dong(id_hop_dong),
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

-- task 1: Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.
insert vi_tri values 
(1,'Manager'),(2,'HR'),(3,'Chef'),(4,'Staff');

insert trinh_do values
(1,'DH'),(2,'CD'),(3,'TC'),(4,'SDH');

insert bo_phan values 
(1,'operation'),(2,'Service'),(3,'Administrative'), (4,'Sale-Marketing');

 insert nhan_vien values
	(101,'Khải',1,2,1,'1998-09-09','123456789','6000','123456789','khai@gmail.com','Quảng Ngãi'),
	(102,'Nam',2,1,1,'1988-02-09','123456789','4000','123456789','namh@gmail.com','Quảng Nam'),
	(103,'Hiền',3,3,1,'1978-01-09','123456789','8000','123456789','hien@gmail.com','Quảng Ninh'),
	(104,'Thông',4,2,1,'1996-08-09','123456789','9000','123456789','thong@gmail.com','Quảng Trị'),
	(105,'Hợp',2,3,1,'1997-10-09','123456789','10000','123456789','hop@gmail.com','Quảng Nam'),
	(106,'Nguyên',1,3,1,'1978-12-09','123456789','5000','123456789','nguyen@gmail.com','Đà Nẵng');
      

insert loai_khach value
	(1,'Diamond'),
    (2,'Platium'),
    (3,'Gold'),
    (4,'Sliver'),
    (5,'Member');

insert khach_hang(id_khach_hang,id_loai_khach,ho_ten,ngay_sinh,dia_chi) values
(101,2,'Nguyen An', '1980-10-20', 'Da Nang'),
(102,3,'Nguyen Binh', '1989-10-20', 'Quang Tri'),
(103,1,'Nguyen An', '1965-10-20', 'Vinh'),
(104,1,'Nguyen Trung', '1988-11-20', 'Quang Ngai'),
(105,1,'Nguyen Thinh', '1989-10-20', 'Ha Noi'),
(106,1,'Nguyen Tung', '1965-10-20', 'Da Nang');


insert dich_vu_di_kem() value 
	(1, 'massage',500,1,1),
    (2, 'karaoke',500,1,1),
    (3, 'thức ăn',500,2,1),
    (4, 'nước uống',500,4,1),
	(5, 'thuê xe di chuyển ',500,2,1);
    

insert loai_dich_vu() value
	(1,'Room'),
    (2,'House'),
    (3,'Villa');

	insert kieu_thue() value
    (1,'Ngày',1000),
    (2,'Tuần',2000),
    (3,'Tháng',3000);


insert into dich_vu() value
	(101,'Villa_A',50, 2,10, 3000,1,3,null),
	(102,'Villa_B',60, 2,8, 3500,1,3,null),
	(103,'House_A',30, 1,4, 1500,2,2,null),
	(104,'House_B',40, 2,2, 2000,1,2,null),
	(105,'Room_A',20, 1,2, 800,1,1,null);

insert hop_dong values 
	(1,101,103,101,'2018-10-10','2020-10-11',1000,2000),
	(2,103,104,102,'2019-05-15','2021-10-18',400,800),
	(3,103,104,102,'2018-08-15','2021-09-18',400,800),
    (4,103,106,105,'2019-02-24','2021-03-18',400,800),
    (5,103,106,105,'2019-05-24','2021-03-18',400,800),
    (6,101,106,105,'2018-03-02','2021-03-18',400,800),
	(7,103,101,105,'2019-05-24','2021-03-18',400,800),
    (8,101,101,105,'2019-12-02','2021-03-18',400,800),
    (9,101,101,105,'2019-12-02','2021-03-18',400,800);

insert hop_dong_chi_tiet values
(1,1,1,1),(2,3,2,1),(3,2,3,2),(4,3,2,1),(5,2,1,3),(6,4,3,2),(7,5,4,3),(8,6,5,4),(9,8,4,3),(10,9,4,4);

-- task 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.: 
select *
from nhan_vien
where (ho_ten like 'H%' or ho_ten like'N%' or ho_ten like 'K%') and length(ho_ten) < 15;

-- task 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT *
from khach_hang kh
where (timestampdiff(year,kh.ngay_sinh,current_date()) between 18 and 50) and kh.dia_chi in('Da Nang','Quang Tri');

-- task 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT kh.ho_ten as 'ten khach hang', lk.ten_loai_khach, count(kh.id_khach_hang) as 'so lan dat phong' 
from khach_hang kh
join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
where kh.id_loai_khach = 1
group by kh.id_khach_hang
order by count(kh.id_khach_hang);

-- task 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. 
-- (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.id_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, 
(dv.chi_phi_thue + hdct.so_luong * dvdk.gia) as 'tong tien'
from khach_hang kh
left join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
left join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
left join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
left join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
left join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem;

-- task 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 
-- (Quý 1 là tháng 1, 2, 3).-- 

 select dv.id_dich_vu,dv.ten_dich_vu,dien_tich,chi_phi_thue,ten_loai_dich_vu, hd.ngay_lam_hop_dong
 from dich_vu dv
  left join hop_dong hd on hd.id_dich_vu = dv.id_dich_vu
  left join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu 
 where dv.id_dich_vu not in (select hd.id_dich_vu
 from hop_dong hd
 where hd.ngay_lam_hop_dong between '2019-1-1' and '2019-3-31')
 group by id_dich_vu;
 
 -- task 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
 -- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
--  nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select dv.id_dich_vu, dv.ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ldv.ten_loai_dich_vu, hd.ngay_lam_hop_dong
from dich_vu dv
join hop_dong hd on hd.id_dich_vu = dv.id_dich_vu
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu 
where year(hd.ngay_lam_hop_dong) = '2018'
	and dv.id_dich_vu not in (select hd.id_dich_vu
	from hop_dong hd
	where year(hd.ngay_lam_hop_dong) = '2019')
group by id_dich_vu;

-- task 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, 
-- với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

-- C1: dung group by
select ho_ten
from khach_hang
group by ho_ten;

-- C2: su dung UNION
select ho_ten
from khach_hang
union
select ho_ten
from khach_hang;
 
 -- C3: su dung distinct 
select distinct ho_ten
from khach_hang;

-- task 9.	Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.ngay_lam_hop_dong) as 'thang(nam 2019)', count(month(hd.ngay_lam_hop_dong)) as 'so luong hop dong' 
from hop_dong hd
where year(hd.ngay_lam_hop_dong) = '2019'
group by month(hd.ngay_lam_hop_dong);

-- task 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet). 
select hd.id_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc
, count(hdct.id_hop_dong) so_luong_dich_vu_di_kem
from hop_dong hd
join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by hdct.id_hop_dong;

-- task 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
-- TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select kh.ho_ten, lk.ten_loai_khach, dia_chi, ten_dich_vu_di_kem, gia
from hop_dong hd
left join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
left join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
left join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
left join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
where dia_chi in ('Quang Ngai', 'Vinh') and ten_loai_khach = 'Diamond';


-- task 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, 
-- TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết),
--  TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
--  nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select hd.id_hop_dong, nv.ho_ten 'ten nhan vien', kh.ho_ten 'ten khach hang', kh.SDT, ten_dich_vu_di_kem
, count(hd.id_hop_dong) so_luong_dich_vu_di_kem
,tien_dat_coc, ngay_lam_hop_dong
from hop_dong hd
join nhan_vien nv on nv.id_nhan_vien = hd.id_nhan_vien
join khach_hang kh on kh.id_khach_hang = hd.id_khach_hang
join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by hd.id_hop_dong
having (ngay_lam_hop_dong between '2019-10-1' and '2019-12-31')
and hd.id_hop_dong not in (
	select hd.id_hop_dong
		from hop_dong 
        where ngay_lam_hop_dong between '2019-1-1' and '2019-6-31'
	);
    
-- task  13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select ten_dich_vu_di_kem
, count(ten_dich_vu_di_kem) so_lan_su_dung_nhieu_nhat
from hop_dong_chi_tiet hdct
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by ten_dich_vu_di_kem
having so_lan_su_dung_nhieu_nhat = 
	(select max(t.so_lan_su_dung)
    from (select count(ten_dich_vu_di_kem) so_lan_su_dung
			from hop_dong_chi_tiet hdct
			join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
			group by ten_dich_vu_di_kem
            ) t
	);
    
-- task 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung. 
select hd.id_hop_dong,ten_loai_dich_vu, ten_dich_vu_di_kem
, count(ten_dich_vu_di_kem) so_lan_su_dung
from hop_dong hd
join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
join loai_dich_vu ldv on ldv.id_loai_dich_vu = dv.id_loai_dich_vu
group by ten_dich_vu_di_kem
having so_lan_su_dung = 1
;

-- task  