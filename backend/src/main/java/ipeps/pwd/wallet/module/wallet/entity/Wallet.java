package ipeps.pwd.wallet.module.wallet.entity;


import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import ipeps.pwd.wallet.module.transaction.entity.Transaction;
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
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wallet_id;

    @ManyToOne
    @JoinColumn(name = "organization_id_fk")
    private Organization organization;

    @OneToMany
    @JoinColumn(name = "wallet_id_fk")
    private List<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name = "employee_id_fk")
    private Employee employee;
    @NotNull
    private String name;
    private String description;
    private boolean actif;
    @NotNull
    private String type;

    public Wallet(String name, String description, boolean actif, String type) {
        this.name = name;
        this.description = description;
        this.actif = actif;
        this.type = type;
    }

    public static class Builder{
        private int wallet_id;
        private String name;
        private String description;
        private boolean actif;
        private String type;

        public Builder setWallet_id(int wallet_id) {
            this.wallet_id = wallet_id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setActif(boolean actif) {
            this.actif = actif;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Wallet build(){return new Wallet(name, description, actif, type);}
    }

    public int getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(int wallet_id) {this.wallet_id = wallet_id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public boolean isActif() {return actif;}

    public void setActif(boolean actif) {this.actif = actif;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public Organization getOrganization() {return organization;}

    public void setOrganization(Organization organization) {this.organization = organization;}

    public List<Transaction> getTransactions() {return transactions;}

    public void setTransactions(List<Transaction> transactions) {this.transactions = transactions;}

    public Employee getEmployee() {return employee;}

    public void setEmployee(Employee employee) {this.employee = employee;}

}
