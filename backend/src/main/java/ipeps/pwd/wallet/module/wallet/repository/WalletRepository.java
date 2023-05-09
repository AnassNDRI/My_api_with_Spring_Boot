package ipeps.pwd.wallet.module.wallet.repository;

import ipeps.pwd.wallet.module.wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    Wallet findByName(String name);
    Wallet findById(int id);
    boolean existsByName(String name);
}
