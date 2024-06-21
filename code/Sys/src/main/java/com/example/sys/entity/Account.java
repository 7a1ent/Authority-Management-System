package com.example.sys.entity;

import lombok.Data;

@Data
public class Account {
    private String act;

    private String name;

    private String password;

    private Integer privilege;
}
