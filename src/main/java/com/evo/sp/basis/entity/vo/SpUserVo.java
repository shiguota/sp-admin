package com.evo.sp.basis.entity.vo;

import com.evo.sp.basis.entity.SpRole;
import com.evo.sp.basis.entity.SpUser;

import java.io.Serializable;
import java.util.List;

public class SpUserVo extends SpUser implements Serializable{
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
