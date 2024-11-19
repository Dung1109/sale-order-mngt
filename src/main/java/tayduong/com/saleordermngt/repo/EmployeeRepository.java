package tayduong.com.saleordermngt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tayduong.com.saleordermngt.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}