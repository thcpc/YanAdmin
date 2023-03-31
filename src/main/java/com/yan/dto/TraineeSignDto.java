package com.yan.dto;

import java.io.Serializable;
import java.util.Date;

public class TraineeSignDto implements Serializable {
    private long traineeId;

//    @JsonProperty("lastAttendance")
    private Date createDt;

    public TraineeSignDto(){}

    public TraineeSignDto(long traineeId) {
        this(traineeId,null);
    }

    public TraineeSignDto(long traineeId, Date createDt) {
        this.traineeId = traineeId;
        this.createDt = createDt;
    }

    public long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(long traineeId) {
        this.traineeId = traineeId;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}
