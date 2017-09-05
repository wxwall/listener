package com.asiaInfo.mapper;

import com.asiaInfo.model.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM intf_co_archive_msg WHERE msg_id = #{msg_id}")
    Message findByid(@Param("msg_id") String msg_id);

    @Results({
            @Result(property = "msgId", column = "msg_id"),
            @Result(property = "remark", column = "remark")
    })
    @Select("SELECT msg_id, remark FROM intf_co_archive_msg")
    List<Message> findAll();

    @Results({
            @Result(property = "msgId", column = "msg_id"),
            @Result(property = "remark", column = "remark")
    })


    @Select("SELECT msg_id, remark FROM ${tableName}  ")
    List<Message> findAllByTableName(@Param("tableName") String tableName);


}