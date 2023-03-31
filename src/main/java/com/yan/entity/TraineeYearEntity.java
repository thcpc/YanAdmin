package com.yan.entity;

import java.io.Serializable;

public class TraineeYearEntity  implements Serializable {
    private String year;


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public TraineeYearEntity(String year) {
        this.year = year;
    }
}
