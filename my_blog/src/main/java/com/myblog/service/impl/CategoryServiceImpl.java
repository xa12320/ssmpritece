package com.myblog.service.impl;

import com.myblog.mapper.CategoryMapper;
import com.myblog.pojo.Category;
import com.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/13 13:01
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryMapper.getCategoryById(id);
    }

    @Override
    public void updateCategory( Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }


}
