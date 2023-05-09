package ipeps.pwd.wallet.module.document.filter.criteria;


import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentCriteria {
    private int document_id;
    private Organization organization;
    private Employee employee;
    private String name;
}
