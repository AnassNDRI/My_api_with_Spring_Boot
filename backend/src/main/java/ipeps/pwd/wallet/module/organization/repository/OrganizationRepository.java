package ipeps.pwd.wallet.module.organization.repository;

import ipeps.pwd.wallet.module.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    Organization findByName(String name);
    Organization findById(int id);

    boolean existsByName(String name);
}
