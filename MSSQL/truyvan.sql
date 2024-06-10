--*******INSERT*******
INSERT VaiTro(maVT, tenVT) VALUES('SV', N'Sinh viên')
GO

INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('NC', N'Nghiên cứu')
GO

INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('TK','mk',N'ten','ND', '@gmail.com','0123456789',NULL,'12-01-2000',NULL)
GO

INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'ten','KH', N'Noi dung','12-02-2024', '12-04-2024',5,'TKCLBA1','Phong AAA',NULL)
GO

INSERT DangKy(maHoatDong,maTaiKhoan)
VALUES(15,'N21DCCN000')
GO

--*******SELECT*******
--HoatDong
(SELECT maHoatDong
FROM DangKy
WHERE maTaiKhoan LIKE 'N21DCCN999')
--**********TOI UU TRUY VAN ******************

SELECT	HoatDong.*
        
        FROM HoatDong
        WHERE flagHD = 0 
		AND HoatDong.ngayBD<=GETDATE()
		AND HoatDong.ngayKT>=GETDATE() 
		AND maHD NOT IN (SELECT maHoatDong		FROM DangKy
							WHERE maTaiKhoan LIKE 'N21DCCN999'
							AND flagDK =0)
GO--done

--**********TOI UU TRUY VAN ******************
SELECT	DangKy.maDK,DangKy.thoiGian, HoatDong.*, 
		NguoiDang.tenTK as tenNguoiDang, 
		LoaiHoatDong.tenLHD as theLoai
		FROM DangKy
		JOIN HoatDong
		ON DangKy.flagDK=0 AND DangKy.maTaiKhoan ='N21DCCN000' AND HoatDong.ngayKT>=GETDATE() AND DangKy.maHoatDong = HoatDong.maHD
		JOIN (SELECT maTK, tenTK FROM TaiKhoan WHERE flagTK =0) as NguoiDang 
		ON HoatDong.maNguoiDang = NguoiDang.maTK  
		JOIN LoaiHoatDong
		ON HoatDong.maTheLoai= LoaiHoatDong.maLHD
GO--done

--**********TOI UU TRUY VAN ******************		

SELECT	DangKy.maDK, DangKy.thoiGian, HoatDong.* ,
		NguoiDang.tenTK AS tenNguoiDang, 
		LoaiHoatDong.tenLHD AS theLoai 
		FROM DangKy 
		JOIN HoatDong 
		ON DangKy.flagDK=0 AND DangKy.maTaiKhoan ='N21DCCN000' AND HoatDong.ngayKT < GETDATE() AND DangKy.maHoatDong = HoatDong.maHD 
		JOIN (SELECT maTK, tenTK FROM TaiKhoan WHERE flagTK =0) AS NguoiDang 
		ON HoatDong.maNguoiDang = NguoiDang.maTK 
		JOIN LoaiHoatDong 
		ON HoatDong.maTheLoai= LoaiHoatDong.maLHD 



SELECT HoatDong.maHD as maHD, HoatDong.tenHD as tenHD, HoatDong.noiDung as noiDung, LoaiHoatDong.tenLHD as theLoai, 
NguoiDang.tenTK as tenNguoiDang, HoatDong.diaDiem as diaDiem, HoatDong.anh as anh, HoatDong.soLuongDK as soLuongDK,  
HoatDong.ngayBD as ngayBD , HoatDong.ngayKT as ngayKT, HoatDong.ngayDang as ngayDang 
FROM HoatDong, LoaiHoatDong, TaiKhoan AS NguoiDang, TaiKhoan AS NguoiXem, DangKy
WHERE DangKy.maTaiKhoan = 'N21DCCN000' AND DangKy.maTaiKhoan = NguoiXem.maTK 
AND DangKy.maHoatDong=HoatDong.maHD
AND maTheLoai = LoaiHoatDong.maLHD AND NguoiDang.maTK=HoatDong.maNguoiDang

GO
SELECT HoatDong.maHD as maHD, HoatDong.tenHD as tenHD, HoatDong.noiDung as noiDung, LoaiHoatDong.tenLHD as theLoai, 
NguoiDang.tenTK as tenNguoiDang, HoatDong.diaDiem as diaDiem, HoatDong.anh as anh, HoatDong.soLuongDK as soLuongDK,
HoatDong.ngayBD as ngayBD , HoatDong.ngayKT as ngayKT, HoatDong.ngayDang as ngayDang 
FROM HoatDong, LoaiHoatDong, TaiKhoan AS NguoiDang, TaiKhoan AS NguoiXem, DangKy 
WHERE DangKy.maTaiKhoan= 'N21DCCN000' AND ngayKT<GETDATE() AND DangKy.maTaiKhoan = NguoiXem.maTK 
AND DangKy.maHoatDong=HoatDong.maHD AND maTheLoai = LoaiHoatDong.maLHD AND NguoiDang.maTK=HoatDong.maNguoiDang
GO

