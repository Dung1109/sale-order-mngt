package tayduong.com.saleordermngt.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import tayduong.com.saleordermngt.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "ma_don_hang", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_khach_hang")
    private Customer maKhachHang;

    @Column(name = "thoi_gian_dat_hang")
    private Instant thoiGianDatHang;

    @Column(name = "ngay_giao_hang")
    private LocalDate ngayGiaoHang;

    @Column(name = "ngay_thanh_toan")
    private LocalDate ngayThanhToan;

    @Size(max = 255)
    @Column(name = "dieu_khoan_thanh_toan")
    private String dieuKhoanThanhToan;

    @Column(name = "tong_tien_hang")
    private BigDecimal tongTienHang;

    @Column(name = "tien_chiet_khau")
    private BigDecimal tienChietKhau;

    @Column(name = "tien_thue_gtgt")
    private BigDecimal tienThueGtgt;

    @Column(name = "tong_tien_thanh_toan")
    private BigDecimal tongTienThanhToan;

    @Column(name = "trang_thai")
    @Enumerated(EnumType.STRING)
    private OrderStatus trangThai;


}