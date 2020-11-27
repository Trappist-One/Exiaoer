package com.xiaoer.sso.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 回传Token对象
 * @Author: mcr
 * @Date: 2020/11/27 14:34
 */
@Data
@AllArgsConstructor
public class RpcAccessToken implements Serializable {
    private static final long serialVersionUID = 4507869346123296527L;

    /**
     * 调用凭证
     */
    private String accessToken;
    /**
     * AccessToken超时时间，单位（秒）
     */
    private int expiresIn;
    /**
     * 当前AccessToken超时，用于刷新AccessToken并延长服务端session时效必要参数
     */
    private String refreshToken;
    /**
     * 用户信息
     */
    private SsoUser user;


}
