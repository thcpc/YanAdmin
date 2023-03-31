package com.yan.entity;

import com.yan.dto.UserDto;

import java.util.Date;


public class UserEntity {
    private int id;
    private String name;
    private String nickName;
    private String role;
    private Date createDt;

    private boolean isDelete;


    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public UserEntity(int id, String name, String nickName, String role, Date createDt, boolean isDelete) {
        this(name,nickName,role);
        this.id = id;
        this.createDt = createDt;
        this.isDelete = isDelete;
    }

    public UserEntity(String name, String nickName, String role) {
        this.name = name;
        this.nickName = nickName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public static UserEntity create(UserDto userDto){
        return new UserEntity(userDto.getName(),userDto.getNickName(),userDto.getRole());
    }
}
