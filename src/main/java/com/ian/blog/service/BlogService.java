package com.ian.blog.service;

import com.github.pagehelper.PageInfo;
import com.ian.blog.entity.Blog;
import com.ian.blog.entity.BlogSearch;
import com.ian.blog.entity.BlogSimpleQuery;

import java.util.List;
import java.util.Map;

/**
 * @author Ian
 * @date 2020/4/19 -  下午 01:21
 */
public interface BlogService {

    //根據id查blog
    Blog getBlogById(long id);

    //根據搜索條件搜尋
    List<Blog> simpleQueryBySearch(BlogSearch blogSearch);

    //分頁查詢
    PageInfo<Blog> pageAll(int pageNum,int PageSize);

    //最新推薦
    List<Blog> listRecommendBlog(Integer size);

    //新增
    int saveBlog(Blog blog);

    //修改
    int updateBlog(Blog blog);

    int deleteBlog(long id);

    //search
    PageInfo<Blog> queryBlog(String query , int pageNum,int pageSize);

    //根據id查部落格詳情
    Blog getAllById(Long id);

    //處理markdown
    Blog getAndConvert(long id);

    PageInfo<Blog> blogByTypeId(long id,int pageNum,int pageSize);

    //先搜尋全部blog在找tagids
    PageInfo<Blog> blogByTagIds(Long id,int pageNum,int pageSize);

    //歷年紀錄
    Map<String,List<Blog>> archivesBlog();

    //總共條數
     int countBlog();


}