package ipeps.pwd.wallet.module.transaction.repository;

import ipeps.pwd.wallet.module.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findByType(String type);
    Transaction findById(int id);
    boolean existsByType(String type);
}
