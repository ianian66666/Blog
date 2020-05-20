package com.ian.blog.mapper;

import com.ian.blog.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ian
 * @date 2020/4/18 -  下午 01:03
 */
@Mapper
@Repository
public interface TypeMapper {

    //新增標籤
    int saveType(Type type);

    //查詢標籤
    Type getType(Long id);

    //分頁查詢
    List<Type> pageType();

    List<Type> listTypeTop(Integer size);

    int upDateType(Type type);

    void deleteType(Long id);

    //檢查是否有相同標千
    int getByName(Type type);

    //更新size
     void blogALLtag();
}
