package ipeps.pwd.wallet.module.schedule.entity;

import java.text.DateFormat;

public class CreateSchedulePayload {
    private String type;
    private DateFormat date_schedule;
    private String comment;

    public CreateSchedulePayload(String type, DateFormat date_schedule, String comment) {
        this.type = type;
        this.date_schedule = date_schedule;
        this.comment = comment;
    }
    public CreateSchedulePayload(){

    }

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public DateFormat getDate_schedule() {return date_schedule;}

    public void setDate_schedule(DateFormat date_schedule) {this.date_schedule = date_schedule;}

    public String getComment() {return comment;}

    public void setComment(String comment) {this.comment = comment;}
}
