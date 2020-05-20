package com.ian.blog.service;

import com.github.pagehelper.PageInfo;
import com.ian.blog.entity.Type;

import java.util.List;

/**
 * @author Ian
 * @date 2020/4/18 -  下午 01:00
 */
public interface TypeService {
    int saveType(Type type);

    //查詢標籤
    Type getType(Long id);
    //獲取所有的
    List<Type> allType();

    //分頁查詢
 PageInfo<Type> PageType(int pageNum,int pageSize);

    int upDateType(Type type);

    void deleteType(Long id);

    //驗證是否有相同的標千
    int getByName(Type type);

    //查詢前五的標籤
    List<Type> listTypeTop(Integer size);

    //更新size
    void blogALLtag();
}
