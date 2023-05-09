package ipeps.pwd.wallet.module.wallet.entity;

public class UpdateWalletPayload {
    private int wallet_id;
    private String name;
    private String description;
    private boolean actif;
    private String type;

    public UpdateWalletPayload(int wallet_id, String name, String description, boolean actif, String type) {
        this.wallet_id = wallet_id;
        this.name = name;
        this.description = description;
        this.actif = actif;
        this.type = type;
    }

    public UpdateWalletPayload(){

    }

    public int getWallet_id() {return wallet_id;}

    public void setWallet_id(int wallet_id) {this.wallet_id = wallet_id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public boolean isActif() {return actif;}

    public void setActif(boolean actif) {this.actif = actif;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}
}
