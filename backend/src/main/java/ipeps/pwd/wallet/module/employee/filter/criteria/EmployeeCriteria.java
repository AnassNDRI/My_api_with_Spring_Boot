package ipeps.pwd.wallet.module.employee.filter.criteria;

import ipeps.pwd.wallet.module.account.entity.Account;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCriteria {
    private int employee_id;
    private String role;
    private Boolean actif;
    private Organization organization;
    private Account account;
}