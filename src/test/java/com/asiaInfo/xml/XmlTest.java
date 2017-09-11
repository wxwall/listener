package com.asiaInfo.xml;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by wxwall on 2017/9/11.
 */
public class XmlTest {

    @Test
    public void XMLStringToBean(){
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>22</age><classroom><grade>4</grade><id>1</id><name>软件工程</name></classroom><id>101</id><name>张三</name></student>";
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Student student = (Student)unmarshaller.unmarshal(new StringReader(xmlStr));
            System.out.println(student.getAge());
            System.out.println(student.getClassroom().getName());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void xmlToBean(){
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ContractRoot><TcpCont><ActionCode>1</ActionCode><TransactionID>1000000200201704011337714087</TransactionID><RspTime>20170909101423</RspTime><Response><RspType>0</RspType><RspCode>0000</RspCode><RspDesc><![CDATA[成功]]></RspDesc></Response></TcpCont><SvcCont><![CDATA[<results><result><resultCd>-1</resultCd><msgId>47521503</msgId><msg>{\"resultCode\":\"-1\",\"resultMsg\":\"根据订单项分组竣工订单项出错_读取订单分组数据，进行订单归档异常！订单项分组ID【130523094406】不存在的订单项分组！不存在的订单项分组！\",\"errCode\":-90000,\"errorStack\":\"class com.al.common.exception.BaseException: 读取订单分组数据，进行订单归档异常！订单项分组ID【130523094406】不存在的订单项分组！\"}</msg></result></results>]]></SvcCont></ContractRoot>\n";
        //xmlStr = xmlStr.toLowerCase();
        //System.out.println(xmlStr);
        try {
            JAXBContext context = JAXBContext.newInstance(ContractRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ContractRoot contractRoot = (ContractRoot)unmarshaller.unmarshal(new StringReader(xmlStr));
            System.out.println(contractRoot.getSvcCont());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
