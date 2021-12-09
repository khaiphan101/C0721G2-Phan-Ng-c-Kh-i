insert customer_type value
	(1,'Diamond'),
    (2,'Platium'),
    (3,'Gold'),
    (4,'Sliver'),
    (5,'Member');
insert customer(id,address,birth_day,email,gender,id_card,name,phone,customer_type_id) values
('KH-0001',"Đà Nẵng",'1980-10-20','hongnguyen@gmail.com',b'1','012346789','Nguyễn Thị Thanh Hồng','0901123123', 1),
('KH-0002',"Quảng Trị",'1980-10-20','haiyen@gmail.com',b'1','012356789','Trịnh Thị Hải Yến','0901123123', 2),
('KH-0003',"Quảng Bình",'1980-10-20','vu@gmail.com',b'1','012346789','Nguyễn Thanh Vũ','0901123123',3),
('KH-0004',"Vinh",'1980-10-20','loc@gmail.com',b'1','012345689','Nguyễn Bảo Lộc','0901123123', 4),
('KH-0005',"Huế",'1980-10-20','diem@gmail.com',b'1','012345689','Mai Thị Diễm','0901123123', 5),
('KH-0006',"Cà Mau",'1980-10-20','hoang@gmail.com',b'1','012345789','Nguyễn Bảo Hoàng','0901123123', 1),
('KH-0007',"Đà Nẵng",'1980-10-20','hongnguyen@gmail.com',b'1','012345689','Nguyễn Thị Thanh Hồng','0901123123', 1),
('KH-0008',"Quảng Trị",'1980-10-20','haiyen@gmail.com',b'1','012345789','Trịnh Thị Hải Yến','0901123123', 2),
('KH-0009',"Quảng Bình",'1980-10-20','vu@gmail.com',b'1','012346789','Nguyễn Thanh Vũ','0901123123',3),
('KH-0010',"Vinh",'1980-10-20','loc@gmail.com',b'1','012345789','Nguyễn Bảo Lộc','0901123123', 4),
('KH-0011',"Huế",'1980-10-20','diem@gmail.com',b'1','012345789','Mai Thị Diễm','0901123123', 5),
('KH-0012',"Cà Mau",'1980-10-20','hoang@gmail.com',b'1','012346789','Nguyễn Bảo Hoàng','0901123123', 1),
('KH-0013',"Đà Nẵng",'1980-10-20','hongnguyen@gmail.com',b'1','012345789','Nguyễn Thị Thanh Hồng','0901123123', 1),
('KH-0014',"Quảng Trị",'1980-10-20','haiyen@gmail.com',b'1','012345689','Trịnh Thị Hải Yến','0901123123', 2),
('KH-0015',"Quảng Bình",'1980-10-20','vu@gmail.com',b'1','012345689','Nguyễn Thanh Vũ','0901123123',3),
('KH-0016',"Vinh",'1980-10-20','loc@gmail.com',b'1','012346789','Nguyễn Bảo Lộc','0901123123', 4),
('KH-0017',"Huế",'1980-10-20','diem@gmail.com',b'1','012356789','Mai Thị Diễm','0901123123', 5),
('KH-0018',"Cà Mau",'1980-10-20','hoang@gmail.com',b'1','012346789','Nguyễn Bảo Hoàng','0901123123', 1),
('KH-0019',"Đà Nẵng",'1980-10-20','hongnguyen@gmail.com',b'1','012345789','Nguyễn Thị Thanh Hồng','0901123123', 1),
('KH-0020',"Quảng Trị",'1980-10-20','haiyen@gmail.com',b'1','012345789','Trịnh Thị Hải Yến','0901123123', 2),
('KH-0021',"Quảng Bình",'1980-10-20','vu@gmail.com',b'1','012345789','Nguyễn Thanh Vũ','0901123123',3),
('KH-0022',"Vinh",'1980-10-20','loc@gmail.com',b'1','012345679','Nguyễn Bảo Lộc','0901123123', 4),
('KH-0023',"Huế",'1980-10-20','diem@gmail.com',b'1','012345679','Mai Thị Diễm','0901123123', 5),
('KH-0024',"Cà Mau",'1980-10-20','hoang@gmail.com',b'1','012345678','Nguyễn Bảo Hoàng','0901123123', 1);

-- insert user(id_user,is_enable,password,username) values
-- (1,b'1','1','admin'),
-- (2,b'1','1','user');

-- insert role(id,name) values
-- (1,'ROLE_ADMIN'),
-- (2,'ROLE_EMPLOYEE'),
-- (3,'ROLE_CUSTOMER');

-- insert user_role(rol_id,user_id) values
-- (1,1),(2,1)