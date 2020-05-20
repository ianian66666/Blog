package com.ian.blog.service;

import com.github.pagehelper.PageInfo;
import com.ian.blog.entity.Blog;
import com.ian.blog.entity.Tag;

import java.util.List;

/**
 * @author Ian
 * @date 2020/4/19 -  上午 11:11
 */
public interface TagService {

    //用id查詢
    Tag getTagByid(long id);

        List<Tag> getAllTagByid(String ids);

    //所有的標籤
    List<Tag> allTags();


    //新增標籤
    int saveTag(Tag tag);

    //分頁查詢
    PageInfo<Tag> pageTag(int pageNum,int pageSize);

    //改
    int updateTag(Tag tag);

    //刪除

    int deleteTag(Long id);

    //檢查是否有相通標籤
    int getByName(Tag tag);
}
