package com.yan.dto;

import java.io.Serializable;

public class TraineeDto implements Serializable {
    private String name;

    private String nickName;

    private int level;

    public TraineeDto(){}

    public TraineeDto(String name, String nickName, int level) {
        this.name = name;
        this.nickName = nickName;
        this.level = level;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
