package com.netcenter.zaascy.bean;

import java.math.BigDecimal;

public class RoleRelationKey {
    private Long yonghId;

    private Long juesId;

    public RoleRelationKey(Long yonghId, Long juesId) {
        this.yonghId = yonghId;
        this.juesId = juesId;
    }

    public RoleRelationKey() {
        super();
    }

    public Long getYonghId() {
        return yonghId;
    }

    public void setYonghId(Long yonghId) {
        this.yonghId = yonghId;
    }

    public Long getJuesId() {
        return juesId;
    }

    public void setJuesId(Long juesId) {
        this.juesId = juesId;
    }
}