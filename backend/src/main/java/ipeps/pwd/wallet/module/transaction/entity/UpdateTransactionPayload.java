package ipeps.pwd.wallet.module.transaction.entity;

public class UpdateTransactionPayload {
    private int  transaction_id;
    private String type;
    private float amount;

    public UpdateTransactionPayload(int transaction_id, String type, float amount) {
        this.transaction_id = transaction_id;
        this.type = type;
        this.amount = amount;
    }

    public UpdateTransactionPayload(){

    }

    public int getTransaction_id() {return transaction_id;}

    public void setTransaction_id(int transaction_id) {this.transaction_id = transaction_id;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public float getAmount() {return amount;}

    public void setAmount(float amount) {this.amount = amount;}
}
