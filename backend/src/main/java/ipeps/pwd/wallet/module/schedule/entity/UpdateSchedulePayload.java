package ipeps.pwd.wallet.module.schedule.entity;

import java.text.DateFormat;

public class UpdateSchedulePayload {
    private int schedule_id;
    private String type;
    private DateFormat date_schedule;
    private String comment;

    public UpdateSchedulePayload(int schedule_id, String type, DateFormat date_schedule, String comment) {
        this.schedule_id = schedule_id;
        this.type = type;
        this.date_schedule = date_schedule;
        this.comment = comment;
    }

    public UpdateSchedulePayload(){

    }

    public int getSchedule_id() {return schedule_id;}

    public void setSchedule_id(int schedule_id) {this.schedule_id = schedule_id;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public DateFormat getDate_schedule() {return date_schedule;}

    public void setDate_schedule(DateFormat date_schedule) {this.date_schedule = date_schedule;}

    public String getComment() {return comment;}

    public void setComment(String comment) {this.comment = comment;}
}
