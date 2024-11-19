package tayduong.com.saleordermngt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tayduong.com.saleordermngt.entities.OrderDetail;

import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
}