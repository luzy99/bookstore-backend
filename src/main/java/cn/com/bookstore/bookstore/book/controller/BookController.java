package cn.com.bookstore.bookstore.book.controller;


import cn.com.bookstore.bookstore.book.entity.Book;
import cn.com.bookstore.bookstore.book.service.IBookService;
import cn.com.bookstore.bookstore.order.entity.Order;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService bookService;

    @RequestMapping("/getBookList")
    public JSONObject getBookList(Integer type,String kw) {
        JSONObject jsonObj = new JSONObject();
        try{
            if(type == null || type.equals("")){
                jsonObj.put("errcode", "52002");
                jsonObj.put("errmsg", "搜索类别为空");
                return jsonObj;
            }
            switch (type)
            {
                case 1:
                    List<Book> books1=bookService.getBookListByName(kw);
                    jsonObj.put("errcode", "0");
                    jsonObj.put("data", books1);
                    jsonObj.put("status","true");
                    break;
                case 2:
                    List<Book> books2=bookService.getBookListByAuthor(kw);
                    jsonObj.put("errcode", "0");
                    jsonObj.put("data", books2);
                    jsonObj.put("status","true");
                    break;
                case 3:
                    List<Book> books3=bookService.getBookListByPublisher(kw);
                    jsonObj.put("errcode", "0");
                    jsonObj.put("data", books3);
                    jsonObj.put("status","true");
                    break;
                case 4:
                    List<Book> books4=bookService.getBookListByISBN(kw);
                    jsonObj.put("errcode", "0");
                    jsonObj.put("data", books4);
                    jsonObj.put("status","true");
                    break;
                case 10:
                    List<Book> books5=bookService.getBookListNew();
                    jsonObj.put("errcode", "0");
                    jsonObj.put("data", books5);
                    jsonObj.put("status","true");
                    break;
                case 11:
                    List<Book> books6=bookService.getBookListHost();
                    jsonObj.put("errcode", "0");
                    jsonObj.put("data", books6);
                    jsonObj.put("status","true");
                    break;
                default	:
                    jsonObj.put("errcode", "52010");
                    jsonObj.put("errmsg", "搜索类别不存在");
                    break;
            }

        }catch(Exception ex){
            jsonObj.put("errcode", "52001");
            jsonObj.put("errmsg", "获取书籍列表失败");
        }
        return jsonObj;
    }
}
