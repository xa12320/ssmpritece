package com.myblog.pojo;

import java.util.Date;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/13 13:06
 * @Description:
 */
public class Category {
    private Integer id;//文章编号
    private String title;//文章标题
    private Date createAt;//文章创建时间

    public Category() {
    }

    public Category(Integer id, String title, Date createAt) {
        this.id = id;
        this.title = title;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createAt=" + createAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
