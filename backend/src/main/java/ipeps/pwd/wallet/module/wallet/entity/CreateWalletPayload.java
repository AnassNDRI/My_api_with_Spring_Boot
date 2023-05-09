package ipeps.pwd.wallet.module.wallet.entity;

public class CreateWalletPayload {
    private String name;
    private String description;
    private boolean actif;
    private String type;

    public CreateWalletPayload(String name, String description, boolean actif, String type) {
        this.name = name;
        this.description = description;
        this.actif = actif;
        this.type = type;
    }

    public CreateWalletPayload() {
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public boolean isActif() {return actif;}

    public void setActif(boolean actif) {this.actif = actif;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}
}
