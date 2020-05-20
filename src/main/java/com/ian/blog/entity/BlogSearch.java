package com.ian.blog.entity;

import org.springframework.stereotype.Component;

/**
 * @author Ian
 * @date 2020/4/19 -  下午 02:42
 */
    @Component
    public class BlogSearch {
    private String title;//标题
    private Long typeId;//分类
    private Boolean recommend;//是否推荐

    public BlogSearch() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }


}
