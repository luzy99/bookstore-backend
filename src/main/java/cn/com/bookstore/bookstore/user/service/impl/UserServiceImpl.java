package cn.com.bookstore.bookstore.user.service.impl;

import cn.com.bookstore.bookstore.user.entity.User;
import cn.com.bookstore.bookstore.user.mapper.UserMapper;
import cn.com.bookstore.bookstore.user.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuzhiwen
 * @since 2020-12-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getUserInfo(String account, String password) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("UserName", account);
        wrapper.eq("PassWord", password);
        User userInfo = getOne(wrapper);
        return userInfo;
    }

    @Override
    public boolean adduser(User user) {
        return save(user);
    }

    @Override
    public boolean changePwd(int id,User user) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("UserID", id);
        return update(user,wrapper);
    }

    @Override
    public User getUserAddr(Integer memberId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("UserID", memberId);
        User userInfo = getOne(wrapper);
        return userInfo;
    }
}
