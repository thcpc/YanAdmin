package com.yan.constant;

public enum RoleEnum {
    ADMIN("admin"),
    TRAINEE("trainee");
    private String name;
    RoleEnum(String name){ this.name = name ;}

    public String getName(){return name; }
}
