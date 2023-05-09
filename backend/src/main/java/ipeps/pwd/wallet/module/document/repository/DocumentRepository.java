package ipeps.pwd.wallet.module.document.repository;

import ipeps.pwd.wallet.module.document.entity.Document;
import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import ipeps.pwd.wallet.module.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    Document findByName(String name);
    Document findById(int id);
    boolean existsByName(String name);

    List<Document> findDocumentByOrganization(Organization organization);

    List<Document> findDocumentByEmployee(Employee employee);

    List<Document> findDocumentByTransactions(Transaction transaction);

    @Query("SELECT d from Document d where d.organization is not null")
    List<Document> findAllOrganizationDocument();

    @Query("SELECT d from Document d where d.employee is not null")
    List<Document> findAllEmployeeDocument();


    @Query("SELECT d from Document d where d.transactions is not null")
    List<Document> findAllTransactionDocument();
}
