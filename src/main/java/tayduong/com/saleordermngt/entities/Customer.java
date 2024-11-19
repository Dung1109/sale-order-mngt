package tayduong.com.saleordermngt.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('customers_ma_khach_hang_seq')")
    @Column(name = "ma_khach_hang", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "ten_khach_hang")
    private String tenKhachHang;

    @Size(max = 255)
    @Column(name = "dia_chi")
    private String diaChi;

    @Size(max = 100)
    @Column(name = "tinh_thanh_pho", length = 100)
    private String tinhThanhPho;

    @Size(max = 50)
    @Column(name = "ma_so_thue", length = 50)
    private String maSoThue;

    @Size(max = 20)
    @Column(name = "dien_thoai", length = 20)
    private String dienThoai;

    @Size(max = 255)
    @Column(name = "nguoi_lien_he")
    private String nguoiLienHe;

    @Column(name = "ngung_theo_doi")
    private Boolean ngungTheoDoi;

}