package com.ian.blog.service;

import com.ian.blog.entity.Comment;

import java.util.List;

/**
 * @author Ian
 * @date 2020/4/24 -  下午 08:36
 */
public interface CommentService {

    //獲取留言區列表
    List<Comment> listCommentByBlogId(Long blogId);

    //保存留言數據
    int saveComment(Comment comment);

}
