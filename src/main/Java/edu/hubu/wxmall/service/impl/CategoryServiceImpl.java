package edu.hubu.wxmall.service.impl;

import edu.hubu.wxmall.dao.CategoryDao;
import edu.hubu.wxmall.service.CategoryService;
import edu.hubu.wxmall.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    /**
     * 查询所有商品分类 按顺序显示
     * @return
     */
    @Override
    public List<Category> getCategories(){
        /*从数据库或者缓存中查询处商品分类，所以在这里我在方法里面调用了getAll(),为了方便程序的扩展*/
        List<Category> categories = getAll();

        //利用Java 1.8中的stream处理，将根分类区分出来
        List<Category> roots = categories.stream().filter(Category -> (Category.getParentId() == 0)).collect(Collectors.toList());

        /*对根分类进行排序*/
        roots.sort((o1,o2) ->o1.getSortOrder() > o2.getSortOrder() ? 1 : -1);

        //把非根分类区分出来
        List<Category> subs = categories.stream().filter(Category ->(Category.getParentId() != 0)).collect(Collectors.toList());

        //递归构建结构化的分类信息
        roots.forEach(root -> buildSubs(root,subs));
        return roots;
    }

    /**
     * 递归构建
     * @param parent
     * @param subs
     */
    public void buildSubs(Category parent,List<Category> subs){
        List<Category> children = subs.stream().filter(sub -> (sub.getParentId() == parent.getId())).collect(Collectors.toList());
        //有分类的情况下
        //List<Category> children = categoryDao.getCategoriesByParentId(parent.getId());
        if (!CollectionUtils.isEmpty(children)){
            parent.setChildren(children);
            children.forEach(child -> buildSubs(child,subs));
        }
    }

    public List<Category> getAll(){
        List<Category> allCategories = categoryDao.getCategories();
        return allCategories;
    }

}
