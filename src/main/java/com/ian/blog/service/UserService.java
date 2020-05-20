package com.ian.blog.service;

import com.ian.blog.entity.User;

/**
 * @author Ian
 * @date 2020/4/17 -  下午 09:26
 */
public interface UserService {

    User checkUser(String username,String password);

    User getUser(String username);
}
