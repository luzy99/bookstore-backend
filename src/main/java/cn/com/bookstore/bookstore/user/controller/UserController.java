package cn.com.bookstore.bookstore.user.controller;


import cn.com.bookstore.bookstore.user.entity.User;
import cn.com.bookstore.bookstore.user.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
            if(account == null || account.equals("")){
                jsonObj.put("errcode", "30002");
                jsonObj.put("errmsg", "用户名为空");
                return jsonObj;
            }

            if(password == null || password.equals("")){
                jsonObj.put("errcode", "30003");
                jsonObj.put("errmsg", "密码为空");
                return jsonObj;
            }
            User user = userService.getUserInfo(account,password);
            user.setPassword("");
            jsonObj.put("data", user);
            jsonObj.put("errcode","0");
        }catch(Exception ex){
            jsonObj.put("errcode", "30001");
            jsonObj.put("errmsg", "管理员登录失败");
        }
        return jsonObj;
    }

    @RequestMapping("/register")
    public JSONObject register(String account, String password)
    {
        JSONObject jsonObj = new JSONObject();
        try{
            User user=new User();
            if(account==null|account.equals(""))
            {
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
            }
            else {
                jsonObj.put("errcode", "42002");
                jsonObj.put("errmsg", "上传失败");
                return jsonObj;
            }
        }catch(Exception ex){
            jsonObj.put("errcode", "42001");
            jsonObj.put("errmsg", "上传失败");
            ex.printStackTrace();
        }
        return jsonObj;
    }

    @RequestMapping("/modifyUserPwd")
    public JSONObject modifyUserPwd(String account,String oldPassword,String newPassword){
        JSONObject jsonObj = new JSONObject();
        try {
            User user = userService.getUserInfo(account,oldPassword);
            user.setPassword(newPassword);
            int id=user.getUserID();
            if (userService.changePwd(id,user)) {
                jsonObj.put("erroce", "0");
                jsonObj.put("result", "更新成功");
                return jsonObj;
            }
            else {
                jsonObj.put("errcode", "42002");
                jsonObj.put("errmsg", "更新失败");
                return jsonObj;
            }
        }catch(Exception ex){
            jsonObj.put("errcode", "42001");
            jsonObj.put("errmsg", "旧密码与新密码不匹配");
            ex.printStackTrace();
        }
        return jsonObj;

        }


}
