package com.tuling.dynamic.datasource.service.impl;

import com.tuling.dynamic.datasource.DynamicDataSource;
import com.tuling.dynamic.datasource.annotation.WR;
import com.tuling.dynamic.datasource.entity.Friend;
import com.tuling.dynamic.datasource.mapper.FriendMapper;
import com.tuling.dynamic.datasource.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendImplService implements FriendService {

    @Autowired
    FriendMapper friendMapper;


    @Override
    // @WR("R")        // 库2
    public List<Friend> list() {
       DynamicDataSource.name.set("R");
        return friendMapper.list();
    }

    @Override
    // @WR("W")        // 库1
    public void save(Friend friend) {
       DynamicDataSource.name.set("W");
        friendMapper.save(friend);
    }

}
