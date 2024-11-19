package tayduong.com.saleordermngt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tayduong.com.saleordermngt.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}