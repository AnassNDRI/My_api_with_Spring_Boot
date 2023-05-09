package ipeps.pwd.wallet.module.account.entity;

public class CreateAccountPayload {

    private String firstname ;
    private String lastname;

  // cette classe est utilisé les requetes de creation
    public  CreateAccountPayload(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;

    }
    public  CreateAccountPayload() {

    }
    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

}
