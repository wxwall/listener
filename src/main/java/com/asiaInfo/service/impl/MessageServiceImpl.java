package com.asiaInfo.service.impl;

import com.asiaInfo.common.ConstantsParam;
import com.asiaInfo.core.http.HttpAPIService;
import com.asiaInfo.core.http.HttpResult;
import com.asiaInfo.exception.MyException;
import com.asiaInfo.mapper.MessageMapper;
import com.asiaInfo.model.Message;
import com.asiaInfo.service.MessageService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxwall on 2017/9/1.
 */
@Service
public class MessageServiceImpl implements MessageService {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private MessageMapper messageMapper;

    @Resource
    private HttpAPIService httpAPIService;

    @Autowired
    private ConstantsParam Constants;

    private HttpClient client;


    @Override
    public List<Message> queryMessage(Message message) {
        return messageMapper.findAll();
    }

    @Override
    public List<Message> queryMessageByTypeCd(Message message) throws Exception {
        int typeCd = message.getMsgTypeCd();
        if(typeCd == 0){
            throw new Exception("MsgTypeCd不能为0");
        }
        String tableName = getTableName(typeCd);
        tableName = "intf_co_archive_msg";
        return messageMapper.findAllByTableName(tableName,Constants.getResultNum());
    }

    private String getTableName(int typeCd) {
        return null;
    }


    @Override
    public List<Message> processMessage(List<Message> messages) throws MyException {
        for (Message message : messages) {
            HttpResult httpResult = null;
            String url = assembleURL(message.getIp(),message.getMsgTypeCd());
            Long beginTime = System.currentTimeMillis();
            try {
                httpResult = httpAPIService.doPost(url,message.getListenerDesc());
            }
            catch(ConnectTimeoutException e){
                logger.info("连接超时，总共花费：" + (System.currentTimeMillis() - beginTime));
                retryProcess(message);
                e.printStackTrace();
            }
            catch (IOException e) {
                System.out.println("IOException ...");
                //TODO 把IP，端口，入参等发送到队列或是间件中去，后面做监控需要这些数据
                e.printStackTrace();
            }
            if(httpResult.getCode().toString().equals("200")){
                successProcess(httpResult.getBody());
            } else if(httpResult.getCode().toString().equals("404")){
                retryProcess(message);
            } else {
                exceptionProcess();
            }
        }
        return null;
    }




    //TODO 成功后处理
    private void successProcess(String httpResultBody) {
        AnalyticMsg(httpResultBody);
    }

    /**
     * 解析消息实体，转换成返回结果对象
     */
    private void AnalyticMsg(String msgBody) {


    }

    //TODO 超时处理：重新加入队列中，并引入计数器，重加入队列次数，超过就算重发不了，再加入监控中
    private void retryProcess(Message message) {
    }

    //TODO  异常返回处理
    private void exceptionProcess() {
    }

    /**
     * 拼装URL
     * @param ip
     * @param msgTypeCd  配置URL
     * @return
     */
    private String assembleURL(String ip,int msgTypeCd) throws MyException {
        if(ip == null){
            //如果IP为空，则默认用配置IP
            String [] ips = Constants.getDefaultIp();
            //TODO 随机取IP,验证IP是否合法
            ip = ips[0];
        }
        if(msgTypeCd == 0){
            throw new MyException("拼装URL错误！msgType不能为0");
        }
        String url = Constants.getMsgTypeToURL().get(msgTypeCd+"");
        if(url == null){
            logger.error("拼装URL错误!msgType = "+msgTypeCd+"，在ConstantsParam类中找不到对应的URL，请检查配置");
        }
        if(!url.startsWith("/")){
            //补充正确的URL
            url = "/" + url;
        }
        StringBuilder sb = new StringBuilder("http://");
        sb.append(ip + ":");
        sb.append(Constants.getDefaultPort());
        sb.append(url);
        //TODO 验证是否是正确的URL格式
        return sb.toString();
    }

    // 使用POST方法发送XML数据
    public String sendXMLDataByPost(String url, String xmlData) throws Exception {
        if (client == null){
            client = HttpClients.createDefault();
        }
        HttpPost post = new HttpPost(url);
        List<BasicNameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("xml", xmlData));
        post.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));
        HttpResponse response = client.execute(post);
        logger.debug(response.toString());
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        return result;
    }
}
