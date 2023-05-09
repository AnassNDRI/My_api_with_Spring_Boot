package ipeps.pwd.wallet.module.account.entity;


// cette classe est utilisée pour la requete update
public class UpdateAccountPayload {
        private int account_id;
        private String firstname ;
        private String lastname;

        public  UpdateAccountPayload(int account_id, String firstname, String lastname,int credential_id){
            this.account_id = account_id;
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public  UpdateAccountPayload() {

        }

    public int getAccount_id() {return account_id;}

    public void setAccount_id(int account_id) {this.account_id = account_id;}

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

}
