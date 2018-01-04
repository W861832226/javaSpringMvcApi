package edu.hubu.wxmall.service.impl;


import edu.hubu.wxmall.service.CategoryService;
import edu.hubu.wxmall.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                       "classpath:spring/spring-service.xml"})
public class CategoryServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testGetCategories() {
       List<Category> categories = categoryService.getCategories();
       for (Category c:categories) {
           logger.info("category={}",c.getChildren());
        }
    }

}
