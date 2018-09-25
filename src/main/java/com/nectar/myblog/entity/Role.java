package com.nectar.myblog.entity;

import lombok.Data;

/**
 * Describe: 权限
 */
@Data
public class Role {

    private int id;

    private String name;

    public Role(){

    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
