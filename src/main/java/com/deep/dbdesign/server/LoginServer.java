package com.deep.dbdesign.server;

import com.deep.dbdesign.config.Tools;
import com.deep.dbdesign.mapper.UserMapper;
import com.deep.dbdesign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author DeepBlue
 * @date 2019/11/2  17:35
 */
@Service
public class LoginServer {
    @Autowired
    private UserMapper userMapper = null;

    public boolean checkData(User user) {
        return !(user == null || user.getUsername().isEmpty() || user.getPassword().isEmpty());
    }

    public boolean checkLogin(User user) {
        switch (user.getIdentity()) {
            case "管理员":
                String password = userMapper.selectManagerPassword(user);
                return (user.getPassword().equals(password));
            case "老师":
                String password2 = userMapper.selectTeacherPassword(user);
                return (user.getPassword().equals(password2));
            case "学生":
                String password3 = userMapper.selectStudentPassword(user);
                return (user.getPassword().equals(password3));
            default:
                return false;
        }
    }

    public Map changepassword(User user, String oldpass, String pass1, String pass2) {
        if (user != null && null != pass1 && pass1.equals(pass2)) {
            switch (user.getIdentity()) {
                case "管理员":
                    if (userMapper.selectManagerPassword(user).equals(oldpass)) {
                        userMapper.changepassword("manager", user.getUsername(), pass1);
                    } else {
                        return Tools.toMap("msg", "输入有误，请重新输入！");
                    }
                    break;
                case "老师":
                    if (userMapper.selectTeacherPassword(user).equals(oldpass)) {
                        userMapper.changepassword("teacher", user.getUsername(), pass1);
                    } else {
                        return Tools.toMap("msg", "输入有误，请重新输入！");
                    }
                    break;
                case "学生":
                    if (userMapper.selectStudentPassword(user).equals(oldpass)) {
                        userMapper.changepassword("student", user.getUsername(), pass1);
                    } else {
                        return Tools.toMap("msg", "输入有误，请重新输入！");
                    }
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return Tools.toMap("msg", "修改成功!");
    }
}
