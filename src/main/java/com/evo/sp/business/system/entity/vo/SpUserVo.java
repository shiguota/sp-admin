package com.evo.sp.business.system.entity.vo;

import java.io.Serializable;

public class SpUserVo implements Serializable{
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
