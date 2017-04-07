package com.netcenter.zaascy.bean;

import java.util.Date;

public class TradeMember {
    private Long id;

    private Integer projectId;

    private Integer rankNumber;

    private Integer userId;

    private String name;

    private Date createDate;

    private Date modifyDate;

    private Integer operatorId;

    private String operator;

    public TradeMember(Long id, Integer projectId, Integer rankNumber, Integer userId, String name, Date createDate, Date modifyDate, Integer operatorId, String operator) {
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getRankNumber() {
        return rankNumber;
    }

    public void setRankNumber(Integer rankNumber) {
        this.rankNumber = rankNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}