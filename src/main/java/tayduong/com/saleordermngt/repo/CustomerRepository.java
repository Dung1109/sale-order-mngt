package tayduong.com.saleordermngt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tayduong.com.saleordermngt.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}