package com.asiaInfo.http;

import com.asiaInfo.Application;
import com.asiaInfo.core.http.HttpAPIService;
import com.asiaInfo.core.http.HttpResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wxwall on 2017/9/7.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class HttpClientTest {

    @Resource
    private HttpAPIService httpAPIService;

    //@Test
    public void testGet() throws Exception {
        String str = httpAPIService.doGet("http://www.baidu.com");
        System.out.println(str);
    }

    @Test
    public void testPost() throws Exception {
        //压力测试看连接会不会满
        for(int i = 0 ; i < 10; i++){
            String param = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<ContractRoot><TcpCont><BusCode>BUS70002</BusCode><ServiceCode>SVC70052</ServiceCode><ServiceContractVer>SVC7005220130901</ServiceContractVer><ActionCode>0</ActionCode><TransactionID>1000000200201704011337714087</TransactionID><ServiceLevel>1</ServiceLevel><SrcSysID>1000000200</SrcSysID><SrcOrgID>100000</SrcOrgID><SrcSysSign>123</SrcSysSign><DstSysID>1000000200</DstSysID><DstOrgID>100000</DstOrgID><ReqTime>20170401000510</ReqTime></TcpCont><SvcCont><messages><message><msgId>47521503</msgId><msgTypeCd>103</msgTypeCd><commonRegionId>8510000</commonRegionId><msgContent><![CDATA[{\"orderItemGroupIds\":[130523094406],\"businessStatusCd\":\"300000\",\"statusDesc\":\"受理成功成功\",\"stateDate\":\"20170401000459\"}]]></msgContent><sortDt>2017-04-01 00:04:59</sortDt><createDt>2017-04-01 00:04:59</createDt><readDt>2017-04-01 00:05:00</readDt><remark></remark><teamKey>8510000</teamKey></message></messages></SvcCont></ContractRoot>";
            HttpResult str = httpAPIService.doPost("http://localhost:8080/SoWeb/service/intf.soService/updateOrderItemGrpArchiveAndCheck",param);
            System.out.println(str.getBody());
        }

    }
}
