package tayduong.com.saleordermngt.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('employees_ma_nhan_vien_seq')")
    @Column(name = "ma_nhan_vien", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "tai_khoan", length = 100)
    private String taiKhoan;

    @Size(max = 255)
    @Column(name = "ten_nhan_vien")
    private String tenNhanVien;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_quan_ly")
    private Employee maQuanLy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_phong_ban")
    private Department maPhongBan;

    @Size(max = 50)
    @Column(name = "loai_hinh", length = 50)
    private String loaiHinh;

}