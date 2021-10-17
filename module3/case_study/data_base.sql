drop database if exists furama_resort;
create database furama_resort;
use furama_resort;

create table vi_tri(
IDViTri int primary key,
TenViTri varchar(50)
);
 
 create table trinh_do(
 IDTrinhDo int primary key,
 TrinhDo varchar(50)
 );
 
 create table bo_phan(
 IDBoPhan int primary key,
 TenBoPhan varchar(50)
 );
 
create table nhan_vien(
IDNhanVien int,
HoTen varchar(50),
IDViTri int,
IDTrinhDo int,
IDBoPhan int,
NgaySinh date,
SOCMTND varchar(45),
Luong varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45),
primary key (IDNhanVien, IDViTri, IDTrinhDo, IDBoPhan ),
foreign key (IDViTri) references vi_tri(IDViTri),
foreign key (IDTrinhDo) references trinh_do(IDTrinhDo),
foreign key (IDBoPhan) references bo_phan(IDBoPhan)
 );
 

  
 create table loai_khach(
 IDLoaiKhach int primary key,
 TenLoaiKhach varchar(50)
 );
 
create table khach_hang(
IDKhachHang int,
IDLoaiKhach int,
HoTen varchar(50),
NgaySinh date,
SOCMTND varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45),
primary key (IDKhachHang, IDLoaiKhach),
foreign key (IDLoaiKhach) references loai_khach(IDLoaiKhach)
);

 
create table kieu_thue(
IDKieuThue int primary key,
TenKieuThue varchar(50),
Gia int
);

create table loai_dich_vu(
IDLoaiDichVu int primary key,
TenLoaiDichVu varchar(50)
);

create table dich_vu(
IDDichVu int,
TenDichVu varchar(45),
DienTich int,
SoTang int,
SoNguoiToiDa varchar(45),
ChiPhiThue varchar(45),
IDKieuThue int,
IDLoaiDichVu int,
TrangThai varchar(45),
primary key (IDDichVu, IDKieuThue, IDLoaiDichVu),
foreign key (IDKieuThue) references kieu_thue(IDKieuThue),
foreign key (IDLoaiDichVu) references loai_dich_vu(IDLoaiDichVu)
);

create table hop_dong(
IDHopDong int,
IDNhanVien int,
IDKhachHang int,
IDDichVu int,
NgayLamHopDong date,
NgayKetThuc date,
TienDatCoc int,
TongTien int, 	
primary key (IDHopDong, IDNhanVien, IDKhachHang, IDDichVu),
foreign key (IDNhanVien) references nhan_vien(IDNhanVien),
foreign key (IDKhachHang) references khach_hang(IDKhachHang),
foreign key (IDDichVu) references dich_vu(IDDichVu)
);

create table dich_vu_di_kem(
IDDichVuDiKem int primary key ,
TenDichVuDiKem varchar(45),
Gia int,
DonVi int,
TrangThaiKhaDung varchar(45)
);

create table hop_dong_chi_tiet(
IDHopDongChiTiet int,
IDHopDong int,
IDDichVuDiKem int,
SoLuong int,
primary key (IDHopDongChiTiet, IDHopDong, IDDichVuDiKem),
foreign key (IDHopDong) references hop_dong(IDHopDong),
foreign key (IDDichVuDiKem) references dich_vu_di_kem(IDDichVuDiKem)
);


