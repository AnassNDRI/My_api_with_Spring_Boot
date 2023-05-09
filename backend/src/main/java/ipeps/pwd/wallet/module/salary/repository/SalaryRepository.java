package ipeps.pwd.wallet.module.salary.repository;

import ipeps.pwd.wallet.module.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    Salary findByType(String type);
    Salary findById(int salary_id);

    boolean existsByType(String type);
}
