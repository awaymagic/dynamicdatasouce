package com.tuling.dynamic.datasource.controller;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.tuling.dynamic.datasource.entity.Friend;
import com.tuling.dynamic.datasource.service.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
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
    public void in(){
        Friend friend = new Friend();
        friend.setName("loulan");
        friendService.save(friend);
    }

    @Autowired
    private DataSource dataSource;

    @GetMapping("ds/des")
    public Object remove(String name) {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;

        ds.getDataSources().forEach((s,datasource) -> {
            System.out.println(datasource);
        });

        return "后台查看当前数据源信息";
    }



}
