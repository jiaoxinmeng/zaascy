package com.netcenter.zaascy.bean;

import java.util.Date;

public class TradeSubsidiary {
    private Long id;

    private Long projectId;

    private String zaasTechType;

    private String zaasCode;

    private String operator;

    private Long operatorId;

    private Date createDate;

    private Date modifyDate;

    public TradeSubsidiary(Long id, Long projectId, String zaasTechType, String zaasCode, String operator, Long operatorId, Date createDate, Date modifyDate) {
        this.id = id;
        this.projectId = projectId;
        this.zaasTechType = zaasTechType;
        this.zaasCode = zaasCode;
        this.operator = operator;
        this.operatorId = operatorId;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public TradeSubsidiary() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
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
}