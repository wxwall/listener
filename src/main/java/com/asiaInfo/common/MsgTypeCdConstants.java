package com.asiaInfo.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxwall on 2017/9/5.
 */
@Component
public class MsgTypeCdConstants {


    private Map<String, String> tableName = new HashMap<>(); //接收prop1里面的属性值

    public MsgTypeCdConstants(){
        tableName.put("111","intf_co_osr_msg");
        tableName.put("103","intf_co_archive_msg");
    }

    public  String getTableName(int typeCd) {
        return tableName.get(typeCd);
    }
}
