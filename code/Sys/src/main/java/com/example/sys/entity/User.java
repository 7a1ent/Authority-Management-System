package com.example.sys.entity;

import lombok.Data;

@Data
public class User {
    private String id;

    private String name;

    private Integer age;

    private String gender;

    private Integer privilege;
}
