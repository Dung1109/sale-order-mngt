package tayduong.com.saleordermngt.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "ma_chi_tiet_don_hang", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_don_hang")
    private Order maDonHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_san_pham")
    private Product maSanPham;

    @Size(max = 255)
    @Column(name = "ten_hang")
    private String tenHang;

    @Size(max = 50)
    @Column(name = "so_lo", length = 50)
    private String soLo;

    @Column(name = "han_dung")
    private LocalDate hanDung;

    @Size(max = 20)
    @Column(name = "don_vi_tinh", length = 20)
    private String donViTinh;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "don_gia_bao_gom_vat")
    private BigDecimal donGiaBaoGomVat;

    @Column(name = "tien_hang")
    private BigDecimal tienHang;

    @Column(name = "ty_le_chiet_khau")
    private BigDecimal tyLeChietKhau;

    @Column(name = "tien_chiet_khau")
    private BigDecimal tienChietKhau;

    @Column(name = "ty_le_thue_gtgt")
    private BigDecimal tyLeThueGtgt;

    @Column(name = "tien_thue_gtgt")
    private BigDecimal tienThueGtgt;

    @Column(name = "tong_tien_thanh_toan")
    private BigDecimal tongTienThanhToan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_nhan_vien_phu_trach")
    private Employee maNhanVienPhuTrach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_khach_hang")
    private Customer maKhachHang;

}