package com.tuling.datasource.dynamic.mybatis.service;


import com.tuling.datasource.dynamic.mybatis.entity.Friend;

import java.util.List;

public interface FriendService {

    List<Friend> list();

    // 保存-- 写库
    void saveW(Friend friend);

    // 保存-- 读库
    void saveR(Friend friend);

    void save(Friend friend);

    // 读-- 写库
//    void saveAll(Friend friend) throws Exception;
//
//    void saveAllR(Friend friend);
}