--TaiKhoan
UPDATE DangKy SET flagDK = 1 WHERE maTaiKhoan='N21DCCN000' AND maHoatDong =''



--quanly
SELECT maTK, tenTK, matKhau,ngayTao,gioiTinh,ngaySinh,email,sdt,diaChi,maVaiTro
FROM TaiKhoan
GO
--sinhvien
SELECT maTK, tenTK, matKhau,ngayTao,gioiTinh,ngaySinh,email,sdt,diaChi,maVaiTro
FROM TaiKhoan
WHERE maTK='' AND matKhau=''
GO
--*******UPDATE*******
--TaiKhoan
UPDATE TaiKhoan
SET matkhau=''
WHERE maTK ='' AND matKhau=''
--quan li
UPDATE TaiKhoan
SET maTK ='', tenTK='', matKhau='',gioiTinh='',ngaySinh='',email='',sdt='',diaChi=''
WHERE maTK='' 
-- sinhvien

--*******DELETE*******

--**********TOI UU TRUY VAN ******************
SELECT ThongBao.*,TaiKhoan.tenTK 
FROM ThongBao
JOIN (SELECT HoatDong.maHD
	FROM HoatDong
	JOIN DangKy 
	ON HoatDong.maHD=DangKy.maHoatDong 
	AND DangKy.maTaiKhoan='N21DCCN000') AS HD
ON ThongBao.flagTB=0 AND ThongBao.maHoatDong=HD.maHD
JOIN TaiKhoan
ON ThongBao.maNguoiDang= TaiKhoan.maTK
ORDER BY ThongBao.thoiGian






SELECT	HoatDong.*,
        TaiKhoan.tenTK as tenNguoiDang,
        LoaiHoatDong.tenLHD as theLoai
        FROM HoatDong, LoaiHoatDong, TaiKhoan, DangKy
        WHERE HoatDong.ngayKT>GETDATE() 
		AND HoatDong.maTheLoai = LoaiHoatDong.maLHD 
		AND TaiKhoan.maTK=HoatDong.maNguoiDang


SELECT HoatDong.*,
LoaiHoatDong.tenLHD as theLoai, 
NguoiDang.tenTK as tenNguoiDang 
FROM HoatDong, LoaiHoatDong, TaiKhoan AS NguoiDang, DangKy
WHERE DangKy.maTaiKhoan= 'N21DCCN000' AND ngayKT>=GETDATE() 
AND DangKy.maHoatDong=HoatDong.maHD 
AND HoatDong.maTheLoai = LoaiHoatDong.maLHD 
AND NguoiDang.maTK=HoatDong.maNguoiDang
/*

NguoiDang.tenTK as tenNguoiDang, LoaiHoatDong.maLHD AS theLoai
*/
SELECT DangKy.maDK, HoatDong.*, NguoiDang.tenTK as tenNguoiDang, LoaiHoatDong.tenLHD as theLoai
FROM DangKy
JOIN HoatDong
ON DangKy.maTaiKhoan ='N21DCCN000' AND HoatDong.ngayKT>=GETDATE() AND DangKy.maHoatDong = HoatDong.maHD
JOIN (SELECT TaiKhoan.maTK, TaiKhoan.tenTK FROM TaiKhoan) as NguoiDang 
ON HoatDong.maNguoiDang = NguoiDang.maTK  
JOIN LoaiHoatDong
ON HoatDong.maTheLoai= LoaiHoatDong.maLHD
GO

INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, anhTK, diaChi, ngaySinh, gioiTinh)
VALUES('ADMIN','123456',N'Quản lý hệ thống','QL','admin@gmail.com','0123456789',NULL,NULL,'12-01-2000',NULL)

SELECT * 
FROM TaiKhoan
OrDER BY maTK


SELECT *  FROM HoatDong WHERE maNguoiDang='N21DCCN000' and ngayBD<GETDATE()
SELECT *  FROM HoatDong WHERE maNguoiDang='N21DCCN000' and ngayKT>GETDATE()
SELECT *  FROM HoatDong WHERE maNguoiDang='N21DCCN000' and ngayBD>GETDATE()

INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Phong trào giúp đỡ những hộ dân chịu ảnh hưởng bởi hạn mặn ở miền Nam','TN',
	N'Phong trào giúp đỡ những hộ dân chịu ảnh hưởng bởi hạn mặn ở miền Nam...','05-29-2024',
	'06-30-2024',null,'CLBA1','Phong B',NULL)

UPDATE HoatDong SET flagDK = 1 WHERE maTaiKhoan='N21DCCN000' AND maHoatDong =''
GO