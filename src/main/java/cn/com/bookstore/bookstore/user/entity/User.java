package cn.com.bookstore.bookstore.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue
    @TableId(value = "UserID")
    private Integer UserID;

    @TableField("UserName")
    private String UserName;

    @TableField("PassWord")
    private String PassWord;

    @TableField("Address")
    private String Address;

    @TableField("PhoneNumber")
    private String PhoneNumber;

    @TableField("Email")
    private String Email;

    @TableField("Admin")
    private Integer Admin;

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Integer getUserID() {
        return UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public Integer getAdmin() {
        return Admin;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAdmin(Integer admin) {
        Admin = admin;
    }

    public void setPassword(String password) {
        this.PassWord = password;
    }

}
