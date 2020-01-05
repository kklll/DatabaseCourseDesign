package com.deep.dbdesign.mapper;

import com.deep.dbdesign.pojo.Grade;
import com.deep.dbdesign.pojo.Student;
import com.deep.dbdesign.pojo.Teacher;
import com.deep.dbdesign.pojo.TeacherClassInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author DeepBlue
 * @date 2019/10/31  21:04
 */

@Mapper
public interface TeacherMapper {
    Teacher getinfo(String username);

    void updateinfo(Teacher teacher);

    List<TeacherClassInfo> getTeacherClassInfo(String username);

    List<Student> getStudentInfo(String username);

    List<Grade> getstudentgrade(String username, String classno, String course);

    void insertGrade(Map<String, Object> x);

    List<Grade> getstudentgrade2(String username, String classno, String course);

    void updateGrade(Map<String, Object> x);
}
