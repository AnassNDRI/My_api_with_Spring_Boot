package ipeps.pwd.wallet.module.employee.entity;

public class CreateEmployeePayload {
    private String role;
    private boolean actif;


    public CreateEmployeePayload(){

    }

    public CreateEmployeePayload(int organization_id, int account_id, String role, boolean actif ){
        this.role            = role;
        this.actif           = actif;
    }

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public boolean isActif() {return actif;}

    public void setActif(boolean actif) {this.actif = actif;}
}
