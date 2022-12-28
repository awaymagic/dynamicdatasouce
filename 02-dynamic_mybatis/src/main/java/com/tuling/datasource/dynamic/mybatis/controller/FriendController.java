package com.tuling.datasource.dynamic.mybatis.controller;

import com.tuling.datasource.dynamic.mybatis.entity.Friend;
import com.tuling.datasource.dynamic.mybatis.service.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("friend")
@Slf4j
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping(value = "select")
    public List<Friend> select(){
        return friendService.list();
    }


    @GetMapping(value = "insert")
    public String insert(){
        Friend friend = new Friend();
        friend.setName("loulan");
        friendService.save(friend);
        return "data added";
    }


//    @GetMapping(value = "save")
//    public void save() throws Exception {
//        Friend friend = new Friend();
//        friend.setName("loulan");
//        friendService.saveAll(friend);
//    }
}
