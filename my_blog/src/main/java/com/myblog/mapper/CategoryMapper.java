package com.myblog.mapper;

import com.myblog.pojo.Category;

import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/13 13:02
 * @Description:
 */
public interface CategoryMapper {
    /**
     * 获取所有分类
     * @return
     */
    List<Category> getAllCategory();

    /**
     * 通过id获取需要修改的分类
     * @param id 修改分类的编号
     * @return 返回分类
     */
    Category getCategoryById(Integer id);

    /**
     * 修改
     * @param category 修改的分类
     */
    void updateCategory(Category category);

    /**
     * 添加分类
     * @param category
     */
    void addCategory(Category category);
}
