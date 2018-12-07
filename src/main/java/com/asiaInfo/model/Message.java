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

	private String ip;

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


	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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
				", ip='" + ip + '\'' +
				'}';
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Message message = (Message) o;

		if (msgId != null ? !msgId.equals(message.msgId) : message.msgId != null) return false;
		if (msgTypeCd != null ? !msgTypeCd.equals(message.msgTypeCd) : message.msgTypeCd != null) return false;
		if (msgContent != null ? !msgContent.equals(message.msgContent) : message.msgContent != null) return false;
		if (grpId != null ? !grpId.equals(message.grpId) : message.grpId != null) return false;
		if (grpSeq != null ? !grpSeq.equals(message.grpSeq) : message.grpSeq != null) return false;
		if (grpTotal != null ? !grpTotal.equals(message.grpTotal) : message.grpTotal != null) return false;
		if (grpOver != null ? !grpOver.equals(message.grpOver) : message.grpOver != null) return false;
		if (sortDt != null ? !sortDt.equals(message.sortDt) : message.sortDt != null) return false;
		if (commonRegionId != null ? !commonRegionId.equals(message.commonRegionId) : message.commonRegionId != null)
			return false;
		if (dealFlag != null ? !dealFlag.equals(message.dealFlag) : message.dealFlag != null) return false;
		if (createDt != null ? !createDt.equals(message.createDt) : message.createDt != null) return false;
		if (readDt != null ? !readDt.equals(message.readDt) : message.readDt != null) return false;
		if (modifyDt != null ? !modifyDt.equals(message.modifyDt) : message.modifyDt != null) return false;
		if (finishDt != null ? !finishDt.equals(message.finishDt) : message.finishDt != null) return false;
		if (remark != null ? !remark.equals(message.remark) : message.remark != null) return false;
		if (busiDesc != null ? !busiDesc.equals(message.busiDesc) : message.busiDesc != null) return false;
		if (listenerDesc != null ? !listenerDesc.equals(message.listenerDesc) : message.listenerDesc != null)
			return false;
		if (param1 != null ? !param1.equals(message.param1) : message.param1 != null) return false;
		if (param2 != null ? !param2.equals(message.param2) : message.param2 != null) return false;
		if (param3 != null ? !param3.equals(message.param3) : message.param3 != null) return false;
		if (batchNum != null ? !batchNum.equals(message.batchNum) : message.batchNum != null) return false;
		if (teamKey != null ? !teamKey.equals(message.teamKey) : message.teamKey != null) return false;
		return ip != null ? ip.equals(message.ip) : message.ip == null;
	}

	@Override
	public int hashCode() {
		int result = msgId != null ? msgId.hashCode() : 0;
		result = 31 * result + (msgTypeCd != null ? msgTypeCd.hashCode() : 0);
		result = 31 * result + (msgContent != null ? msgContent.hashCode() : 0);
		result = 31 * result + (grpId != null ? grpId.hashCode() : 0);
		result = 31 * result + (grpSeq != null ? grpSeq.hashCode() : 0);
		result = 31 * result + (grpTotal != null ? grpTotal.hashCode() : 0);
		result = 31 * result + (grpOver != null ? grpOver.hashCode() : 0);
		result = 31 * result + (sortDt != null ? sortDt.hashCode() : 0);
		result = 31 * result + (commonRegionId != null ? commonRegionId.hashCode() : 0);
		result = 31 * result + (dealFlag != null ? dealFlag.hashCode() : 0);
		result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
		result = 31 * result + (readDt != null ? readDt.hashCode() : 0);
		result = 31 * result + (modifyDt != null ? modifyDt.hashCode() : 0);
		result = 31 * result + (finishDt != null ? finishDt.hashCode() : 0);
		result = 31 * result + (remark != null ? remark.hashCode() : 0);
		result = 31 * result + (busiDesc != null ? busiDesc.hashCode() : 0);
		result = 31 * result + (listenerDesc != null ? listenerDesc.hashCode() : 0);
		result = 31 * result + (param1 != null ? param1.hashCode() : 0);
		result = 31 * result + (param2 != null ? param2.hashCode() : 0);
		result = 31 * result + (param3 != null ? param3.hashCode() : 0);
		result = 31 * result + (batchNum != null ? batchNum.hashCode() : 0);
		result = 31 * result + (teamKey != null ? teamKey.hashCode() : 0);
		result = 31 * result + (ip != null ? ip.hashCode() : 0);
		return result;
	}
}
