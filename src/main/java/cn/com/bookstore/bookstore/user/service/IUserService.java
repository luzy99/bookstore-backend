package cn.com.bookstore.bookstore.user.service;

import cn.com.bookstore.bookstore.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.awt.*;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuzhiwen
 * @since 2020-12-30
 */
public interface IUserService extends IService<User> {
    public User getUserInfo(String account,String password);

    public User getUserInfoByID(int memberID);

    boolean adduser(User user);

    boolean modifyUserInfo(int id, User user);

    List<User> getUserList(int i);
}
