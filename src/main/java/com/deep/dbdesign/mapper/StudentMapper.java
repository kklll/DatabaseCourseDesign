package com.deep.dbdesign.mapper;

import com.deep.dbdesign.pojo.Grade;
import com.deep.dbdesign.pojo.MyGrade;
import com.deep.dbdesign.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author DeepBlue
 * @date 2019/10/31  21:04
 */

@Mapper
public interface StudentMapper {
    Student getinfo(String username);

    void updateinfo(Student teacher);

    List<MyGrade> getMyGrade(String name);

}
