package com.deep.dbdesign.controller;

import com.deep.dbdesign.config.Tools;
import com.deep.dbdesign.pojo.SuperClass;
import com.deep.dbdesign.server.ManagerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Deep on 2019/12/29 20:47
 */

@RequestMapping("managers")
@Controller
public class ManagerController {

    @Autowired
    private ManagerServer managerServer = null;

    @RequestMapping("index")
    public String getPage() {
        return "managers/index";
    }

    @RequestMapping("addteacher")
    public String addteacher() {
        return "managers/addteacher";
    }

    @RequestMapping("addstudent")
    public String addstudent() {
        return "managers/addstudent";
    }

    @RequestMapping("addclass")
    public String addclass() {
        return "managers/addclass";
    }

    @RequestMapping("addcourse")
    public String addcourse() {
        return "managers/addcourse";
    }

    @RequestMapping("addteach")
    public String addteach() {
        return "managers/addteach";
    }

    @RequestMapping("welcome")
    public String getWelcome() {
        return "./welcome";
    }

    @RequestMapping("teacher")
    public String teacher() {
        return "managers/teacher";
    }

    @RequestMapping("teach")
    public String teach() {
        return "managers/teach";
    }

    @RequestMapping("student")
    public String student() {
        return "managers/student";
    }

    @RequestMapping("course")
    public String course() {
        return "managers/course";
    }

    @RequestMapping("class")
    public String classcon() {
        return "managers/class";
    }

    @RequestMapping("grade")
    public String grade() {
        return "managers/grade";
    }

    @RequestMapping("cate")
    public String cate() {
        return "managers/cate";
    }

    @RequestMapping("getpass")
    @ResponseBody
    public Map getpass() {
        if (LoginController.Pass) {
            return Tools.toMap("pass", "1");
        } else
            return Tools.toMap("pass", "0");
    }

    @RequestMapping("updatepass")
    @ResponseBody
    public Map updatepass(int pass) {
        if (pass == 0) {
            LoginController.Pass = false;
        }
        if (pass == 1) {
            LoginController.Pass = true;
        }
        return Tools.toMap("ok", "ok");
    }

    @RequestMapping("select")
    @ResponseBody
    public Map select(String id) {
        Map result = new HashMap();
        result.put("code", "0");
        List list = managerServer.select(id);
        result.put("count", list.size());
        result.put("data", list);
        return result;
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map insert(SuperClass superClass, String id) {
        managerServer.insert(superClass, id);
        return Tools.toMap("ok", "ok");
    }

    @RequestMapping("update")
    @ResponseBody
    public Map update(SuperClass superClass, String id) {
        managerServer.update(superClass, id);
        return Tools.toMap("ok", "ok");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map delete(SuperClass superClass, String id) {
        managerServer.delete(superClass, id);
        return Tools.toMap("ok", "ok");
    }
}
