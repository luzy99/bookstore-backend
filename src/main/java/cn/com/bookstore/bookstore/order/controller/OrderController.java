package cn.com.bookstore.bookstore.order.controller;


import cn.com.bookstore.bookstore.book.entity.Book;
import cn.com.bookstore.bookstore.book.service.IBookService;
import cn.com.bookstore.bookstore.order.entity.Order;
import cn.com.bookstore.bookstore.order.service.IOrderService;
import cn.com.bookstore.bookstore.user.entity.User;
import cn.com.bookstore.bookstore.user.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuzhiwen
 * @since 2020-12-30
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private  IUserService userService;

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/getOrderDetail")
    public JSONObject getOrderDetail(Integer memberId, Integer orderId) {
        JSONObject jsonObj = new JSONObject();
        try {
            if(memberId == null || memberId.equals("")){
                jsonObj.put("errcode", "50002");
                jsonObj.put("errmsg", "会员id为空");
                return jsonObj;
            }

            if(orderId == null || orderId.equals("")){
                jsonObj.put("errcode", "50003");
                jsonObj.put("errmsg", "订单id为空");
                return jsonObj;
            }
            Order order = orderService.getOrderInfo(memberId,orderId);
            User user =userService.getUserAddr(memberId);
            jsonObj.put("order", order);
            jsonObj.getJSONObject("order").put("address",user.getAddress());
            jsonObj.put("errcode","0");
        }catch(Exception ex){
            jsonObj.put("errcode", "50001");
            jsonObj.put("errmsg", "订单获取失败");
        }
        return jsonObj;
    }

    @RequestMapping("/getOrderList")
    public JSONObject getOrderList(Integer memberId) {
        JSONObject jsonObj = new JSONObject();
        try{
            if(memberId == null || memberId.equals("")){
                jsonObj.put("errcode", "52002");
                jsonObj.put("errmsg", "用户Id为空");
                return jsonObj;
            }
            List<Order> orders=orderService.getOrderList(memberId);

            jsonObj.put("errcode", "0");
            jsonObj.put("data", orders);
            jsonObj.put("status","true");
        }catch(Exception ex){
            jsonObj.put("errcode", "51001");
            jsonObj.put("errmsg", "获取订单列表失败");
        }
        return jsonObj;
    }

    @RequestMapping("/addorder")
    public JSONObject addOrder(Integer memberId, String ISBN, Integer orderNum)
    {
        JSONObject jsonObj = new JSONObject();
        try{
            Order order =new Order();
            if(memberId==null|memberId.equals(""))
            {
                jsonObj.put("errcode", "52002");
                jsonObj.put("errmsg", "缺少账号");
                return jsonObj;
            }


            order.setMemberID(memberId);
            order.setBookID(ISBN);
            order.setOrderNum(orderNum);
            LocalDateTime time=LocalDateTime.now();
            order.setOrderTime(time);
            order.setOrderState(0);
            Book book =bookService.getbook(ISBN);
            order.setBookPrice(book.getPrice());
            if (orderService.addorder(order)) {
                jsonObj.put("errcode", "0");
                jsonObj.put("result", "上传成功");
                return jsonObj;
            }
            else {
                jsonObj.put("errcode", "42002");
                jsonObj.put("errmsg", "上传失败");
                return jsonObj;
            }
        }catch(Exception ex){
            jsonObj.put("errcode", "42001");
            jsonObj.put("errmsg", "上传失败");
            ex.printStackTrace();
        }
        return jsonObj;
    }

}
