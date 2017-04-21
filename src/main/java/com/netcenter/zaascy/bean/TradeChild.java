package com.netcenter.zaascy.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TradeChild {
    private Long id;

    private Integer year;

    private String projectNumber;

    private String sampleNumber;

    private String sampleName;

    private String provideUnit;

    private Date acceptDate;

    private Date reportDate;

    private BigDecimal amount;

    private String manager;

    private Integer operatorId;

    private Integer operator;

    private Date createDate;

    private Date modifyDate;

    private String quarter;

    private String remarks;

    public TradeChild(Long id, Integer year, String projectNumber, String sampleNumber, String sampleName, String provideUnit, Date acceptDate, Date reportDate, BigDecimal amount, String manager, Integer operatorId, Integer operator, Date createDate, Date modifyDate, String quarter, String remarks) {
        this.id = id;
        this.year = year;
        this.projectNumber = projectNumber;
        this.sampleNumber = sampleNumber;
        this.sampleName = sampleName;
        this.provideUnit = provideUnit;
        this.acceptDate = acceptDate;
        this.reportDate = reportDate;
        this.amount = amount;
        this.manager = manager;
        this.operatorId = operatorId;
        this.operator = operator;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.quarter = quarter;
        this.remarks = remarks;
    }

    public TradeChild() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber == null ? null : projectNumber.trim();
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber == null ? null : sampleNumber.trim();
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName == null ? null : sampleName.trim();
    }

    public String getProvideUnit() {
        return provideUnit;
    }

    public void setProvideUnit(String provideUnit) {
        this.provideUnit = provideUnit == null ? null : provideUnit.trim();
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
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

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter == null ? null : quarter.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}