package ipeps.pwd.wallet.module.organization.entity;

public class CreateOrganizationPayload {
    private String name;
    private String description;
    private boolean actif;

    public CreateOrganizationPayload() {

    }

    public CreateOrganizationPayload(String name,String description, boolean actif){
        this.name = name;
        this.description = description;
        this.actif = actif;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public boolean isActif() {return actif;}

    public void setActif(boolean actif) {this.actif = actif;}
}
