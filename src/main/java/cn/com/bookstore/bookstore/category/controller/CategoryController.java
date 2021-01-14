package cn.com.bookstore.bookstore.category.controller;


import cn.com.bookstore.bookstore.category.entity.Category;
import cn.com.bookstore.bookstore.category.service.ICategoryService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuzhiwen
 * @since 2020-12-30
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @RequestMapping(value = "/getCategories")
    public JSONObject getCategories() {
        JSONObject jsonObj = new JSONObject();
        try {
            Category c1= new Category(),c2= new Category(),c3= new Category(),c4= new Category(),c5= new Category(),c6= new Category(),c7= new Category(),c8 = new Category();
            c1.setCategoryID(1);c1.setCName("文学");
            c2.setCategoryID(2);c2.setCName("哲学");
            c3.setCategoryID(3);c3.setCName("经济");
            c4.setCategoryID(4);c4.setCName("历史");
            c5.setCategoryID(5);c5.setCName("军事");
            c6.setCategoryID(6);c6.setCName("工业技术");
            c7.setCategoryID(7);c7.setCName("政治法律");
            c8.setCategoryID(8);c8.setCName("教育");
            List<Category> categories = new ArrayList<Category>();
            categories.add(c1);
            categories.add(c2);
            categories.add(c3);
            categories.add(c4);
            categories.add(c5);
            categories.add(c6);
            categories.add(c7);
            categories.add(c8);
            jsonObj.put("categories[]", categories);
            jsonObj.put("errcode", "0");
            jsonObj.put("errmsg", "查询成功");
        } catch (Exception ex) {
            jsonObj.put("errcode", "30001");
            jsonObj.put("errmsg", "查询失败");
        }
        return jsonObj;
    }

}
