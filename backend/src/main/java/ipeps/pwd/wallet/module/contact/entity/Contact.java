package ipeps.pwd.wallet.module.contact.entity;
import ipeps.pwd.wallet.module.address.entity.Address;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contact_id;
    @ManyToOne
    @JoinColumn(name = "address_id_fk")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "organization_id_fk")
    private Organization organizations;

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String email;
    @NotNull
    private String phone;

    public Contact(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname  = lastname;
        this.email     = email;
        this.phone   = phone;
    }

    public static class Builder{
        private int contact_id;
        private String firstname;
        private String lastname;
        private String email;
        private String phone;

        public Builder setContact_id(int contact_id) {
            this.contact_id = contact_id;
            return this;
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Contact build(){return  new Contact(firstname,lastname,email,phone);}
    }

    public int getContact_id() {return contact_id;}

    public void setContact_id(int contact_id) {this.contact_id = contact_id;}

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public Address getAddress() {return address;}

    public void setAddress(Address address) {this.address = address;}

    public Organization getOrganizations() {return organizations;}

    public void setOrganizations(Organization organizations) {this.organizations = organizations;}
}
