package cn.com.bookstore.bookstore.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuzhiwen
 * @since 2020-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bookstore.order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue
    @TableId("OrderID")
    private Integer OrderID;

    @TableField("BookID")
    private String BookID;

    @TableField("MemberID")
    private Integer MemberID;

    @TableField("OrderNum")
    private Integer OrderNum;

    @TableField("OrderTime")
    private LocalDateTime OrderTime;

    @TableField("OrderState")
    private Integer OrderState;

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public void setMemberID(Integer memberID) {
        MemberID = memberID;
    }

    public void setOrderNum(Integer orderNum) {
        OrderNum = orderNum;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        OrderTime = orderTime;
    }

    public void setOrderState(Integer orderState) {
        OrderState = orderState;
    }

    public void setBookPrice(Float bookPrice) {
        BookPrice = bookPrice;
    }

    @TableField("BookPrice")
    private Float BookPrice;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public String getBookID() {
        return BookID;
    }

    public Integer getMemberID() {
        return MemberID;
    }

    public Integer getOrderNum() {
        return OrderNum;
    }

    public LocalDateTime getOrderTime() {
        return OrderTime;
    }

    public Integer getOrderState() {
        return OrderState;
    }

    public Float getBookPrice() {
        return BookPrice;
    }
}
