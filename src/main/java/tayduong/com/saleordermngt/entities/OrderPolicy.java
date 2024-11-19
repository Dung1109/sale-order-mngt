package tayduong.com.saleordermngt.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "order_policies")
public class OrderPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "ma_chinh_sach", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_nhan_vien")
    private Employee maNhanVien;

    @Size(max = 255)
    @Column(name = "ten_nhan_vien")
    private String tenNhanVien;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_khach_hang")
    private Customer maKhachHang;

    @Size(max = 255)
    @Column(name = "ten_khach_hang")
    private String tenKhachHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_san_pham")
    private Product maSanPham;

    @Size(max = 255)
    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Column(name = "chinh_sach_bac_si")
    private BigDecimal chinhSachBacSi;

    @Column(name = "ma_nguoi_nhan_phi_bac_si")
    private Long maNguoiNhanPhiBacSi;

    @Size(max = 255)
    @Column(name = "ten_nguoi_nhan_phi_bac_si")
    private String tenNguoiNhanPhiBacSi;

    @Column(name = "chinh_sach_nha_thuoc_khoa_duoc")
    private BigDecimal chinhSachNhaThuocKhoaDuoc;

    @Column(name = "ma_nguoi_nhan_phi_nha_thuoc_khoa_duoc")
    private Long maNguoiNhanPhiNhaThuocKhoaDuoc;

    @Size(max = 255)
    @Column(name = "ten_nguoi_nhan_phi_nha_thuoc_khoa_duoc")
    private String tenNguoiNhanPhiNhaThuocKhoaDuoc;

    @Column(name = "chinh_sach_thanh_toan")
    private BigDecimal chinhSachThanhToan;

    @Column(name = "ma_nguoi_nhan_phi_thanh_toan")
    private Long maNguoiNhanPhiThanhToan;

    @Size(max = 255)
    @Column(name = "ten_nguoi_nhan_phi_thanh_toan")
    private String tenNguoiNhanPhiThanhToan;

    @Column(name = "chinh_sach_quan_ly")
    private BigDecimal chinhSachQuanLy;

    @Column(name = "ma_nguoi_nhan_phi_quan_ly")
    private Long maNguoiNhanPhiQuanLy;

    @Size(max = 255)
    @Column(name = "ten_nguoi_nhan_phi_quan_ly")
    private String tenNguoiNhanPhiQuanLy;

    @Column(name = "gia_ban_le")
    private BigDecimal giaBanLe;

    @Column(name = "gia_thu_ve")
    private BigDecimal giaThuVe;

}