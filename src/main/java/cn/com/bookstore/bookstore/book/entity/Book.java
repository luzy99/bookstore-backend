package cn.com.bookstore.bookstore.book.entity;

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
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ISBN")
    private String isbn;

    @TableField("BookName")
    private String BookName;

    @TableField("Author")
    private String Author;

    @TableField("Price")
    private Float Price;

    @TableField("RemainNum")
    private Integer RemainNum;

    @TableField("SoldNum")
    private Integer SoldNum;

    @TableField("AddTime")
    private LocalDateTime AddTime;

    @TableField("ReleaseTime")
    private LocalDateTime ReleaseTime;

    @TableField("Available")
    private Integer Available;

    @TableField("Picture")
    private String Picture;

    @TableField("Introduction")
    private String Introduction;

    @TableField("Publisher")
    private String Publisher;


}
