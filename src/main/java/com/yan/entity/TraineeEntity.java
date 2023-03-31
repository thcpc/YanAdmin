package com.yan.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yan.dto.TraineeDto;

import java.io.Serializable;
import java.util.Date;


public class TraineeEntity implements Serializable {
    @JsonProperty("traineeId")
    private long id;

    private long userId;
    private String name;

    private String nickName;

    private int level;
    private Date latestAttendanceDate;
    private Date createDt;

    public TraineeEntity() {
        super();
    }

    public TraineeEntity(long id, long userId, String name, String nickName, int level, Date latestAttendanceDate, Date createDt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.nickName = nickName;
        this.level = level;
        this.latestAttendanceDate = latestAttendanceDate;
        this.createDt = createDt;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getLatestAttendanceDate() {
        return latestAttendanceDate;
    }

    public void setLatestAttendanceDate(Date latestAttendanceDate) {
        this.latestAttendanceDate = latestAttendanceDate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public static TraineeEntity create(TraineeDto traineeDto, long userId){
        TraineeEntity traineeEntity = new TraineeEntity();
        traineeEntity.setName(traineeDto.getName());
        traineeEntity.setNickName(traineeDto.getNickName());
        traineeEntity.setLevel(traineeDto.getLevel());
        traineeEntity.setUserId(userId);
        return traineeEntity;
    }
}
