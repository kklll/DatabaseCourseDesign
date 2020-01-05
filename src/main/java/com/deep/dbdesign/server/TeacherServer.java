package com.deep.dbdesign.server;

import com.deep.dbdesign.config.Tools;
import com.deep.dbdesign.mapper.TeacherMapper;
import com.deep.dbdesign.pojo.Grade;
import com.deep.dbdesign.pojo.Student;
import com.deep.dbdesign.pojo.Teacher;
import com.deep.dbdesign.pojo.TeacherClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Deep on 2019/12/31 14:49
 */
@Service
public class TeacherServer {
    @Autowired
    private TeacherMapper teacherMapper = null;

    private Map map = new HashMap();

    public Teacher getinfo(String username) {
        return teacherMapper.getinfo(username);
    }

    public void updateInfo(Teacher user) {
        teacherMapper.updateinfo(user);
    }

    public List<TeacherClassInfo> getTeacherClassInfo(String username) {
        return teacherMapper.getTeacherClassInfo(username);
    }

    public List<Student> getStudentInfo(String username) {
        return teacherMapper.getStudentInfo(username);
    }

    public Map getstudentgrade(String username, String classno, String coursename) {
        if (classno != null && coursename != null) {
            map.put("classno", classno);
            map.put("coursename", coursename);
            return Tools.toMap("ok", "ok");
        } else {
            List <Grade> re = teacherMapper.getstudentgrade(username,
                    map.get("classno").toString(), map.get("coursename").toString());
            for (int i = 0; i < re.size(); i++) {
                re.get(i).setCname(map.get("coursename").toString());
            }
            map.clear();
            Map result = new HashMap();
            result.put("code", "0");
            result.put("count", re.size());
            result.put("data", re);
            return result;
        }
    }

    public Map getstudentgrade2(String username, String classno, String coursename)
    {
        List <Grade> re = teacherMapper.getstudentgrade2(username,classno,coursename);
        Map result = new HashMap();
        result.put("code", "0");
        result.put("count", re.size());
        result.put("data", re);
        return result;
    }

    public void insertGrade(String sno,String cno,int grade){
        Map <String,Object> xx=new HashMap<>();
        xx.put("sno",sno);
        xx.put("cno",cno);
        xx.put("grade",grade);
        teacherMapper.insertGrade(xx);
    }

    public void updateGrade(String sno,String cno,int grade){
        Map <String,Object> xx=new HashMap<>();
        xx.put("sno",sno);
        xx.put("cno",cno);
        xx.put("grade",grade);
        teacherMapper.updateGrade(xx);
    }
}
