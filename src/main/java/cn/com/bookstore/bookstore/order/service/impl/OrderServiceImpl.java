package cn.com.bookstore.bookstore.order.service.impl;

import cn.com.bookstore.bookstore.order.entity.Order;
import cn.com.bookstore.bookstore.order.mapper.OrderMapper;
import cn.com.bookstore.bookstore.order.service.IOrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
