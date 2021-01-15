package cn.com.bookstore.bookstore.category.service.impl;

import cn.com.bookstore.bookstore.book.entity.Book;
import cn.com.bookstore.bookstore.category.entity.Category;
import cn.com.bookstore.bookstore.category.mapper.CategoryMapper;
import cn.com.bookstore.bookstore.category.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public Category getCategory(String category) {
        QueryWrapper wrapper = new QueryWrapper();
        // wrapper.eq("MemberID", memberId);
        wrapper.eq("CategoryID", category);
        Category category1 = getOne(wrapper);
        return category1;
    }
}
