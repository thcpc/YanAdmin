package com.yan.dto;

import com.yan.constant.RoleEnum;

public class UserDto {
    private String name;
    private String nickName;
    private String role;

    public UserDto() {}

    public UserDto(String name, String nickName, String role) {
        this.name = name;
        this.nickName = nickName;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static UserDto createTraineeUser(TraineeDto traineeDto){
        return new UserDto(traineeDto.getName(),traineeDto.getNickName(), RoleEnum.TRAINEE.getName());
    }
}
