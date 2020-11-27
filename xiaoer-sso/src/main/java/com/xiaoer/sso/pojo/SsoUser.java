package com.xiaoer.sso.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 登录用户信息
 * @Author: mcr
 * @Date: 2020/11/27 14:31
 */
@Data
public class SsoUser implements Serializable {
    private static final long serialVersionUID = 1764365572138947234L;
    // 登录成功userId
    private Integer id;
    // 登录名
    private String username;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SsoUser other = (SsoUser)obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
