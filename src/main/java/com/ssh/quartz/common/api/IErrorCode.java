package com.ssh.quartz.common.api;

/**
 * @description 封装API的错误码
 * @author: ssh
 * @Date: 2020/10/26 11:08
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
