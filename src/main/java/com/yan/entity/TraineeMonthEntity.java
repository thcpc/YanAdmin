package com.yan.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class TraineeMonthEntity implements Serializable {
    @JsonProperty("traineeId")
    private long id;

    private String year;

    private List<Integer> monthCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Integer> getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(List<Integer> monthCount) {
        this.monthCount = monthCount;
    }

    public TraineeMonthEntity(long id) {
        this.id = id;
    }
}
