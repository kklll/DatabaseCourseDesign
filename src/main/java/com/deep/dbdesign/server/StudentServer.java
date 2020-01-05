package com.deep.dbdesign.server;

import com.deep.dbdesign.mapper.StudentMapper;
import com.deep.dbdesign.pojo.MyGrade;
import com.deep.dbdesign.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Deep on 2019/12/31 14:50
 */

@Service
public class StudentServer {

    @Autowired
    private StudentMapper studentMapper = null;

    public Student getinfo(String username) {
        return studentMapper.getinfo(username);
    }

    public void updateInfo(Student user) {
        studentMapper.updateinfo(user);
    }

    public List<MyGrade> getMyGrade(String name) {
        return studentMapper.getMyGrade(name);
    }
}
