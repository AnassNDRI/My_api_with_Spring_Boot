package ipeps.pwd.wallet.module.salary.entity;

import com.sun.istack.NotNull;
import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int salary_id;
    @ManyToOne
    @JoinColumn(name = "employee_id_fk")
    private Employee employee;
    @NotNull
    private  String type;
    @NotNull
    private DateFormat date;
    @NotNull
    private float amount;
    @NotNull
    private String periodicity;

    public Salary( String type, DateFormat date, float amount, String periodicity) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.periodicity = periodicity;
    }
    public static class Builder{
        private int salary_id;
        private  String type;
        private DateFormat date;
        private float amount;
        private String periodicity;


        public Builder setSalary_id(int salary_id) {this.salary_id = salary_id;
            return this;
        }

        public Builder setType(String type) {this.type = type;
            return this;
        }

        public Builder setDate(DateFormat date) {this.date = date;
            return this;
        }

        public Builder setAmount(float amount) {this.amount = amount;
            return this;
        }

        public Builder setPeriodicity(String periodicity) {this.periodicity = periodicity;
            return this;
        }

        public Salary build(){ return new Salary(type,date,amount,periodicity);}
    }

    public int getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(int salary_id) {this.salary_id = salary_id;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public DateFormat getDate() {return date;}

    public void setDate(DateFormat date) {this.date = date;}

    public float getAmount() {return amount;}

    public void setAmount(float amount) {this.amount = amount;}

    public String getPeriodicity() {return periodicity;}

    public void setPeriodicity(String periodicity) {this.periodicity = periodicity;}

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
