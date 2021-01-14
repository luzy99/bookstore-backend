package cn.com.bookstore.bookstore.book.service;

import cn.com.bookstore.bookstore.book.entity.Book;
import cn.com.bookstore.bookstore.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuzhiwen
 * @since 2020-12-30
 */
public interface IBookService extends IService<Book> {
    List<Book> getBookList(String ISBN);
    public Book getBookInfo(String ISBN);

    boolean addbook(Book book);
}
