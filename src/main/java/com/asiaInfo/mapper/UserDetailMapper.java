package com.asiaInfo.mapper;

import com.asiaInfo.model.UserDetail;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserDetailMapper   {



    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "qq", column = "qq")
    })
    @Select("select id,name,qq from user_detail")
    public List<UserDetail> selectUserDetail();
}