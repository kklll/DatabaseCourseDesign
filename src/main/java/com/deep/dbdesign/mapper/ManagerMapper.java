package com.deep.dbdesign.mapper;

import com.deep.dbdesign.pojo.SuperClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Deep on 2020/1/5 12:54
 */
@Mapper
public interface ManagerMapper {
    List<SuperClass> select(String id);

    void insert(SuperClass superClass,String id);

    void update(SuperClass superClass,String id);

    void delete(SuperClass superClass,String id);
}
