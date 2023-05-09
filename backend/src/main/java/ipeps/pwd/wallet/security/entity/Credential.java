package ipeps.pwd.wallet.security.entity;

import ipeps.pwd.wallet.module.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long credential_id;

    private String username;
    private String password;
    private Boolean actif;

    public Credential(String username, String password, Boolean actif) {
        this.username = username;
        this.password = password;
        this.actif = actif;
    }

    public static class Builder {

        private String username;
        private String password;
        private Boolean actif;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setActif(boolean actif) {
            this.actif = actif;
            return this;
        }

        public Credential build() {
            return new Credential(username, password, actif);
        }
    }
}