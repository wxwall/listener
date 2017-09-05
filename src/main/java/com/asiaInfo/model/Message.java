package com.asiaInfo.model;

import java.io.Serializable;
import java.util.Date;


/**
 * 侦听消息
 */
public class Message extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5630039750356666774L;

	private Long msgId;

	private Integer msgTypeCd;

	private String msgContent;

	private Long grpId;

	private Integer grpSeq;

	private Integer grpTotal;

	private String grpOver;

	private Date sortDt;

	private Long commonRegionId;

	private String dealFlag;

	private Date createDt;

	private Date readDt;

	private Date modifyDt;

	private Date finishDt;

	private String remark;

	private String busiDesc;

	private String listenerDesc;

	private String param1;

	private String param2;

	private String param3;

	private String batchNum;

	private String teamKey;

	public Message() {

	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public Integer getMsgTypeCd() {
		return msgTypeCd;
	}

	public void setMsgTypeCd(Integer msgTypeCd) {
		this.msgTypeCd = msgTypeCd;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Long getGrpId() {
		return grpId;
	}

	public void setGrpId(Long grpId) {
		this.grpId = grpId;
	}

	public Integer getGrpSeq() {
		return grpSeq;
	}

	public void setGrpSeq(Integer grpSeq) {
		this.grpSeq = grpSeq;
	}

	public Integer getGrpTotal() {
		return grpTotal;
	}

	public void setGrpTotal(Integer grpTotal) {
		this.grpTotal = grpTotal;
	}

	public String getGrpOver() {
		return grpOver;
	}

	public void setGrpOver(String grpOver) {
		this.grpOver = grpOver;
	}

	public Date getSortDt() {
		return sortDt;
	}

	public void setSortDt(Date processDt) {
		this.sortDt = processDt;
	}

	public Long getCommonRegionId() {
		return commonRegionId;
	}

	public void setCommonRegionId(Long commonRegionId) {
		this.commonRegionId = commonRegionId;
	}

	public String getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getReadDt() {
		return readDt;
	}

	public void setReadDt(Date readDt) {
		this.readDt = readDt;
	}

	public Date getModifyDt() {
		return modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public Date getFinishDt() {
		return finishDt;
	}

	public void setFinishDt(Date finishDt) {
		this.finishDt = finishDt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBusiDesc() {
		return busiDesc;
	}

	public void setBusiDesc(String busiDesc) {
		this.busiDesc = busiDesc;
	}

	public String getListenerDesc() {
		return listenerDesc;
	}

	public void setListenerDesc(String listenerDesc) {
		this.listenerDesc = listenerDesc;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public String getTeamKey() {
		return teamKey;
	}

	public void setTeamKey(String teamKey) {
		this.teamKey = teamKey;
	}


	@Override
	public String toString() {
		return "Message{" +
				"msgId=" + msgId +
				", msgTypeCd=" + msgTypeCd +
				", msgContent='" + msgContent + '\'' +
				", grpId=" + grpId +
				", grpSeq=" + grpSeq +
				", grpTotal=" + grpTotal +
				", grpOver='" + grpOver + '\'' +
				", sortDt=" + sortDt +
				", commonRegionId=" + commonRegionId +
				", dealFlag='" + dealFlag + '\'' +
				", createDt=" + createDt +
				", readDt=" + readDt +
				", modifyDt=" + modifyDt +
				", finishDt=" + finishDt +
				", remark='" + remark + '\'' +
				", busiDesc='" + busiDesc + '\'' +
				", listenerDesc='" + listenerDesc + '\'' +
				", param1='" + param1 + '\'' +
				", param2='" + param2 + '\'' +
				", param3='" + param3 + '\'' +
				", batchNum='" + batchNum + '\'' +
				", teamKey='" + teamKey + '\'' +
				'}';
	}
}
