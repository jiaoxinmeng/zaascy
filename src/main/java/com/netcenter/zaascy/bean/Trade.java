package com.netcenter.zaascy.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Trade {
    private Long id;

    private String projectNum;

    private Integer projectYear;

    private Long departId;

    private String depart;

    private String projectType;

    private String projectTypeCode;

    private String projectName;

    private String zaasTechType;

    private String zaasCode;

    private String customerDepart;

    private String otherCustomerDepart;

    private String departFullName;

    private String projectPerson;

    private Date startDate;

    private Date endDate;

    private String projectSummary;

    private BigDecimal intentionAmount;

    private String intentionAmountExplain;

    private BigDecimal signAmount;

    private String remarks;

    private Long submiterId;

    private String submiter;

    private Long assessorId;

    private String assessor;

    private Integer submitState;

    private Integer assessState;

    private Date downloadState;

    private Integer joinState;

    private Long operatorId;

    private String operator;

    private Date createDate;

    private Date modifyDate;

    private String otherZaasCode;

    private String oneCode;

    private String attachment;

    private BigDecimal receivedAmount;

    private String attachmentTable;

    public Trade(Long id, String projectNum, Integer projectYear, Long departId, String depart, String projectType, String projectTypeCode, String projectName, String zaasTechType, String zaasCode, String customerDepart, String otherCustomerDepart,String departFullName, String projectPerson, Date startDate, Date endDate, String projectSummary, BigDecimal intentionAmount, String intentionAmountExplain, BigDecimal signAmount, String remarks, Long submiterId, String submiter, Long assessorId, String assessor, Integer submitState, Integer assessState, Date downloadState, Integer joinState, Long operatorId, String operator, Date createDate, Date modifyDate,String oneCode,String attachment,BigDecimal receivedAmount,String attachmentTable) {
        this.id = id;
        this.projectNum = projectNum;
        this.projectYear = projectYear;
        this.departId = departId;
        this.depart = depart;
        this.projectType = projectType;
        this.projectTypeCode = projectTypeCode;
        this.projectName = projectName;
        this.zaasTechType = zaasTechType;
        this.zaasCode = zaasCode;
        this.customerDepart = customerDepart;
        this.otherCustomerDepart = otherCustomerDepart;
        this.departFullName = departFullName;
        this.projectPerson = projectPerson;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectSummary = projectSummary;
        this.intentionAmount = intentionAmount;
        this.intentionAmountExplain = intentionAmountExplain;
        this.signAmount = signAmount;
        this.remarks = remarks;
        this.submiterId = submiterId;
        this.submiter = submiter;
        this.assessorId = assessorId;
        this.assessor = assessor;
        this.submitState = submitState;
        this.assessState = assessState;
        this.downloadState = downloadState;
        this.joinState = joinState;
        this.operatorId = operatorId;
        this.operator = operator;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.oneCode = oneCode;
        this.attachment = attachment;
        this.receivedAmount = receivedAmount;
        this.attachmentTable = attachmentTable;
    }

    public Trade(Long id,String projectName,String zaasCode){
        this.id = id;
        this.projectName = projectName;
        this.zaasCode = zaasCode;
    }

    public Trade() {
        super();
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", projectNum='" + projectNum + '\'' +
                ", projectYear=" + projectYear +
                ", departId='" + departId + '\'' +
                ", depart='" + depart + '\'' +
                ", projectType='" + projectType + '\'' +
                ", projectTypeCode='" + projectTypeCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", zaasTechType='" + zaasTechType + '\'' +
                ", zaasCode='" + zaasCode + '\'' +
                ", customerDepart='" + customerDepart + '\'' +
                ", departFullName='" + departFullName + '\'' +
                ", projectPerson='" + projectPerson + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", projectSummary='" + projectSummary + '\'' +
                ", intentionAmount=" + intentionAmount +
                ", intentionAmountExplain='" + intentionAmountExplain + '\'' +
                ", signAmount=" + signAmount +
                ", remarks='" + remarks + '\'' +
                ", submiterId=" + submiterId +
                ", submiter='" + submiter + '\'' +
                ", assessorId=" + assessorId +
                ", assessor='" + assessor + '\'' +
                ", submitState=" + submitState +
                ", assessState=" + assessState +
                ", downloadState=" + downloadState +
                ", joinState=" + joinState +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum == null ? null : projectNum.trim();
    }

    public Integer getProjectYear() {
        return projectYear;
    }

    public void setProjectYear(Integer projectYear) {
        this.projectYear = projectYear;
    }

    public Long getDepartId() {
        return departId;
    }

    public void setDepartId(Long departId) {
        this.departId = departId;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart == null ? null : depart.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getProjectTypeCode() {
        return projectTypeCode;
    }

    public void setProjectTypeCode(String projectTypeCode) {
        this.projectTypeCode = projectTypeCode == null ? null : projectTypeCode.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getZaasTechType() {
        return zaasTechType;
    }

    public void setZaasTechType(String zaasTechType) {
        this.zaasTechType = zaasTechType == null ? null : zaasTechType.trim();
    }

    public String getZaasCode() {
        return zaasCode;
    }

    public void setZaasCode(String zaasCode) {
        this.zaasCode = zaasCode == null ? null : zaasCode.trim();
    }

    public String getCustomerDepart() {
        return customerDepart;
    }

    public void setCustomerDepart(String customerDepart) {
        this.customerDepart = customerDepart == null ? null : customerDepart.trim();
    }

    public String getDepartFullName() {
        return departFullName;
    }

    public void setDepartFullName(String departFullName) {
        this.departFullName = departFullName == null ? null : departFullName.trim();
    }

    public String getProjectPerson() {
        return projectPerson;
    }

    public void setProjectPerson(String projectPerson) {
        this.projectPerson = projectPerson == null ? null : projectPerson.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectSummary() {
        return projectSummary;
    }

    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary == null ? null : projectSummary.trim();
    }

    public BigDecimal getIntentionAmount() {
        return intentionAmount;
    }

    public void setIntentionAmount(BigDecimal intentionAmount) {
        this.intentionAmount = intentionAmount;
    }

    public String getIntentionAmountExplain() {
        return intentionAmountExplain;
    }

    public void setIntentionAmountExplain(String intentionAmountExplain) {
        this.intentionAmountExplain = intentionAmountExplain == null ? null : intentionAmountExplain.trim();
    }

    public BigDecimal getSignAmount() {
        return signAmount;
    }

    public void setSignAmount(BigDecimal signAmount) {
        this.signAmount = signAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Long getSubmiterId() {
        return submiterId;
    }

    public void setSubmiterId(Long submiterId) {
        this.submiterId = submiterId;
    }

    public String getSubmiter() {
        return submiter;
    }

    public void setSubmiter(String submiter) {
        this.submiter = submiter == null ? null : submiter.trim();
    }

    public Long getAssessorId() {
        return assessorId;
    }

    public void setAssessorId(Long assessorId) {
        this.assessorId = assessorId;
    }

    public String getAssessor() {
        return assessor;
    }

    public void setAssessor(String assessor) {
        this.assessor = assessor == null ? null : assessor.trim();
    }

    public Integer getSubmitState() {
        return submitState;
    }

    public void setSubmitState(Integer submitState) {
        this.submitState = submitState;
    }

    public Integer getAssessState() {
        return assessState;
    }

    public void setAssessState(Integer assessState) {
        this.assessState = assessState;
    }

    public Date getDownloadState() {
        return downloadState;
    }

    public void setDownloadState(Date downloadState) {
        this.downloadState = downloadState;
    }

    public Integer getJoinState() {
        return joinState;
    }

    public void setJoinState(Integer joinState) {
        this.joinState = joinState;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getOtherCustomerDepart() {
        return otherCustomerDepart;
    }

    public void setOtherCustomerDepart(String otherCustomerDepart) {
        this.otherCustomerDepart = otherCustomerDepart;
    }

    public String getOtherZaasCode() {
        return otherZaasCode;
    }

    public void setOtherZaasCode(String otherZaasCode) {
        this.otherZaasCode = otherZaasCode;
    }

    public String getOneCode() {
        return oneCode;
    }

    public void setOneCode(String oneCode) {
        this.oneCode = oneCode;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public BigDecimal getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(BigDecimal receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public String getAttachmentTable() {
        return attachmentTable;
    }

    public void setAttachmentTable(String attachmentTable) {
        this.attachmentTable = attachmentTable;
    }
}