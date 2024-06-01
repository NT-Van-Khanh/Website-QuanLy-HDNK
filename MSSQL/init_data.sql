USE [QuanLyHDNK]
GO

DELETE FROM ThongBao
GO

DELETE FROM  DangKy
GO

DELETE FROM HoatDong
GO

DELETE FROM TaiKhoan
GO

DELETE FROM LoaiHoatDong
GO

DELETE FROM VaiTro
GO

INSERT VaiTro(maVT, tenVT) VALUES('SV', N'Sinh viên')
INSERT VaiTro(maVT, tenVT) VALUES('ND', N'Người đăng bài')
INSERT VaiTro(maVT, tenVT) VALUES('QL', N'Quản lí hệ thống')
GO

INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('LB', N'Câu lạc bộ')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('TN', N'Tình nguyện')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('HN', N'Hướng nghiệp')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('DH', N'Đoàn hội')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('SK', N'Sự kiện')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('KH', N'Khóa học')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('NC', N'Nghiên cứu')
GO

INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('ADMIN','123456',N'Quản lý hệ thống','QL','admin@gmail.com','0123456789',NULL,'12-01-2000',NULL)
INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('CLBA1','123456',N'Thư kí câu lạc bộ A-1','ND','clba@gmail.com','0123456788',NULL,'12-01-2000',NULL)
INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('CLBB1','123456',N'Thư kí câu lạc bộ B-1','ND','clbb@gmail.com','0123456777',NULL,'5-11-2000',NULL)
INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('N21DCCN000','123456',N'NGUYEN A','SV', 'n21dccn000@gmail.com','0123456666',NULL,'12-01-2003',1)
INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('N21DCCN999','123456',N'NGUYEN A','SV', 'n21dccn999@gmail.com','0123453556',NULL,'12-08-2003',0)
INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('N21DCCN888','123456',N'NGUYEN A','SV', 'n21dccn888@gmail.com','0123451366',NULL,'12-08-2003',0)
INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('N21DCCN043','123456',N'NGUYEN A','SV', 'n21dccn043@gmail.com','0123459366',NULL,'12-08-2003',0)
GO

INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Khóa ôn tập thi cuối kì môn A','KH',
	N'Khóa ôn tập thi cuối kì do CLB A tổ chức, dành cho các bạn sinh viên muốn ôn thi môn A','6-01-2024',
	'6-10-2024',5,'CLBA1','Phong AAA',NULL)

INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Khóa ôn tập thi cuối kì môn B','KH',
	N'Khóa ôn tập thi cuối kì do CLB A tổ chức, dành cho các bạn sinh viên muốn ôn thi môn B','06-5-2024',
	'06-25-2024',10,'CLBB1','Phong B',NULL)
INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Khóa ôn tập thi cuối kì môn A', 'TN',
	N'Khóa ôn tập thi cuối kì do CLB A tổ chức, dành cho các bạn sinh viên muốn ôn thi môn C','23:59 05-28-2024',
	'06-10-2024',5,'CLBB1','Phong A1',NULL)
INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Phong trào bảo vệ môi trường','TN',
	N'Phong trào trồng cây xanh, vệ sinh đường phố trên con đường X gần trường học','06-01-2024',
	'06-30-2024',null,'CLBB1','Phong B',NULL)
INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Phong trào chạy bộ gây quỷ ','TN',
	N'Phong trào chạy bộ gây quỷ ủng hộ...','06-01-2024',
	'06-30-2024',null,'CLBB1','Phong B',NULL)
INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Phong trào giúp đỡ những hộ dân chịu ảnh hưởng bởi hạn mặn ở miền Nam','TN',
	N'Phong trào giúp đỡ những hộ dân chịu ảnh hưởng bởi hạn mặn ở miền Nam...','05-29-2024',
	'06-30-2024',null,'CLBA1','Phong B',NULL)
GO




--tuy vao ngay, can than--
INSERT DangKy(maHoatDong,maTaiKhoan)
VALUES(19,'N21DCCN000')
INSERT DangKy(maHoatDong,maTaiKhoan)
VALUES(18,'N21DCCN000')
INSERT DangKy(maHoatDong,maTaiKhoan)
VALUES(19,'N21DCCN999')
INSERT DangKy(maHoatDong,maTaiKhoan)
VALUES(27,'N21DCCN999')
INSERT DangKy(maHoatDong,maTaiKhoan)
VALUES(27,'N21DCCN888')
go
INSERT ThongBao(maHoatDong, maNguoiDang, tieuDe, noiDung)
VALUES(19,'CLBB1',N'Test1',N'NoiDung')