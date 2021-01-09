package cn.com.bookstore.bookstore.category.service.impl;

import cn.com.bookstore.bookstore.category.entity.Category;
import cn.com.bookstore.bookstore.category.mapper.CategoryMapper;
import cn.com.bookstore.bookstore.category.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
