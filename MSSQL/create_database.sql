create database QuanLyHDNK
go
use [QuanLyHDNK]
go

create table VaiTro(
	maVT nvarchar(2) primary key not null,
	tenVT nvarchar(50) not null,
	flagVT bit not null DEFAULT 0,
)
go

create table TaiKhoan(
	maTK nvarchar(15) primary key not null,
	tenTK nvarchar(150) not null, 
	anhTK varbinary(MAX),
	matKhau varchar(200) not null, 
	ngayTao date not null DEFAULT getdate(),
	gioiTinh bit,
	ngaySinh date not null,
	email nvarchar(50) not null unique,
	sdt char(10) not null unique,
	diaChi nvarchar(200),
	maVaiTro nvarchar(2) not null,
	flagTK bit not null DEFAULT 0,
	--CONSTRAINT checkNS CHECK (DATEDIFF(YEAR, ngaySinh, getdate())<=150 AND DATEDIFF(YEAR, ngaySinh, getdate()) >= 18),--
	CONSTRAINT checkMTK CHECK (LEN(maTK)>=5),
	CONSTRAINT fk_tk_vaitro Foreign key (maVaiTro) REFERENCES VaiTro(maVT) ON UPDATE CASCADE,
)

go
create table LoaiHoatDong(
	maLHD nvarchar(2) primary key not null,
	tenLHD nvarchar(50) not null,
	flagLHD bit not null DEFAULT 0,
)
go 

create table HoatDong(
	maHD int primary key not null identity(1,1),
	tenHD nvarchar(200) not null,
	noiDung ntext not null,
	maTheLoai nvarchar(2) not null,
	ngayDang datetime not null DEFAULT getdate(),
	ngayBD datetime,
	ngayKT datetime,
	soLuongDK smallint,
	diaDiem nvarchar(200),
	anh varbinary(MAX),
	maNguoiDang nvarchar(15) not null,
	flagHD bit not null DEFAULT 0,
	CONSTRAINT checkNBD CHECK (ngayBD >= ngayDang),
	CONSTRAINT checkNKT CHECK (ngayKT > ngayBD),
	CONSTRAINT checkSLDK CHECK (soLuongDK=null OR (soLuongDK>0 AND ngayBD!=NULL AND ngayKT!=NULL)),
	CONSTRAINT fk_hd_maNguoiDangHD Foreign key (maNguoiDang) REFERENCES TaiKhoan(maTK),
	CONSTRAINT fk_hd_theLoai Foreign key (maTheLoai) REFERENCES LoaiHoatDong(maLHD) ON UPDATE CASCADE,	
)
go

create table DangKy(
	maDK int primary key not null identity(1,1),  
	maHoatDong int not null,
	maTaiKhoan nvarchar(15) not null,
	thoiGian datetime not null DEFAULT getdate(),
	flagDK bit not null DEFAULT 0,
	CONSTRAINT fk_dk_maHoatDong Foreign key (maHoatDong) REFERENCES HoatDong(maHD), 
	CONSTRAINT fk_dk_maTaiKhoan Foreign key (maTaiKhoan) REFERENCES TaiKhoan(maTK),
	CONSTRAINT uc_dk_taiKhoanDangKy UNIQUE (maHoatDong,maTaiKhoan),
)
go
create table ThongBao(
	maTB int primary key not null identity(1,1),
	tieuDe nvarchar(100) not null,
	noiDung ntext not null,
	thoiGian datetime not null DEFAULT getdate(),
	maHoatDong int not null,
	maNguoiDang nvarchar(15) not null,
	flagTB bit not null DEFAULT 0,
	CONSTRAINT fk_tb_maHoatDong Foreign key (maHoatDong) REFERENCES HoatDong(maHD),
	CONSTRAINT fk_tb_maNguoiDang Foreign key (maNguoiDang) REFERENCES TaiKhoan(maTK),
)
go