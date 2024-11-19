package tayduong.com.saleordermngt.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @ColumnDefault("nextval('products_ma_san_pham_seq')")
    @Column(name = "ma_san_pham", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Size(max = 50)
    @Column(name = "tinh_chat", length = 50)
    private String tinhChat;

    @Size(max = 20)
    @Column(name = "don_vi_tinh_chinh", length = 20)
    private String donViTinhChinh;

    @Column(name = "ngung_theo_doi")
    private Boolean ngungTheoDoi;

}