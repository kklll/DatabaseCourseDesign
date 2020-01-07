package com.deep.dbdesign.controller;

import com.deep.dbdesign.config.Tools;
import com.deep.dbdesign.mapper.StudentMapper;
import com.deep.dbdesign.pojo.Student;
import com.deep.dbdesign.pojo.User;
import com.deep.dbdesign.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Deep on 2019/12/29 20:47
 */

@RequestMapping("student")
@Controller
public class StudentController {

    @Autowired
    private StudentServer studentServer = null;

    @Autowired
    private StudentMapper studentMapper = null;

    @RequestMapping("index")
    public String getPage() {
        return "student/index";
    }

    @RequestMapping("welcome")
    public String getWelcome() {
        return "./welcome";
    }

    @RequestMapping("info")
    public String getInfo() {
        return "student/info";
    }

    //    获取个人信息
    @RequestMapping("getinfo")
    @ResponseBody
    public Student getinfo(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session");
        return studentServer.getinfo(user.getUsername());
    }


    //    改变个人信息
    @RequestMapping(value = "changeinfo")
    @ResponseBody
    public Map changeinfo(Student student) {
        studentServer.updateInfo(student);
        System.out.println(student);
        return Tools.toMap("ok", "xxxx");
    }

    //请求我的成绩页面
    @RequestMapping("mygrade")
    public String mygrade() {
        return "student/mygrade";
    }

    //我的成绩数据
    @RequestMapping("mygrade1")
    @ResponseBody
    public Map getStudentInfo(HttpServletRequest request) {
        String name = getName(request);
        List list = studentServer.getMyGrade(name);
        Map result = new HashMap();
        result.put("code", "0");
        result.put("count", list.size());
        result.put("data", list);
        return result;
    }

    //    获取用户名
    public String getName(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session");
        return user.getUsername();
    }
}
