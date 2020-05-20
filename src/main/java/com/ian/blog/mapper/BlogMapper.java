package com.ian.blog.mapper;

import com.ian.blog.entity.Blog;
import com.ian.blog.entity.BlogSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ian
 * @date 2020/4/19 -  下午 01:21
 */
@Mapper
@Repository
public interface BlogMapper {


    //根據id查blog
    Blog getBlogById(long id);

    //根據搜索條件搜尋
    List<Blog> simpleQueryBySearch(BlogSearch blogSearch);

    //分頁查詢
    List<Blog> pageBlog();

    //最新堆建
    List<Blog> listRecommendBlog(Integer size);

    //新增
    int saveBlog(Blog blog);

    //修改
    int updateBlog(Blog blog);

    //修改瀏覽次數
    int updateViews(Blog blog);

    int deleteBlog(long id);

    //Search
    List<Blog> queryBlog(String query);

    //根據id查部落格詳情
    Blog getAllById(Long id);

    //根據typeid來搜尋
   List<Blog> blogByTypeId(long id);


    List<Blog> allBlog();

       List<String> dateFormate();
       List<Blog>  getblogByYear(String year);
    int countBlog();
}
