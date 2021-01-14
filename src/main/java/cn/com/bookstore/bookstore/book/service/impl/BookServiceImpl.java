package cn.com.bookstore.bookstore.book.service.impl;

import cn.com.bookstore.bookstore.book.entity.Book;
import cn.com.bookstore.bookstore.book.mapper.BookMapper;
import cn.com.bookstore.bookstore.book.service.IBookService;
import cn.com.bookstore.bookstore.order.entity.Order;
import cn.com.bookstore.bookstore.user.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuzhiwen
 * @since 2020-12-30
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Override
    public Book getbook(String isbn) {
        QueryWrapper wrapper = new QueryWrapper();
        // wrapper.eq("MemberID", memberId);
        wrapper.eq("ISBN", isbn);
        Book book = getOne(wrapper);
        return book;
    }

    @Override
    public List<Book> getBookListByName(String kw) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("BookName", kw);
        List<Book> books = list(wrapper);

        return books;

    }

    @Override
    public List<Book> getBookListByAuthor(String  kw) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("Author", kw);
        List<Book> books = list(wrapper);

        return books;
    }

    @Override
    public List<Book> getBookListByPublisher(String  kw) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("Publisher", kw);
        List<Book> books = list(wrapper);

        return books;
    }

    @Override
    public List<Book> getBookListByISBN(String  kw) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("ISBN", kw);
        List<Book> books = list(wrapper);

        return books;
    }

    @Override
    public List<Book> getBookListNew() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("AddTime");
        List<Book> books =list(wrapper);

        return books;
    }

    @Override
    public List<Book> getBookListHost() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("SoldNum");
        List<Book> books = list(wrapper);

        return books;
    }
    public List<Book> getBookList(String ISBN) {

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("ISBN", ISBN);
        List<Book> books = list(wrapper);
        return books;
    }

    public Book getBookInfo(String ISBN) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("ISBN", ISBN);
        Book bookInfo = getOne(wrapper);
        return bookInfo;
    }
    public boolean addbook(Book book)
    {
        return save(book);
    }
}
