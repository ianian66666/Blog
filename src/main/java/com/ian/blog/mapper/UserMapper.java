package com.ian.blog.mapper;

import com.ian.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Ian
 * @date 2020/4/17 -  下午 09:38
 */
@Repository
@Mapper
public interface UserMapper {
  //查詢用戶名是否存在
  User findByUsernameAndPassword(User user);

  User getUser(String username);

}
