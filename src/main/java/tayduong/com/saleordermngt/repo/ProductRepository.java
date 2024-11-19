package tayduong.com.saleordermngt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tayduong.com.saleordermngt.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}