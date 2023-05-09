package ipeps.pwd.wallet.module.organization.entity;

import com.sun.istack.NotNull;
import ipeps.pwd.wallet.module.address.entity.Address;
import ipeps.pwd.wallet.module.contact.entity.Contact;
import ipeps.pwd.wallet.module.document.entity.Document;
import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.wallet.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int organization_id;
    @OneToMany
    @JoinColumn(name = "organization_id_fk")
    private List<Address> address;
    @OneToMany
    @JoinColumn(name = "organization_id_fk")
    private List<Wallet> wallets;
    @OneToMany
    @JoinColumn(name = "organization_id_fk")
    private List<Document> documents;
    @OneToMany
    @JoinColumn(name = "organization_id_fk")
    private List<Contact> contacts;

    @NotNull
    private String name;
    private String description;
    private boolean actif;



    public Organization(String name, String description, boolean actif) {
        this.name = name;
        this.description = description;
        this.actif = actif;
    }

    public  static class Builder {
        private int organization_id;
        private String name;
        private String description;
        private boolean actif;

        public Builder setOrganization_id(int organization_id) {this.organization_id = organization_id;
            return this;
        }
        public Builder setName(String name) {this.name = name;
            return this;
        }

        public Builder setDescription(String description) {this.description = description;
            return this;
        }

        public Builder setActif(boolean actif) {this.actif = actif;
            return this;
        }

        public Organization build(){return new Organization(name,description,actif);}
    }
}
