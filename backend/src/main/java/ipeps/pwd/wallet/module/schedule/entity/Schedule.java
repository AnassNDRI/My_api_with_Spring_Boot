package ipeps.pwd.wallet.module.schedule.entity;

import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int schedule_id;

    @ManyToOne
    @JoinColumn(name = "employee_id_fk")
    private Employee employee;
    @NotNull
    private String type;
    @NotNull
    private DateFormat date_schedule;
    private String comment;

    public Schedule(String type, DateFormat date_schedule, String comment) {
        this.type          = type;
        this.date_schedule = date_schedule;
        this.comment       = comment;
    }


    public static  class Builder{
        private int schedule_id;
        private String type;
        private DateFormat date_schedule;
        private String comment;

        public Builder setSchedule_id(int schedule_id) {
            this.schedule_id = schedule_id;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setDate_schedule(DateFormat date_schedule) {
            this.date_schedule = date_schedule;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Schedule build() {return new Schedule(type,date_schedule,comment);}
    }

    public int getSchedule_id() {return schedule_id;}

    public void setSchedule_id(int schedule_id) {this.schedule_id = schedule_id;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public DateFormat getDate_schedule() {return date_schedule;}

    public void setDate_schedule(DateFormat date_schedule) {this.date_schedule = date_schedule;}

    public String getComment() {return comment;}

    public void setComment(String comment) {this.comment = comment;}

    public Employee getEmployee() {return employee;}

    public void setEmployee(Employee employee) {this.employee = employee;}


}
