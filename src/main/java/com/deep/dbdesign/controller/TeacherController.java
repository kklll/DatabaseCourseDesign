package com.deep.dbdesign.controller;

import com.deep.dbdesign.config.Tools;
import com.deep.dbdesign.mapper.TeacherMapper;
import com.deep.dbdesign.pojo.Teacher;
import com.deep.dbdesign.pojo.User;
import com.deep.dbdesign.server.TeacherServer;
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

@RequestMapping("teacher")
@Controller
public class TeacherController {
    @Autowired
    private TeacherServer teacherServer = null;

    @Autowired
    private TeacherMapper teacherMapper = null;

    @RequestMapping("index")
    public String getPage() {
        return "teacher/index";
    }

    @RequestMapping("welcome")
    public String getWelcome() {
        return "./welcome";
    }

    @RequestMapping("info")
    public String getInfo() {
        return "teacher/info";
    }


    @RequestMapping("getinfo")
    @ResponseBody
    public Teacher getinfo(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session");
        return teacherServer.getinfo(user.getUsername());
    }


    @RequestMapping(value = "changeinfo", method = RequestMethod.POST)
    @ResponseBody
    public Map changeinfo(Teacher teacher) {
        teacherServer.updateInfo(teacher);
        System.out.println(teacher);
        return Tools.toMap("ok", "xxxx");
    }

    @RequestMapping("getTeacherClassInfo")
    @ResponseBody
    public Map getTeacherClassInfo(HttpServletRequest request) {
        String name = getName(request);
        List list = teacherServer.getTeacherClassInfo(name);
        Map result = new HashMap();
        result.put("code", "0");
        result.put("count", list.size());
        result.put("data", list);
        return result;
    }


    public String getName(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session");
        return user.getUsername();
    }

    @RequestMapping("classmanagement")
    public String getManagePage() {
        return "teacher/classmanagement";
    }


    @RequestMapping("classinfo")
    public String getpages() {
        return "teacher/class";
    }

    @RequestMapping("studentinfo")
    @ResponseBody
    public Map getStudentInfo(HttpServletRequest request) {
        String name = getName(request);
        List list = teacherServer.getStudentInfo(name);
        Map result = new HashMap();
        result.put("code", "0");
        result.put("count", list.size());
        result.put("data", list);
        return result;
    }

    @RequestMapping("gradein")
    public String getGradeClass() {
        return "teacher/gradein";
    }

    @RequestMapping("qugrades")
    public String getGradePage() {
        return "teacher/qugrades";
    }

    @RequestMapping("getstudentgrade")
    @ResponseBody
    public Map getstudentgrade(HttpServletRequest request, String classno, String coursename) {
        return teacherServer.getstudentgrade(getName(request), classno, coursename);
    }

    @RequestMapping("insertGrade")
    @ResponseBody
    public Map insertGrade(String sno, String cno, Integer grade) {
        teacherServer.insertGrade(sno, cno, grade);
        return Tools.toMap("ok", "ok");
    }

    @RequestMapping("updetegrade")
    @ResponseBody
    public Map updateGrade(String sno, String cno, Integer grade) {
        teacherServer.updateGrade(sno, cno, grade);
        return Tools.toMap("ok", "ok");
    }


    @RequestMapping("qugrade1")
    public String updetegrade1() {
        return "teacher/qugrade";
    }

    @ResponseBody
    @RequestMapping("qugrade2")
    public Map updetegrade2(HttpServletRequest request, String classno, String coursename) {
        return teacherServer.getstudentgrade2(getName(request), classno, coursename);
    }

}
