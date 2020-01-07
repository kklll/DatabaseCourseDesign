package com.deep.dbdesign.controller;

import com.deep.dbdesign.config.Tools;
import com.deep.dbdesign.pojo.User;
import com.deep.dbdesign.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    @Autowired
    private LoginServer loginServer = null;

    public static boolean Pass = false;

    //显示界面（下面四个都是）
    @RequestMapping(value = "/")
    public String login() {
        return "login";
    }

    @RequestMapping("login")
    public String login3() {
        return "login";
    }

    @RequestMapping("welcome")
    public String getWelcome() {
        return "welcome";
    }

    @RequestMapping("changepassword")
    public String changepassword() {
        return "changepassword";
    }


    //更改用户密码
    @RequestMapping("changepassword2")
    @ResponseBody
    public Map changePassword(HttpServletRequest request, String oldpass, String pass1, String pass2) {
        User user = (User) request.getSession().getAttribute("session");
        return loginServer.changepassword(user, oldpass, pass1, pass2);
    }

    //post请求验证请求，请求登录的逻辑
    @ResponseBody
    @RequestMapping(value = "login2")
    public Map login2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameterValues("username")[0];
        String identity = request.getParameterValues("identity")[0];
        String password = request.getParameterValues("password")[0];
        User user = new User(identity, username, password);
        boolean flag = loginServer.checkData(user);
        Map<String, String> result = new HashMap<String, String>();
        if (flag) {
            boolean flag2 = loginServer.checkLogin(user);
            if (flag2) {
                switch (user.getIdentity()) {
                    case "管理员":
                        request.getSession().setAttribute("session", user);
                        result.put("ok", "./managers/index");
                        return result;
                    case "老师":
                        request.getSession().setAttribute("session", user);
                        result.put("ok", "./teacher/index");
                        return result;
                    case "学生":
                        request.getSession().setAttribute("session", user);
                        result.put("ok", "./student/index");
                        return result;
                }
            } else {
                result.put("msg", "用户名密码校验错误,请重新输入！");
                return result;
            }
        } else {
            result.put("msg", "信息校验错误,请检查是否注册以及字段值是否填写！");
        }
        return result;
    }


    //获取当前用户的用户名
    @ResponseBody
    @RequestMapping("getUsername")
    public Map<String, String> getUsername(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session");
        return Tools.toMap("username", user.getUsername());
    }

    //老师是否可以进行成绩的录入
    @ResponseBody
    @RequestMapping("getpass")
    public Map getpass() {
        Map map = new HashMap();
        if (LoginController.Pass) {
            map.put("msg", "成绩录入功能现在已经开放，请各位老师及时进行成绩录入！");
            map.put("pass", 1);
            return map;
        } else {
            map.put("msg", "成绩录入功能现在已经关闭,请联系管理员！");
            map.put("pass", 0);
            return map;
        }
    }

}
