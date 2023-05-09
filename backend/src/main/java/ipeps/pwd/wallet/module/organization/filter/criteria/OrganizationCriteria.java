package ipeps.pwd.wallet.module.organization.filter.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationCriteria {
    private int organization_id;
    private String name;
    private String description;
    private Boolean actif;

}