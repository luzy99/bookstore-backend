package cn.com.bookstore.bookstore.book.service;

import cn.com.bookstore.bookstore.book.entity.Book;
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

    Book getbook(String isbn);

    List<Book> getBookListByName(String  kw);

    List<Book> getBookListByAuthor(String  kw);

    List<Book> getBookListByPublisher(String kw);

    List<Book> getBookListByISBN(String kw);

    List<Book> getBookListNew();

    List<Book> getBookListHost();
}
