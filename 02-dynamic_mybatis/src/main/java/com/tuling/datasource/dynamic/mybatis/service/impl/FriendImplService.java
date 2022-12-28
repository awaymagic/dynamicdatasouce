package com.tuling.datasource.dynamic.mybatis.service.impl;

import com.tuling.datasource.dynamic.mybatis.entity.Friend;
import com.tuling.datasource.dynamic.mybatis.mapper.r.RFriendMapper;
import com.tuling.datasource.dynamic.mybatis.mapper.w.WFriendMapper;
import com.tuling.datasource.dynamic.mybatis.service.FriendService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class FriendImplService implements FriendService {

    @Autowired
    private RFriendMapper rFriendMapper;

    @Autowired
    private WFriendMapper wFriendMapper;

    @Autowired
    TransactionTemplate wTransactionTemplate;
    @Autowired
    TransactionTemplate rTransactionTemplate;


    // 读-- 读库
    @Override
    public List<Friend> list() {
        return rFriendMapper.list();
    }

    // 保存-- 写库
    @Override
    public void save(Friend friend) {
        wFriendMapper.save(friend);
    }


    // 保存-- 写库
    @Override
    public void saveW(Friend friend) {
        friend.setName("loulan");
        wFriendMapper.save(friend);
    }

    // 保存-- 读库
    @Override
    public void saveR(Friend friend) {
        friend.setName("loulan");
        rFriendMapper.save(friend);
    }

    // 读-- 写库
    // 这种方式只能针对一个事务管理器进行控制，  无法完成多数据源控制
    // 特殊情况：
    //  1. 如果主库出现异常    可以
    //  2. 从库出现了异常   可以
    //  3. 异常出现在  主库和从库中间  可以
    //  除非在主库和从库之后进行的业务出现异常就不能保证事务一致性
    /*@Transactional(transactionManager = "wTransactionManager")
    @Transactional(transactionManager = "rTransactionManager")*/
//    public void saveAll1(Friend friend) {
//        saveW(friend);
//        saveR(friend);
//        int a = 1 / 0;
//    }


//    public void saveAll2(Friend friend) {
//        wTransactionTemplate.execute((wstatus) -> {
//            rTransactionTemplate.execute((rstatus) -> {
//                try {
//                    saveW(friend);
//                    saveR(friend);
//                    //int a = 1 / 0;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    wstatus.setRollbackOnly();
//                    rstatus.setRollbackOnly();
//                    return false;
//                }
//                return true;
//            });
//            return true;
//        });
//    }
//
//    @Transactional(transactionManager = "wTransactionManager")
//    public void saveAll(Friend friend) throws Exception {
//        FriendService friendService = (FriendService) AopContext.currentProxy();
//        friendService.saveAllR(friend);
//    }
//
//    @Transactional(transactionManager = "rTransactionManager")
//    public void saveAllR(Friend friend) {
//        saveW(friend);
//        saveR(friend);
//        int a = 1 / 0;
//    }
}
