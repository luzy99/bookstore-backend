package cn.com.bookstore.bookstore.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @TableField("BookPrice")
    private Float BookPrice;


}
