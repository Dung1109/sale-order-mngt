-- 1. Department Inserts
INSERT INTO departments (ma_phong_ban, ten_phong_ban) VALUES
                                                          (nextval('departments_ma_phong_ban_seq'), 'Phòng Kinh Doanh'),
                                                          (nextval('departments_ma_phong_ban_seq'), 'Phòng Kế Toán'),
                                                          (nextval('departments_ma_phong_ban_seq'), 'Phòng Nhân Sự');

-- 2. Employee Inserts
INSERT INTO employees (ma_nhan_vien, tai_khoan, ten_nhan_vien, ma_phong_ban, loai_hinh) VALUES
                                                                                            (nextval('employees_ma_nhan_vien_seq'), 'nv001', 'Nguyễn Văn A', 1, 'Chính thức'),
                                                                                            (nextval('employees_ma_nhan_vien_seq'), 'nv002', 'Trần Thị B', 1, 'Chính thức'),
                                                                                            (nextval('employees_ma_nhan_vien_seq'), 'nv003', 'Lê Văn C', 2, 'Chính thức');

-- Update employee manager relationships after employees exist
UPDATE employees SET ma_quan_ly = 1 WHERE ma_nhan_vien = 2;
UPDATE employees SET ma_quan_ly = 1 WHERE ma_nhan_vien = 3;

-- 3. Product Inserts
INSERT INTO products (ma_san_pham, ten_san_pham, tinh_chat, don_vi_tinh_chinh, ngung_theo_doi) VALUES
                                                                                                   (nextval('products_ma_san_pham_seq'), 'Thuốc A', 'Kê đơn', 'Hộp', false),
                                                                                                   (nextval('products_ma_san_pham_seq'), 'Thuốc B', 'Không kê đơn', 'Vỉ', false),
                                                                                                   (nextval('products_ma_san_pham_seq'), 'Thuốc C', 'Kê đơn', 'Lọ', false);

-- 4. Customer Inserts
INSERT INTO customers (ma_khach_hang, ten_khach_hang, dia_chi, tinh_thanh_pho, ma_so_thue, dien_thoai, nguoi_lien_he, ngung_theo_doi) VALUES
                                                                                                                                          (nextval('customers_ma_khach_hang_seq'), 'Nhà thuốc An Khang', '123 Lê Lợi', 'Hồ Chí Minh', '0123456789', '0901234567', 'Nguyễn Thị D', false),
                                                                                                                                          (nextval('customers_ma_khach_hang_seq'), 'Phòng khám Sức Khỏe', '456 Nguyễn Huệ', 'Hà Nội', '9876543210', '0909876543', 'Trần Văn E', false),
                                                                                                                                          (nextval('customers_ma_khach_hang_seq'), 'Bệnh viện Đa khoa', '789 Trần Phú', 'Đà Nẵng', '5432109876', '0905555555', 'Phạm Thị F', false);

-- 5. Orders Inserts
INSERT INTO orders (ma_don_hang, ma_khach_hang, thoi_gian_dat_hang, ngay_giao_hang, ngay_thanh_toan, dieu_khoan_thanh_toan, tong_tien_hang, tien_chiet_khau, tien_thue_gtgt, tong_tien_thanh_toan, trang_thai) VALUES
                                                                                                                                                                                                                   (gen_random_uuid(), 1, CURRENT_TIMESTAMP, CURRENT_DATE + INTERVAL '7 days', CURRENT_DATE + INTERVAL '30 days', 'Thanh toán trong 30 ngày', 10000000, 500000, 1000000, 10500000, 'NHAP'),
                                                                                                                                                                                                                   (gen_random_uuid(), 2, CURRENT_TIMESTAMP, CURRENT_DATE + INTERVAL '5 days', CURRENT_DATE + INTERVAL '15 days', 'Thanh toán trong 15 ngày', 15000000, 750000, 1500000, 15750000, 'CHUYEN_KE_TOAN'),
                                                                                                                                                                                                                   (gen_random_uuid(), 3, CURRENT_TIMESTAMP, CURRENT_DATE + INTERVAL '3 days', CURRENT_DATE + INTERVAL '7 days', 'Thanh toán trong 7 ngày', 20000000, 1000000, 2000000, 21000000, 'DANG_GIAO_HANG');

-- 6. Order Details Inserts
INSERT INTO order_details (ma_chi_tiet_don_hang, ma_don_hang, ma_san_pham, ten_hang, so_lo, han_dung, don_vi_tinh, so_luong, don_gia_bao_gom_vat) VALUES
                                                                                                                                                      (gen_random_uuid(), (SELECT ma_don_hang FROM orders WHERE trang_thai = 'NHAP' LIMIT 1), 1, 'Thuốc A', 'LOT001', CURRENT_DATE + INTERVAL '365 days', 'Hộp', 100, 100000),
                                                                                                                                                      (gen_random_uuid(), (SELECT ma_don_hang FROM orders WHERE trang_thai = 'CHUYEN_KE_TOAN' LIMIT 1), 2, 'Thuốc B', 'LOT002', CURRENT_DATE + INTERVAL '180 days', 'Vỉ', 200, 50000),
                                                                                                                                                      (gen_random_uuid(), (SELECT ma_don_hang FROM orders WHERE trang_thai = 'DANG_GIAO_HANG' LIMIT 1), 3, 'Thuốc C', 'LOT003', CURRENT_DATE + INTERVAL '730 days', 'Lọ', 50, 300000);

-- 7. Order Policy Inserts
INSERT INTO order_policies (ma_chinh_sach, ma_nhan_vien, ten_nhan_vien, ma_khach_hang, ten_khach_hang, ma_san_pham, ten_san_pham, chinh_sach_bac_si, ma_nguoi_nhan_phi_bac_si) VALUES
                                                                                                                                                                                   (gen_random_uuid(), 1, 'Nguyễn Văn A', 1, 'Nhà thuốc An Khang', 1, 'Thuốc A', 5.0, 1),
                                                                                                                                                                                   (gen_random_uuid(), 2, 'Trần Thị B', 2, 'Phòng khám Sức Khỏe', 2, 'Thuốc B', 3.0, 2),
                                                                                                                                                                                   (gen_random_uuid(), 3, 'Lê Văn C', 3, 'Bệnh viện Đa khoa', 3, 'Thuốc C', 4.0, 3);