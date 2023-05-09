package ipeps.pwd.wallet.module.employee.repository;

import ipeps.pwd.wallet.module.account.entity.Account;
import ipeps.pwd.wallet.module.document.entity.Document;
import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import ipeps.pwd.wallet.module.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByRole(String role);
    Employee findById(int employee_id);

    boolean existsByRole(String role);

    List<Employee> findEmployeeByOrganization(Organization organization);

    List<Employee> findEmployeeByAccount(Account account);

    @Query("SELECT d from Employee d where d.organization is not null")
    List<Employee> findAllOrganizationEmployee();

    @Query("SELECT d from Employee d where d.account is not null")
    List<Employee> findAllAccountEmployee();

}
