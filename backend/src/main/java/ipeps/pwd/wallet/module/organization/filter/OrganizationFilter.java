package ipeps.pwd.wallet.module.organization.filter;

import ipeps.pwd.wallet.module.organization.entity.Organization;
import ipeps.pwd.wallet.module.organization.filter.criteria.OrganizationCriteria;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrganizationFilter {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public OrganizationFilter(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public List<Organization> findAllWithFilters(OrganizationCriteria criteria) {
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);
        Predicate predicate = getPredicate(criteria, organizationRoot);
        criteriaQuery.where(predicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private Predicate getPredicate(OrganizationCriteria criteria, Root<Organization> organizationRoot) {
        List<Predicate> predicates = new ArrayList<>();

        // Check for role if is given ----------------------------------------------------------------------------------
        if (Objects.nonNull(criteria.getName())) {
            predicates.add(criteriaBuilder.like(organizationRoot.get("name"), "%" + criteria.getName() + "%"));
        }

        // Check for account if is given -------------------------------------------------------------------------------
        if (Objects.nonNull(criteria.getDescription())) {
            predicates.add(criteriaBuilder.equal(organizationRoot.get("description"), criteria.getDescription()));
        }

        // Check for organization if is given --------------------------------------------------------------------------
        if (criteria.getOrganization_id() > 0) {
            predicates.add(criteriaBuilder.equal(organizationRoot.get("organization_id"), criteria.getOrganization_id()));
        }

        // Check for actif if is given --------------------------------------------------------------------------
        if (Objects.nonNull(criteria.getActif())) {
            predicates.add(criteriaBuilder.equal(organizationRoot.get("actif"), criteria.getActif()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
