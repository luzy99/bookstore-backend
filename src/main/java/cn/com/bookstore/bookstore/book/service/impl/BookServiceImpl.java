package cn.com.bookstore.bookstore.book.service.impl;

import cn.com.bookstore.bookstore.book.entity.Book;
import cn.com.bookstore.bookstore.book.mapper.BookMapper;
import cn.com.bookstore.bookstore.book.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
