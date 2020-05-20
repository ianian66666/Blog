package com.ian.blog.mapper;

import com.ian.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ian
 * @date 2020/4/24 -  下午 08:36
 */
@Mapper
@Repository
public interface CommentMapper {

    //獲取留言區列表
    List<Comment> listCommentByBlogId(Long blogId);

    //獲取留言區列表
    List<Comment> listCommentByBlogIdWithPidNull(Long blogId);

    //保存留言數據
    int saveComment(Comment comment);

    //獲取主樓的樓層
    Comment findByParentCommentId(Long id);

    List<Comment> listCommentByBlogIdWithPidNotNull(long id);
}
