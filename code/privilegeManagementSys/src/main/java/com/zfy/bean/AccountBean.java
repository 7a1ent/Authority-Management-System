package com.zfy.bean;

import lombok.Data;

@Data
public class AccountBean {
    private int id;
    private String user;
    private String name;
    private String password;
    private int privilege;

}
