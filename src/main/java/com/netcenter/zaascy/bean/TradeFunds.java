package com.netcenter.zaascy.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TradeFunds {
    private Long id;

    private Long projectId;

    private Integer year;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String depart;

    private BigDecimal funds;

    private Long operatorId;

    private String operator;

    private Date createDate;

    private Date modifyDate;

    private String remarks = " ";

    public TradeFunds(Long id, Long projectId, Integer year, Date date, String depart, BigDecimal funds, Long operatorId, String operator, Date createDate, Date modifyDate, String remarks) {
        this.id = id;
        this.projectId = projectId;
        this.year = year;
        this.date = date;
        this.depart = depart;
        this.funds = funds;
        this.operatorId = operatorId;
        this.operator = operator;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.remarks = remarks;
    }

    public TradeFunds() {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public void setFunds(BigDecimal funds) {
        this.funds = funds;
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
        this.operator = operator == null ? null : operator.trim();
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}