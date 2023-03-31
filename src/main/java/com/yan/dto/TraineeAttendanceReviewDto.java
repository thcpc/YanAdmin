package com.yan.dto;

import java.io.Serializable;

public class TraineeAttendanceReviewDto implements Serializable {
    private long traineesAttendanceReviewId;
    private int active;
    private String reason;

    public TraineeAttendanceReviewDto() {
    }

    public TraineeAttendanceReviewDto(long traineesAttendanceReviewId, int active, String reason) {
        this.traineesAttendanceReviewId = traineesAttendanceReviewId;
        this.active = active;
        this.reason = reason;
    }

    public long getTraineesAttendanceReviewId() {
        return traineesAttendanceReviewId;
    }

    public void setTraineesAttendanceReviewId(long traineesAttendanceReviewId) {
        this.traineesAttendanceReviewId = traineesAttendanceReviewId;
    }

    public int isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
