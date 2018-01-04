package edu.hubu.wxmall.dao;

import edu.hubu.wxmall.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CategoryDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void testGetCategories(){
        List<Category> list = categoryDao.getCategories();
        for (Category c:list
             ) {
            System.out.println(c);
        }
    }

    @Test
    public void getCategoriesByParentId() throws Exception {
        int id = 1005000;
        List<Category> categories = categoryDao.getCategoriesByParentId(id);
        for (Category c:categories) {
            logger.info("Category{}",c);
        }
    }

}
