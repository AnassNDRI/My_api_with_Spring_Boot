package ipeps.pwd.wallet.module.transaction.entity;

public class CreateTransactionPayload {
    private String type;
    private float amount;

    public CreateTransactionPayload(String type, float amount) {
        this.type = type;
        this.amount = amount;
    }

    public CreateTransactionPayload(){

    }

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public float getAmount() {return amount;}

    public void setAmount(float amount) {this.amount = amount;}
}
