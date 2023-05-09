package ipeps.pwd.wallet.module.contact.entity;

public class UpdateContactPayload {
    private int contact_id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public UpdateContactPayload (int contact_id, String firstname, String lastname, String email, String phone) {
       this.contact_id = contact_id;
        this.firstname = firstname;
        this.lastname  = lastname;
        this.email     = email;
        this.phone   = phone;
    }

    public UpdateContactPayload(){

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
}
