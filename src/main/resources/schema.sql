

CREATE TABLE customers (
                           ma_khach_hang VARCHAR(50) PRIMARY KEY,
                           ten_khach_hang VARCHAR(255),
                           dia_chi VARCHAR(255),
                           tinh_thanh_pho VARCHAR(100),
                           ma_so_thue VARCHAR(50),
                           dien_thoai VARCHAR(20),
                           ngung_theo_doi BOOLEAN
);

CREATE TABLE products (
                          ma_san_pham VARCHAR(50) PRIMARY KEY,
                          ten_san_pham VARCHAR(255),
                          tinh_chat VARCHAR(50), -- Thuốc, Vật tư y tế,...
                          don_vi_tinh_chinh VARCHAR(20),
                          ngung_theo_doi BOOLEAN
);

CREATE TABLE departments (
                             ma_phong_ban VARCHAR(50) PRIMARY KEY,
                             ten_phong_ban VARCHAR(255)
);

CREATE TABLE employees (
                           ma_nhan_vien VARCHAR(50) PRIMARY KEY,
                           tai_khoan VARCHAR(100), -- Ví dụ: AnhNTY1...
                           ten_nhan_vien VARCHAR(255),
                           ma_quan_ly VARCHAR(50),
                           ma_phong_ban VARCHAR(50),
                           loai_hinh VARCHAR(50), -- Cộng tác viên, Nhân viên chính thức
                           FOREIGN KEY (ma_quan_ly) REFERENCES employees(ma_nhan_vien),
                           FOREIGN KEY (ma_phong_ban) REFERENCES departments(ma_phong_ban)
);


CREATE TABLE orders (
                        ma_don_hang VARCHAR(50) PRIMARY KEY,
                        ma_khach_hang VARCHAR(50),
                        ngay_dat DATE,
                        ngay_giao_hang DATE,
                        ngay_thanh_toan DATE,
                        dieu_khoan_thanh_toan VARCHAR(255),
                        tong_tien_hang NUMERIC,
                        tien_chiet_khau NUMERIC,
                        tien_thue_gtgt NUMERIC,
                        tong_tien_thanh_toan NUMERIC,
                        trang_thai VARCHAR(50), -- Nháp, Chuyển kế toán, Đang giao hàng, Hoàn thành
                        FOREIGN KEY (ma_khach_hang) REFERENCES customers(ma_khach_hang)
);


CREATE TABLE order_details (
                               ma_chi_tiet_don_hang SERIAL PRIMARY KEY,
                               ma_don_hang VARCHAR(50),
                               ma_san_pham VARCHAR(50),
                               ten_hang VARCHAR(255),
                               so_lo VARCHAR(50),
                               han_dung DATE,
                               don_vi_tinh VARCHAR(20),
                               so_luong INT,
                               don_gia_bao_gom_vat NUMERIC,
                               tien_hang NUMERIC,
                               ty_le_chiet_khau NUMERIC, -- (%)
                               tien_chiet_khau NUMERIC,
                               ty_le_thue_gtgt NUMERIC, -- (%)
                               tien_thue_gtgt NUMERIC,
                               tong_tien_thanh_toan NUMERIC,
                               ma_nhan_vien_phu_trach VARCHAR(50),
                               ma_khach_hang VARCHAR(50),
                               FOREIGN KEY (ma_don_hang) REFERENCES orders(ma_don_hang),
                               FOREIGN KEY (ma_san_pham) REFERENCES products(ma_san_pham),
                               FOREIGN KEY (ma_nhan_vien_phu_trach) REFERENCES employees(ma_nhan_vien),
                               FOREIGN KEY (ma_khach_hang) REFERENCES customers(ma_khach_hang)
);


CREATE TABLE order_policies (
                                ma_chinh_sach UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                ma_nhan_vien VARCHAR(50),
                                ten_nhan_vien VARCHAR(255),
                                ma_khach_hang VARCHAR(50),
                                ten_khach_hang VARCHAR(255),
                                ma_san_pham VARCHAR(50),
                                ten_san_pham VARCHAR(255),
                                chinh_sach_bac_si NUMERIC, -- (%)
                                ma_nguoi_nhan_phi_bac_si VARCHAR(50),
                                ten_nguoi_nhan_phi_bac_si VARCHAR(255),
                                chinh_sach_nha_thuoc_khoa_duoc NUMERIC, -- (%)
                                ma_nguoi_nhan_phi_nha_thuoc_khoa_duoc VARCHAR(50),
                                ten_nguoi_nhan_phi_nha_thuoc_khoa_duoc VARCHAR(255),
                                chinh_sach_thanh_toan NUMERIC, -- (%)
                                ma_nguoi_nhan_phi_thanh_toan VARCHAR(50),
                                ten_nguoi_nhan_phi_thanh_toan VARCHAR(255),
                                chinh_sach_quan_ly NUMERIC, -- (%)
                                ma_nguoi_nhan_phi_quan_ly VARCHAR(50),
                                ten_nguoi_nhan_phi_quan_ly VARCHAR(255),
                                gia_ban_le NUMERIC,
                                gia_thu_ve NUMERIC,
                                FOREIGN KEY (ma_nhan_vien) REFERENCES employees(ma_nhan_vien),
                                FOREIGN KEY (ma_khach_hang) REFERENCES customers(ma_khach_hang),
                                FOREIGN KEY (ma_san_pham) REFERENCES products(ma_san_pham)
);

CREATE TABLE order_status (
                              ma_trang_thai SERIAL PRIMARY KEY,
                              ma_don_hang VARCHAR(50),
                              trang_thai VARCHAR(50),
                              thoi_gian TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (ma_don_hang) REFERENCES orders(ma_don_hang)
);