package com.tuling.datasource.dynamic.mybatis.mapper.r;


import com.tuling.datasource.dynamic.mybatis.entity.Friend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: wangyi
 * @Date: 2020/12/12 01:16
 * @Description: 
 */
public interface RFriendMapper {
    @Select("SELECT * FROM friend")
    List<Friend> list();

    @Insert("INSERT INTO  friend(`name`) VALUES (#{name})")
    void save(Friend friend);
}