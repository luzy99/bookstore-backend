package cn.com.bookstore.bookstore.typerelation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class Typerelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("TID")
    private Integer tid;

    @TableField("BookID")
    private String BookID;

    @TableField("CategoryID")
    private Integer CategoryID;


}
