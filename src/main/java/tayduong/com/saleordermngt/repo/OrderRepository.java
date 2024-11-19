package tayduong.com.saleordermngt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tayduong.com.saleordermngt.entities.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}