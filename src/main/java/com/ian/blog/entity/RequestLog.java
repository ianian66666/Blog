package com.ian.blog.entity;

import java.util.Arrays;

/**
 * @author Ian
 * @date 2020/4/17 -  下午 02:07
 */
public class RequestLog {
    private String url;
    private String ip;
    private String classMethod;
    private Object[] args;

    public RequestLog(String url, String ip, String classMethod, Object[] args) {
        this.url = url;
        this.ip = ip;
        this.classMethod = classMethod;
        this.args = args;
    }

    @Override
    public String toString() {
        return "url='" + url + '\'' +
                ", ip='" + ip + '\'' +
                ", classMethod='" + classMethod + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}

