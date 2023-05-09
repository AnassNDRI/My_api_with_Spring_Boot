package ipeps.pwd.wallet.module.document.filter;
import ipeps.pwd.wallet.module.document.entity.Document;
import ipeps.pwd.wallet.module.document.filter.criteria.DocumentCriteria;
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
public class DocumentFilter {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    // le constructeur de employee filter
    public DocumentFilter(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    /* si le critère n'est pas renseigné, la methode ne le donne pas à notre criteria Builder et qui ensuite
             ne l'ajoute pas à notre liste de Predicate. */
    public List<Document> findAllWithFilters(DocumentCriteria criteria) {
        CriteriaQuery<Document> criteriaQuery = criteriaBuilder.createQuery(Document.class);
        Root<Document> documentRoot = criteriaQuery.from(Document.class);
        Predicate predicate = getPredicate(criteria, documentRoot);
        criteriaQuery.where(predicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private Predicate getPredicate(DocumentCriteria criteria, Root<Document> documentRoot) {
        List<Predicate> predicates = new ArrayList<>();

        // Verfier si le Id de document a ete donné comme critère ----------------------------------------------------------------------------------
        if (criteria.getDocument_id() > 0 /* || Objects.nonNull(criteria.getEmployee_id()) */ ) {
            predicates.add(criteriaBuilder.equal(documentRoot.get("document_id"), criteria.getDocument_id()));
        }

        // Verfier si le Id de l'organisation a ete donné comme critère --------------------------------------------------------------------------
        if (Objects.nonNull(criteria.getOrganization())) {
            predicates.add(criteriaBuilder.equal(documentRoot.get("organization"), criteria.getOrganization()));
        }
        // Verfier si le Id de l'employee a ete donné comme critère --------------------------------------------------------------------------
        if (Objects.nonNull(criteria.getEmployee())) {
            predicates.add(criteriaBuilder.equal(documentRoot.get("employee"), criteria.getEmployee()));
        }

        // Verfier si le critère "name" a été renseigné ----------------------------------------------------------------------------------
        if (Objects.nonNull(criteria.getName())) {
            predicates.add(criteriaBuilder.like(documentRoot.get("name"), "%" + criteria.getName() + "%"));
        }

        // il transforme notre liste de predicate en Array puis la persite dans le criteria Builder.
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
