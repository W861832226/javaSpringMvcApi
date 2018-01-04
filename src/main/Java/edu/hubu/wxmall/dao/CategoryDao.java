package edu.hubu.wxmall.dao;

import edu.hubu.wxmall.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryDao {
    //获取展示的商品分类
    public List<Category> getCategories();

    public List<Category> getCategoriesByParentId(Integer parentId);
}
