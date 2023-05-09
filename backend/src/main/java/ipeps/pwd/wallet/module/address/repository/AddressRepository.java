package ipeps.pwd.wallet.module.address.repository;

import ipeps.pwd.wallet.module.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByType(String type);
    Address findById(int id);
    boolean existsByType(String type);
}
