package ipeps.pwd.wallet.module.salary.entity;

import java.text.DateFormat;

public class CreateSalaryPayload {
    private int employee_id;
    private  String type;
    private DateFormat date;
    private float amount;
    private String periodicity;

    public  CreateSalaryPayload(){

    }

    public  CreateSalaryPayload(int employee_id, String type, DateFormat date, float amount,String periodicity){
        this.employee_id = employee_id;
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.periodicity = periodicity;
    }

    public int getEmployee_id() {return employee_id;}

    public void setEmployee_id(int employee_id) {this.employee_id = employee_id;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public DateFormat getDate() {return date;}

    public void setDate(DateFormat date) {this.date = date;}

    public float getAmount() {return amount;}

    public void setAmount(float amount) {this.amount = amount;}

    public String getPeriodicity() {return periodicity;}

    public void setPeriodicity(String periodicity) {this.periodicity = periodicity;}
}
