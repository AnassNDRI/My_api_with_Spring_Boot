package ipeps.pwd.wallet.module.contact.repository;

import ipeps.pwd.wallet.module.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findByFirstname(String firstname);
    Contact findById(int id);
    boolean existsByFirstname(String firstname);
}
