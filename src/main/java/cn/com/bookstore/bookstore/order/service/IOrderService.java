package cn.com.bookstore.bookstore.order.service;

import cn.com.bookstore.bookstore.order.entity.Order;
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
public interface IOrderService extends IService<Order> {

    Order getOrderInfo(Integer memberId, Integer orderId);

    List<Order> getOrderList(Integer memberId);

    boolean addorder(Order order);
}
