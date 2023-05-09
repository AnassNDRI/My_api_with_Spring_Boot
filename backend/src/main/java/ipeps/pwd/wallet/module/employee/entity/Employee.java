package ipeps.pwd.wallet.module.employee.entity;

import com.sun.istack.NotNull;
import ipeps.pwd.wallet.module.account.entity.Account;
import ipeps.pwd.wallet.module.address.entity.Address;
import ipeps.pwd.wallet.module.document.entity.Document;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import ipeps.pwd.wallet.module.salary.entity.Salary;
import ipeps.pwd.wallet.module.schedule.entity.Schedule;
import ipeps.pwd.wallet.module.transaction.entity.Transaction;
import ipeps.pwd.wallet.module.wallet.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_id;
    @ManyToOne
    @JoinColumn(name = "account_id_fk")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "organization_id_fk")
    private Organization organization;
    @OneToMany
    @JoinColumn(name = "employee_id_fk")
    private List<Salary> salaries;
    @OneToMany
    @JoinColumn(name = "employee_id_fk")
    private List<Schedule> schedules;
    @OneToMany
    @JoinColumn(name = "employee_id_fk")
    private List<Wallet> wallets;
    @OneToMany
    @JoinColumn(name = "employee_id_fk")
    private List<Document> documents;
    @OneToMany
    @JoinColumn(name = "employee_id_fk")
    private List<Address> address;
    @OneToMany
    @JoinColumn(name = "employee_id_fk")
    private List<Transaction> transactions;
    @NotNull
    private String role;
    @NotNull
    private boolean actif;


    public Employee(String role, boolean actif) {
        this.role = role;
        this.actif = actif;
    }

    public static class Builder {
        private int employee_id;
        private String role;
        private boolean actif;

        public Builder setEmployee_id(int employee_id) {
            this.employee_id = employee_id;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setActif(boolean actif) {
            this.actif = actif;
            return this;
        }

        public Employee build() {
            return new Employee(role, actif);
        }
    }
}
