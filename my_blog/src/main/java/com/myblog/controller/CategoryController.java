package com.myblog.controller;

import com.myblog.pojo.Category;
import com.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;
import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/13 13:04
 * @Description:
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category")
    public String showCategory(Model model){
        List<Category> lists = categoryService.getAllCategory();
        model.addAttribute("lists", lists);
        return "category";
    }

    @RequestMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id,Model model){
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "Edit";
    }

    @PutMapping("/edit")
    public String editCategoryName(Category category){
        categoryService.updateCategory(category);
        //System.out.println(category);
        return "redirect:/category";
    }

    @RequestMapping("/toaddCategory")
    public String showAddCategory(){
        return "addCategory";
    }
    @RequestMapping(value = "/addCategory",method = RequestMethod.POST)
    public String addCategory(Category category,Model model){
        categoryService.addCategory(category);
        System.out.println(category);
        return "redirect:/category";
    }
}
