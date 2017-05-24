package com.netcenter.zaascy.bean;

import java.util.Date;

public class TradeMember {
    private Long id;

    private Long projectId;

    private Integer rankNumber;

    private Long userId;

    private String name;

    private Date createDate;

    private Date modifyDate;

    private Long operatorId;

    private String operator;

    public TradeMember(Long id, Long projectId, Integer rankNumber, Long userId, String name, Date createDate, Date modifyDate, Long operatorId, String operator) {
        this.id = id;
        this.projectId = projectId;
        this.rankNumber = rankNumber;
        this.userId = userId;
        this.name = name;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.operatorId = operatorId;
        this.operator = operator;
    }

    public TradeMember() {
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

    public Integer getRankNumber() {
        return rankNumber;
    }

    public void setRankNumber(Integer rankNumber) {
        this.rankNumber = rankNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
}