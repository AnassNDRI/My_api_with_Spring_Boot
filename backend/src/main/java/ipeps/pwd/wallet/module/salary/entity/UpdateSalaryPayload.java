package ipeps.pwd.wallet.module.salary.entity;

import java.text.DateFormat;

public class UpdateSalaryPayload {
        private int salary_id;
        private int employee_id;
        private  String type;
        private DateFormat date;
        private float amount;
        private String periodicity;

        public  UpdateSalaryPayload(){

        }

        public  UpdateSalaryPayload(int salary_id, int employee_id, String type, DateFormat date, float amount,String periodicity){
            this.salary_id =  salary_id;
            this.employee_id = employee_id;
            this.type = type;
            this.date = date;
            this.amount = amount;
            this.periodicity = periodicity;
        }

        public int getSalary_id() {return salary_id;}

        public void setSalary_id(int salary_id) {this.salary_id = salary_id;}

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
