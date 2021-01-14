package cn.com.bookstore.bookstore.user.controller;


import cn.com.bookstore.bookstore.user.entity.User;
import cn.com.bookstore.bookstore.user.service.IUserService;
import cn.com.bookstore.bookstore.user.service.impl.UserServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuzhiwen
 * @since 2020-12-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login")
    public JSONObject loginuser(String account, String password) {
        JSONObject jsonObj = new JSONObject();
        try {
            if (account == null || account.equals("")) {
                jsonObj.put("errcode", "30002");
                jsonObj.put("errmsg", "用户名为空");
                return jsonObj;
            }

            if (password == null || password.equals("")) {
                jsonObj.put("errcode", "30003");
                jsonObj.put("errmsg", "密码为空");
                return jsonObj;
            }
            User user = userService.getUserInfo(account, password);
            user.setPassword("");
            jsonObj.put("data", user);
            jsonObj.put("errcode", "0");
        } catch (Exception ex) {
            jsonObj.put("errcode", "30001");
            jsonObj.put("errmsg", "管理员登录失败");
        }
        return jsonObj;
    }

    @RequestMapping("/register")
    public JSONObject register(String account, String password) {
        JSONObject jsonObj = new JSONObject();
        try {
            User user = new User();
            if (account == null | account.equals("")) {
                jsonObj.put("errcode", "42002");
                jsonObj.put("errmsg", "缺少账号");
                return jsonObj;
            }
            user.setUserName(account);
            user.setPassword(password);
            user.setAdmin(0);
            //user.setUserID(2);
            if (userService.adduser(user)) {
                jsonObj.put("errcode", "0");
                jsonObj.put("result", "上传成功");
                return jsonObj;
            } else {
                jsonObj.put("errcode", "42002");
                jsonObj.put("errmsg", "上传失败");
                return jsonObj;
            }
        } catch (Exception ex) {
            jsonObj.put("errcode", "42001");
            jsonObj.put("errmsg", "上传失败");
            ex.printStackTrace();
        }
        return jsonObj;
    }

    @RequestMapping("/modifyUserInfo")
    public JSONObject modifyUserInfo(int memberID, String password, String email, String adress, String phone) {
        JSONObject jsonObj = new JSONObject();
        try {
            User user = userService.getUserInfoByID(memberID);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhoneNumber(phone);
            user.setAddress(adress);
            int id = user.getUserID();
            if (userService.modifyUserInfo(id, user)) {
                jsonObj.put("errcode", "0");
                jsonObj.put("result", "更新成功");
                return jsonObj;
            } else {
                jsonObj.put("errcode", "42002");
                jsonObj.put("errmsg", "更新失败");
                return jsonObj;
            }
        } catch (Exception ex) {
            jsonObj.put("errcode", "42001");
            jsonObj.put("errmsg", "更新失败");
            ex.printStackTrace();
        }
        return jsonObj;
    }

    @RequestMapping(value = "/getUserInfo")
    public JSONObject getUserInfo(int memberId) {
        JSONObject jsonObj = new JSONObject();
        try {
            User user = userService.getUserInfoByID(memberId);
            jsonObj.put("UserID", user.getUserID());
            jsonObj.put("UserName", user.getUserName());
            jsonObj.put("PassWord", user.getPassWord());
            jsonObj.put("Address", user.getAddress());
            jsonObj.put("PhoneNumber", user.getPhoneNumber());
            jsonObj.put("Email", user.getEmail());
            jsonObj.put("Admin", user.getAdmin());
            jsonObj.put("errcode", "0");
            jsonObj.put("errmsg", "查询成功");
        } catch (Exception ex) {
            jsonObj.put("errcode", "30001");
            jsonObj.put("errmsg", "查询失败");
        }
        return jsonObj;
    }

    @RequestMapping(value = "/getUserList")
    public JSONObject getUserList(int adminId) {
        JSONObject jsonObj = new JSONObject();
        try {
            User user = userService.getUserInfoByID(adminId);
            if (user.getAdmin() == 0) {
                jsonObj.put("errcode", "10001");
                jsonObj.put("errmsg", "非管理员账户");
                return jsonObj;
            } else {
                java.util.List<User> user1 = userService.getUserList(0);
                jsonObj.put("UserList", user1);
                jsonObj.put("errcode", "0");
                jsonObj.put("errmsg", "查询成功");
            }
        } catch (Exception ex) {
            jsonObj.put("errcode", "30001");
            jsonObj.put("errmsg", "查询失败");
        }
        return jsonObj;
    }

}

