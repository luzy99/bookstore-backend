package cn.com.bookstore.bookstore.book.controller;


import cn.com.bookstore.bookstore.book.entity.Book;
import cn.com.bookstore.bookstore.book.service.IBookService;
import cn.com.bookstore.bookstore.user.entity.User;
import cn.com.bookstore.bookstore.user.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    private IBookService bookService;

    @RequestMapping(value = "/getBookDetail")
    public JSONObject getBookDetail(String ISBN) {
        JSONObject jsonObj = new JSONObject();
        try {
            Book book = bookService.getBookInfo(ISBN);
            jsonObj.put("ISBN",book.getIsbn());
            jsonObj.put("BookName",book.getBookName());
            jsonObj.put("Author",book.getAuthor());
            jsonObj.put("Price",book.getPrice());
            jsonObj.put("RemainNum",book.getRemainNum());
            jsonObj.put("SoldNum",book.getSoldNum());
            jsonObj.put("AddTime",book.getAddTime());
            jsonObj.put("ReleaseTime",book.getReleaseTime());
            jsonObj.put("Available",book.getAvailable());
            jsonObj.put("Picture",book.getPicture());
            jsonObj.put("Introduction",book.getIntroduction());
            jsonObj.put("Publisher",book.getPublisher());
            jsonObj.put("Category",book.getCategory());
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
