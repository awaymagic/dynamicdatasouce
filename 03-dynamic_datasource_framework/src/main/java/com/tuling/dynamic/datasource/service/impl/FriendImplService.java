package com.tuling.dynamic.datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.tuling.dynamic.datasource.mapper.FriendMapper;
import com.tuling.dynamic.datasource.entity.Friend;
import com.tuling.dynamic.datasource.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendImplService implements FriendService {

    @Autowired
    FriendMapper friendMapper;


    @Override
    @DS("slave_1")  // 从库， 如果按照下划线命名方式配置多个  ， 可以指定前缀即可（组名）
    public List<Friend> list() {
        return friendMapper.list();
    }

    @Override
    @DS("master")
    public void save(Friend friend) {
        friendMapper.save(friend);
    }


//    @DS("master")
//    @DSTransactional
//    public void saveAll(){
//        // 执行多数据源的操作
//    }

}
