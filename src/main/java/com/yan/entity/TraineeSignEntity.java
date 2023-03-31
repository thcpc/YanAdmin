package com.yan.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yan.dto.TraineeSignDto;

import java.io.Serializable;
import java.util.Date;


public class TraineeSignEntity implements Serializable {
    private long id;
    private long traineeId;
    private boolean isDelete;
    @JsonProperty("latestAttendanceDate")
    private Date createDt;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(long traineeId) {
        this.traineeId = traineeId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public TraineeSignEntity() {}

    public TraineeSignEntity(long id, long traineeId, boolean isDelete, Date createDt) {
        this.id = id;
        this.traineeId = traineeId;
        this.isDelete = isDelete;
        this.createDt = createDt;
    }

    public static TraineeSignEntity create(TraineeSignDto traineeSignDto){
        TraineeSignEntity traineeSignEntity = new TraineeSignEntity();
        traineeSignEntity.setTraineeId(traineeSignDto.getTraineeId());
        return traineeSignEntity;
    }
}
