package ipeps.pwd.wallet.module.transaction.entity;


import ipeps.pwd.wallet.module.document.entity.Document;
import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import ipeps.pwd.wallet.module.wallet.entity.Wallet;
import ipeps.pwd.wallet.security.entity.Credential;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transaction_id;


    @ManyToOne
    @JoinColumn(name = "document_id_fk")
    private Document documents;

    @ManyToOne
    @JoinColumn(name = "employee_id_fk")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "wallet_id_fk")
    private Wallet wallet;

    @NotNull
    private String type;
    @NotNull
    private float amount;

    public Transaction(String type, float amount) {
        this.type = type;
        this.amount = amount;
    }

    public static class Builder{
        private int transaction_id;
        private String type;
        private float amount;

        public Builder setTransaction_id(int transaction_id) {
            this.transaction_id = transaction_id;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setAmount(float amount) {
            this.amount = amount;
            return this;
        }

        public Transaction build(){return new Transaction(type, amount);}
    }

    public int getTransaction_id() {return transaction_id;}

    public void setTransaction_id(int transaction_id) {this.transaction_id = transaction_id;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public float getAmount() {return amount;}

    public void setAmount(float amount) {this.amount = amount;}


    public Wallet getWallet() {return wallet;}

    public void setWallet(Wallet wallet) {this.wallet = wallet;}

    public Document getDocuments() {return documents;}

    public void setDocuments(Document documents) {this.documents = documents;}

    public Employee getEmployee() {return employee;}

    public void setEmployee(Employee employee) {this.employee = employee;}

}
