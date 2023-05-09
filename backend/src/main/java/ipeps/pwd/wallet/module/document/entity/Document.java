package ipeps.pwd.wallet.module.document.entity;


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
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int document_id;

    @ManyToOne
    @JoinColumn(name = "organization_id_fk")
    private Organization organization;
    @ManyToOne
    @JoinColumn(name = "employee_id_fk")
    private Employee employee;

    @OneToMany
    @JoinColumn(name = "document_id_fk")
    private List<Transaction> transactions;


    @NotNull
    private String name;
    @NotNull
    private String description;
    private boolean free_access;
    @NotNull
    private String path;
    @NotNull
    private String type;

    public Document(String name, String description, boolean free_access, String path, String type) {
        this.name         = name;
        this.description  = description;
        this.free_access  = free_access;
        this.path         = path;
        this.type         = type;
    }



    public static class Builder{
        private int document_id;
        private String name;
        private String description;
        private boolean free_access;
        private String path;
        private String type;

         
         public Builder setDocument_id(int document_id) {this.document_id = document_id;return this;}

         public Builder setName(String name) {this.name = name;return this;}

         public Builder setDescription(String description) {this.description = description;return this;}

         public Builder setFree_access(boolean free_access) {this.free_access = free_access;return this;}

         public Builder setPath(String path) {this.path = path;return this;}

         public Builder setType(String type) {this.type = type;return this;}

        public  Document build(){return new Document(name, description, free_access,path,type);}

    }

    public int getDocument_id() {return document_id;}

    public void setDocument_id(int document_id) {this.document_id = document_id;}

    public Organization getOrganization() {return organization;}

    public void setOrganization(Organization organization) {this.organization = organization;}

    public Employee getEmployee() {return employee;}

    public void setEmployee(Employee employee) {this.employee = employee;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public boolean isFree_access() {return free_access;}

    public void setFree_access(boolean free_access) {this.free_access = free_access;}

    public String getPath() {return path;}

    public void setPath(String path) {this.path = path;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public List<Transaction> getTransactions() {return transactions;}

    public void setTransactions(List<Transaction> transactions) {this.transactions = transactions;}

}
