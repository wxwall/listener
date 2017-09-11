package com.asiaInfo.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 根据配置文件.yml,对应的值去配置文件里找
 */
@Component
@ConfigurationProperties(prefix="listener")
public class ConstantsParam {


    private int[] msgType;

    private String[] teamKeys;

    private String [] defaultIp;

    private int defaultPort;

    private int resultNum;

    /**其他配置方式样例
    private List<Map<String, String>> listProp1 = new ArrayList<>(); //接收prop1里面的属性值
    private List<String> listProp2 = new ArrayList<>(); //接收prop2里面的属性值
    **/

    private Map<String, String> msgTypeToURL = new HashMap<>(); //接收msgTypeToURL里面的属性值

    public int[] getMsgType() {
        return msgType;
    }

    public void setMsgType(int[] msgType) {
        this.msgType = msgType;
    }

    public String[] getTeamKeys() {
        return teamKeys;
    }

    public void setTeamKeys(String[] teamKeys) {
        this.teamKeys = teamKeys;
    }


    public String[] getDefaultIp() {
        return defaultIp;
    }

    public void setDefaultIp(String[] defaultIp) {
        this.defaultIp = defaultIp;
    }

    public int getDefaultPort() {
        return defaultPort;
    }

    public void setDefaultPort(int defaultPort) {
        this.defaultPort = defaultPort;
    }

    public Map<String, String> getMsgTypeToURL() {
        return msgTypeToURL;
    }

    public void setMsgTypeToURL(Map<String, String> msgTypeToURL) {
        this.msgTypeToURL = msgTypeToURL;
    }

    public int getResultNum() {
        return resultNum;
    }

    public void setResultNum(int resultNum) {
        this.resultNum = resultNum;
    }
}
