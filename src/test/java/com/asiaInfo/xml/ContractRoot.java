package com.asiaInfo.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by wxwall on 2017/9/11.
 */
@XmlRootElement(name="ContractRoot")
public class ContractRoot{

    private TcpCont tcpCont;
    private String svcCont;

    public ContractRoot(){
        super();
    }

    public ContractRoot(TcpCont tcpCont, String svcCont) {
        super();
        this.tcpCont = tcpCont;
        this.svcCont = svcCont;
    }

    static class TcpCont {
        public TcpCont(){
            super();
        }
        private String actionCode;
        private String transactionID;
        private String rspTime;
        private String response;

        public String getActionCode() {
            return actionCode;
        }

        public void setActionCode(String actionCode) {
            this.actionCode = actionCode;
        }

        public String getTransactionID() {
            return transactionID;
        }

        public void setTransactionID(String transactionID) {
            this.transactionID = transactionID;
        }

        public String getRspTime() {
            return rspTime;
        }

        public void setRspTime(String rspTime) {
            this.rspTime = rspTime;
        }

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }
    }

    static class Response {
        public Response() {
            super();
        }

        private String rspType;
        private String rspCode;
        private String rspDesc;

        public String getRspType() {
            return rspType;
        }

        public void setRspType(String rspType) {
            this.rspType = rspType;
        }

        public String getRspCode() {
            return rspCode;
        }

        public void setRspCode(String rspCode) {
            this.rspCode = rspCode;
        }

        public String getRspDesc() {
            return rspDesc;
        }

        public void setRspDesc(String rspDesc) {
            this.rspDesc = rspDesc;
        }
    }

    public TcpCont getTcpCont() {
        return tcpCont;
    }

    public void setTcpCont(TcpCont tcpCont) {
        this.tcpCont = tcpCont;
    }

    public String getSvcCont() {
        return svcCont;
    }

    public void setSvcCont(String svcCont) {
        this.svcCont = svcCont;
    }
}




