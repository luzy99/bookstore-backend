package cn.com.bookstore.bookstore.book.controller;


import cn.com.bookstore.bookstore.book.entity.Book;
import cn.com.bookstore.bookstore.book.service.IBookService;
import cn.com.bookstore.bookstore.order.entity.Order;
import cn.com.bookstore.bookstore.user.entity.User;
import cn.com.bookstore.bookstore.user.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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

    @RequestMapping(value = "/getBookDetail")
    public JSONObject getBookDetail(String ISBN) {
        JSONObject jsonObj = new JSONObject();
        try {
            Book book = bookService.getBookInfo(ISBN);
            JSONObject bookObj = new JSONObject();
            bookObj.put("ISBN",book.getIsbn());
            bookObj.put("BookName",book.getBookName());
            bookObj.put("Author",book.getAuthor());
            bookObj.put("Price",book.getPrice());
            bookObj.put("RemainNum",book.getRemainNum());
            bookObj.put("SoldNum",book.getSoldNum());
            bookObj.put("AddTime",book.getAddTime());
            bookObj.put("ReleaseTime",book.getReleaseTime().toString());
            bookObj.put("Available",book.getAvailable());
            bookObj.put("Picture",book.getPicture());
            bookObj.put("Introduction",book.getIntroduction());
            bookObj.put("Publisher",book.getPublisher());
            bookObj.put("Category",book.getCategory());
            jsonObj.put("book", bookObj);
            jsonObj.put("errcode", "0");
            jsonObj.put("errmsg", "查询成功");

        } catch (Exception ex) {
            jsonObj.put("errcode", "30001");
            jsonObj.put("errmsg", "查询失败");
        }
        return jsonObj;
    }

    @RequestMapping(value = "/addBook")
    public JSONObject addBook(int adminId, String ISBN,String bookName, String author, float price, int remainNum, String releaseTime,String picture,String publisher,int available,String category) {
        JSONObject jsonObj = new JSONObject();
        try {
            Book book = new Book();
            if(adminId == 0)
            {
                jsonObj.put("errcode", "10001");
                jsonObj.put("errmsg", "当前账户非管理员");
                return jsonObj;
            }
            if (ISBN == null || ISBN.equals("")) {
                jsonObj.put("errcode", "42002");
                jsonObj.put("errmsg", "缺少ISBN");
                return jsonObj;
            }
            book.setAddTime(LocalDateTime.now());
            book.setBookName(bookName);
            book.setAuthor(author);
            book.setAvailable(available);
            book.setCategory(category);
            book.setIntroduction("");
            book.setIsbn(ISBN);
            book.setPicture(picture);
            book.setPrice(price);
            book.setPublisher(publisher);
            book.setReleaseTime(LocalDateTime.now());
            book.setRemainNum(remainNum);
            book.setSoldNum(0);
            if (bookService.addbook(book)) {
                jsonObj.put("errcode", "0");
                jsonObj.put("result", "上传成功");
                return jsonObj;
            } else {
                jsonObj.put("errcode", "42002");
                jsonObj.put("errmsg", "上传失败");
                return jsonObj;
            }
        } catch (Exception ex) {
            jsonObj.put("errcode", "42001");
            jsonObj.put("errmsg", "上传失败");
            ex.printStackTrace();
        }
        return jsonObj;
    }

}
