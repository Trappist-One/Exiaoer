package com.xiaoer.sso.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: mcr
 * @Date: 2020/11/27 17:39
 */

@Data
public class FilterParam {
    private String appId;

    private String appSecret;

    private String serverUrl;
}
