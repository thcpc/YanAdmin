package com.yan.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yan.dto.TraineeSignDto;

import java.io.Serializable;
import java.util.Date;


public class TraineeSignDetailEntity implements Serializable {
    private long id;
    private int isReviewed;
    private String reason;
    @JsonFormat(timezone = "GMT+8")
    private Date createDt;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(int isReviewed) {
        this.isReviewed = isReviewed;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}
