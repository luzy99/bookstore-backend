package cn.com.bookstore.bookstore.order.service.impl;

import cn.com.bookstore.bookstore.order.entity.Order;
import cn.com.bookstore.bookstore.order.mapper.OrderMapper;
import cn.com.bookstore.bookstore.order.service.IOrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public Order getOrderInfo(Integer memberId, Integer orderId) {
        QueryWrapper wrapper = new QueryWrapper();
       // wrapper.eq("MemberID", memberId);
        wrapper.eq("OrderID", orderId);
        Order orderInfo = getOne(wrapper);
        return orderInfo;
    }

    @Override
    public List<Order> getOrderList(Integer memberId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("MemberID", memberId);
        List<Order> orders = list(wrapper);

        return orders;

    }

    @Override
    public boolean addorder(Order order) {
        return save(order);
    }
}
