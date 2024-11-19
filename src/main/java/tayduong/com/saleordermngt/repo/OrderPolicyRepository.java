package tayduong.com.saleordermngt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tayduong.com.saleordermngt.entities.OrderPolicy;

import java.util.UUID;

public interface OrderPolicyRepository extends JpaRepository<OrderPolicy, UUID> {
}