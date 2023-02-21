package com.myblog.service;

import com.myblog.pojo.Category;

import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/13 13:01
 * @Description: 分类
 */
public interface CategoryService {
    List<Category> getAllCategory();

    Category getCategoryById(Integer id);


    void updateCategory(Category category);

    void addCategory(Category category);
}
