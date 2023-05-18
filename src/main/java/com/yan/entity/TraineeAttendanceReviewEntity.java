package com.yan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class TraineeAttendanceReviewEntity implements Serializable {
    private long id;
    @JsonProperty("yanAttendanceId")
    private long yan_attendance_id;

    @JsonProperty("traineeName")
    private String name;

    @JsonProperty("traineeNickName")
    private String nick_name;

    @JsonProperty("isReviewed")
    private int is_reviewed;
    @JsonFormat(timezone = "GMT+8")
    private Date createDt;

    private String reason;

    public TraineeAttendanceReviewEntity(long id, long yan_attendance_id, int is_reviewed, String reason, Date createDt) {
        this.id = id;
        this.yan_attendance_id = yan_attendance_id;
        this.is_reviewed = is_reviewed;
        this.createDt = createDt;
        this.reason = reason;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getYan_attendance_id() {
        return yan_attendance_id;
    }

    public void setYan_attendance_id(long yan_attendance_id) {
        this.yan_attendance_id = yan_attendance_id;
    }

    public int getIs_reviewed() {
        return is_reviewed;
    }

    public void setIs_reviewed(int is_reviewed) {
        this.is_reviewed = is_reviewed;
    }

    public String getReason() {
        return reason;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
