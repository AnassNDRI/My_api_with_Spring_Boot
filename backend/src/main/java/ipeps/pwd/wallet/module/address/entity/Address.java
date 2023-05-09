package ipeps.pwd.wallet.module.address.entity;

import com.sun.istack.NotNull;
import ipeps.pwd.wallet.module.account.entity.Account;
import ipeps.pwd.wallet.module.contact.entity.Contact;
import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Address_id;
    @ManyToOne
    @JoinColumn(unique = true, name = "organization_id_fk")
    private Organization organization;
    @ManyToOne
    @JoinColumn(name = "employee_id_fk")
    private Employee employee;
    @NotNull
    private AddressTypeEnum type;
    @NotNull
    private String road;
    @NotNull
    private int number;
    @NotNull
    private String box;
    @NotNull
    private String cp;
    @NotNull
    private String town;
    private String country;

    public Address(AddressTypeEnum type, String road, int number, String box, String cp, String town, String country) {
        this.type = type;
        this.road = road;
        this.number = number;
        this.box = box;
        this.cp = cp;
        this.town = town;
        this.country = country;
    }

    public static class Builder {
        private int address_id;
        private AddressTypeEnum type;
        private String road;
        private int number;
        private String box;
        private String cp;
        private String town;
        private String country;

        public Builder setAddress_id(int address_id) {
            this.address_id = address_id;
            return this;
        }

        public Builder setType(AddressTypeEnum type) {
            this.type = type;
            return this;
        }

        public Builder setRoad(String road) {
            this.road = road;
            return this;
        }

        public Builder setNumber(int number) {
            this.number = number;
            return this;
        }

        public Builder setBox(String box) {
            this.box = box;
            return this;
        }

        public Builder setCp(String cp) {
            this.cp = cp;
            return this;
        }

        public Builder setTown(String town) {
            this.town = town;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        // cette methode sera utiliser pour le PostMapping dans la classe AddressController
        public Address build() {
            return new Address(type, road, number, box, cp, town, country);
        }


    }

    public int getAddress_id() {
        return Address_id;
    }

    public void setAddress_id(int address_id) {
        Address_id = address_id;
    }

    public AddressTypeEnum getType() {
        return type;
    }

    public void setType(AddressTypeEnum type) {
        this.type = type;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
