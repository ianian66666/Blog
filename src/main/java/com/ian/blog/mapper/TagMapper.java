package com.ian.blog.mapper;

import com.ian.blog.entity.Blog;
import com.ian.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ian
 * @date 2020/4/19 -  上午 10:56
 */
@Repository
@Mapper
public interface TagMapper {

    //用id查詢
    Tag getTagByid(long id);

    List<Tag> getAllTagByid(List<Long> longs);

    //新增標籤
    int saveTag(Tag tag);

    //allBlogTags
    List<Blog> allBlogTags();

    //分頁查詢
    List<Tag> pageTag();

    //改
    int updateTag(Tag tag);

    //刪除

    int deleteTag(Long id);

    //檢查是否有相通標籤
    int getByName(Tag tag);



}
