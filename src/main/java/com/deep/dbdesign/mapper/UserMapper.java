package com.deep.dbdesign.mapper;

import com.deep.dbdesign.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DeepBlue
 * @date 2019/10/31  21:04
 */

@Mapper
public interface UserMapper {
    String selectTeacherPassword(User user);

    String selectManagerPassword(User user);

    String selectStudentPassword(User user);

    void changepassword(String tablename, String username, String pass);
}
