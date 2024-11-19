package tayduong.com.saleordermngt.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('departments_ma_phong_ban_seq')")
    @Column(name = "ma_phong_ban", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "ten_phong_ban")
    private String tenPhongBan;

}