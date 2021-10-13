DROP DATABASE IF EXISTS quan_ly_don_dat_hang;
CREATE DATABASE quan_ly_don_dat_hang;
USE quan_ly_don_dat_hang;
CREATE TABLE phieu_xuat(
SoPX 	INT PRIMARY KEY ,
NgayXuat	VARCHAR(60)
);

CREATE TABLE vat_tu(
MAVT 	INT PRIMARY KEY ,
TenVT	VARCHAR(60)
);

CREATE TABLE nha_cung_cap(
MaNCC 	INT PRIMARY KEY ,
TenNCC	VARCHAR(60),
DiaChi	VARCHAR(60),
SDT	VARCHAR(60)
);

CREATE TABLE phieu_nhap(
SoPN 	INT PRIMARY KEY ,
NgayNhap	VARCHAR(60)
);

CREATE TABLE don_dat_hang(
SoDH 	INT,
MaNCC INT,
primary key(SoDH),
NgayDH	VARCHAR(60),
foreign key (MaNCC) references nha_cung_cap(MaNCC)
);

CREATE TABLE chi_tiet_phieu_xuat(
SoPX 	INT,
MaVT 	INT,
primary key(SoPX, MaVT),
DGXuat 	INT,
SLXuat	INT,
foreign key (SoPX) references phieu_xuat (SoPX),
foreign key (MaVT) references vat_tu (MaVT)
);

CREATE TABLE chi_tiet_phieu_nhap(
SoPN 	INT,
MaVT 	INT,
primary key(SoPN, MaVT),
DGNhap 	INT,
SLNhap	INT,
foreign key (SoPN) references phieu_nhap (SoPN),
foreign key (MaVT) references vat_tu (MaVT)
);

CREATE TABLE chi_tiet_don_dat_hang(
SoDH 	INT,
MaVT 	INT,
primary key(SoDH, MaVT),
foreign key (SoDH) references don_dat_hang (SoDH),
foreign key (MaVT) references vat_tu (MaVT)
);


