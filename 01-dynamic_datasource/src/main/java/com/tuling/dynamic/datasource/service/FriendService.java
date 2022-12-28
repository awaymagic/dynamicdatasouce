package com.tuling.dynamic.datasource.service;

import com.tuling.dynamic.datasource.entity.Friend;

import java.util.List;

public interface FriendService {

    List<Friend> list();

    void save(Friend friend);

}
