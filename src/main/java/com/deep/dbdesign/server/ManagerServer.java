package com.deep.dbdesign.server;

import com.deep.dbdesign.mapper.ManagerMapper;
import com.deep.dbdesign.pojo.SuperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Deep on 2019/12/31 14:50
 */

@Service
public class ManagerServer {
    @Autowired
    private ManagerMapper managerMapper = null;

    public void insert(SuperClass superClass, String id) {
        managerMapper.insert(superClass, id);
    }

    public void delete(SuperClass superClass, String id) {
        managerMapper.delete(superClass, id);
    }

    public List<SuperClass> select(String id) {
        return managerMapper.select(id);
    }

    public void update(SuperClass superClass, String id) {
        managerMapper.update(superClass, id);
    }
}
