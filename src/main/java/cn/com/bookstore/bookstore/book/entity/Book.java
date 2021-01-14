package cn.com.bookstore.bookstore.book.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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

    @TableId(value = "ISBN",type= IdType.INPUT)
    private String isbn;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public void setRemainNum(Integer remainNum) {
        RemainNum = remainNum;
    }

    public void setSoldNum(Integer soldNum) {
        SoldNum = soldNum;
    }

    public void setAddTime(LocalDateTime addTime) {
        AddTime = addTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        ReleaseTime = releaseTime;
    }

    public void setAvailable(Integer available) {
        Available = available;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return BookName;
    }

    public String getAuthor() {
        return Author;
    }

    public Float getPrice() {
        return Price;
    }

    public Integer getRemainNum() {
        return RemainNum;
    }

    public Integer getSoldNum() {
        return SoldNum;
    }

    public LocalDateTime getAddTime() {
        return AddTime;
    }

    public LocalDateTime getReleaseTime() {
        return ReleaseTime;
    }

    public Integer getAvailable() {
        return Available;
    }

    public String getPicture() {
        return Picture;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public String getPublisher() {
        return Publisher;
    }

    public String getCategory() {
        return Category;
    }

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

    @TableField("Category")
    private String Category;
}
