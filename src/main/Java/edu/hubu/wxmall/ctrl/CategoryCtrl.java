package edu.hubu.wxmall.ctrl;

import edu.hubu.wxmall.entity.Category;
import edu.hubu.wxmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/catalog")
public class CategoryCtrl {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCategoryIndex(){
        List<Category> categories =  categoryService.getCategories();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errno",0);
        map.put("errmsg","");
        map.put("data",categories);
        return map;
    }
}
