package com.asiaInfo.mapper;


import com.asiaInfo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "job", column = "job")
    })
    @Select("SELECT id,username,job from user_info")
    public List<UserInfo> selectUserInfo();
}