package cn.com.bookstore.bookstore.user.service;

import cn.com.bookstore.bookstore.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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

    boolean adduser(User user);

    boolean changePwd(int id,User user);
}
