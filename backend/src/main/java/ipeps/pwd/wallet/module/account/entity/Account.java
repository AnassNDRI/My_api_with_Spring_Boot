package ipeps.pwd.wallet.module.account.entity;

import com.sun.istack.NotNull;
import ipeps.pwd.wallet.security.entity.Credential;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int account_id;
    @OneToOne
    @JoinColumn(name = "credential_id_fk")
    private Credential credential;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;


    public Account(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

    }
    // cette classe sera utilisée dans la classe AccountController pour creer un nouveau compte.
    public static class Builder {
        private int account_id;
        private String firstname;
        private String lastname;

        public Builder setAccount_id(int account_id) {
            this.account_id = account_id;
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

        public Account build() {
            return new Account(firstname, lastname);
        }

    }

}
