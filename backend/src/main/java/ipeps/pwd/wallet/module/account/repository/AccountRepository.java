package ipeps.pwd.wallet.module.account.repository;

import ipeps.pwd.wallet.module.account.entity.Account;
import ipeps.pwd.wallet.module.document.entity.Document;
import ipeps.pwd.wallet.security.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// cette classe sert d'intermediare entre mes controller et ma base de données.
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findById(int id);

    Account findByFirstname(String firstname);

    boolean existsByFirstname(String firstname);

    List<Account> findAccountByCredential(Credential credential);

    @Query("SELECT d from Account d where d.credential is not null")
    List<Account> findAllCredentialAccount();
}


