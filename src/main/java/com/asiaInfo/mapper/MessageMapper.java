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
            @Result(property = "msgTypeCd", column = "msg_type_cd"),
            @Result(property = "sortDt", column = "sort_dt"),
            @Result(property = "commonRegionId", column = "common_region_id"),
            @Result(property = "teamKey", column = "team_key"),
            @Result(property = "dealFlag", column = "deal_flag"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "msgContent", column = "msg_content"),
            @Result(property = "busiDesc", column = "busi_desc"),
            @Result(property = "listenerDesc", column = "listener_desc"),
            @Result(property = "ip", column = "ip")
    })
    @Select("SELECT msg_id, remark FROM intf_co_archive_msg")
    List<Message> findAll();

    @Results({
            @Result(property = "msgId", column = "msg_id"),
            @Result(property = "msgTypeCd", column = "msg_type_cd"),
            @Result(property = "sortDt", column = "sort_dt"),
            @Result(property = "commonRegionId", column = "common_region_id"),
            @Result(property = "teamKey", column = "team_key"),
            @Result(property = "dealFlag", column = "deal_flag"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "msgContent", column = "msg_content"),
            @Result(property = "busiDesc", column = "busi_desc"),
            @Result(property = "listenerDesc", column = "listener_desc"),
            @Result(property = "ip", column = "ip")
    })
    @Select("SELECT msg_id,msg_type_cd,sort_dt,common_region_id,team_key,deal_flag, remark,msg_content,busi_desc,listener_desc,ip FROM ${tableName} where rownum = ${rownum} ")
    List<Message> findAllByTableName(@Param("tableName") String tableName,@Param("rownum") int rownum);


}