package com.evo.sp.basis.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author sgt
 * @since 2019-03-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;

    /**
     * 生日
     */
    private LocalDateTime birthday;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色集合
     */
    private List<SpRole> spRoles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SpRole> getSpRoles() {
        return spRoles;
    }

    public void setSpRoles(List<SpRole> spRoles) {
        this.spRoles = spRoles;
    }
}
