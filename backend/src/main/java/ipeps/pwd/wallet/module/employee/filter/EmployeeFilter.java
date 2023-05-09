package ipeps.pwd.wallet.module.employee.filter;

import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.employee.filter.criteria.EmployeeCriteria;
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
public class EmployeeFilter {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    // le constructeur de employee filter
    public EmployeeFilter(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    /* si le critère n'est pas renseigné, la methode ne le donne pas à notre criteria Builder et qui ensuite
             ne l'ajoute pas à notre liste de Predicate. */
    public List<Employee> findAllWithFilters(EmployeeCriteria criteria) {
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Predicate predicate = getPredicate(criteria, employeeRoot);
        criteriaQuery.where(predicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private Predicate getPredicate(EmployeeCriteria criteria, Root<Employee> employeeRoot) {
        List<Predicate> predicates = new ArrayList<>();

        // Verfier si le Id de l'employee a ete donné comme critère ----------------------------------------------------------------------------------
        if (criteria.getEmployee_id() > 0 /* || Objects.nonNull(criteria.getEmployee_id()) */ ) {
            predicates.add(criteriaBuilder.equal(employeeRoot.get("employee_id"), criteria.getEmployee_id()));
        }
        // Verfier si le critère "role" a été renseigné ----------------------------------------------------------------------------------
        if (Objects.nonNull(criteria.getRole())) {
            predicates.add(criteriaBuilder.like(employeeRoot.get("role"), "%" + criteria.getRole() + "%"));
        }

        // Verfier si le Id de l'account a ete donné comme critère -------------------------------------------------------------------------------
        if (Objects.nonNull(criteria.getAccount())) {
            predicates.add(criteriaBuilder.equal(employeeRoot.get("account"), criteria.getAccount()));
        }

        // Verfier si le Id de l'organisation a ete donné comme critère --------------------------------------------------------------------------
        if (Objects.nonNull(criteria.getOrganization())) {
            predicates.add(criteriaBuilder.equal(employeeRoot.get("organization"), criteria.getOrganization()));
        }

        // Verfier si le critère "actif" a été renseigné --------------------------------------------------------------------------
        if (Objects.nonNull(criteria.getActif())) {
            predicates.add(criteriaBuilder.equal(employeeRoot.get("actif"), criteria.getActif()));
        }
        // il transforme notre liste de predicate en Array puis la persite dans le criteria Builder.
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
