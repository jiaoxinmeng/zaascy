package com.netcenter.zaascy.bean;

import java.util.Date;

public class Privilege {
    private Long quanxId;

    private String quanxbh;

    private String quanxmc;

    private Long mokId;

    private String shifkxg;

    private Long juesId;

    private String quanxsm;

    private Long jilcjz;

    private Date jilcjsj;

    private Long jilxgz;

    private Date jilxgsj;

    private Long yonghId;

    private Long juesjb;

    public Privilege(Long quanxId, String quanxbh, String quanxmc, Long mokId, String shifkxg, Long juesId, String quanxsm, Long jilcjz, Date jilcjsj, Long jilxgz, Date jilxgsj, Long yonghId, Long juesjb) {
        this.quanxId = quanxId;
        this.quanxbh = quanxbh;
        this.quanxmc = quanxmc;
        this.mokId = mokId;
        this.shifkxg = shifkxg;
        this.juesId = juesId;
        this.quanxsm = quanxsm;
        this.jilcjz = jilcjz;
        this.jilcjsj = jilcjsj;
        this.jilxgz = jilxgz;
        this.jilxgsj = jilxgsj;
        this.yonghId = yonghId;
        this.juesjb = juesjb;
    }

    public Privilege() {
        super();
    }

    public Long getQuanxId() {
        return quanxId;
    }

    public void setQuanxId(Long quanxId) {
        this.quanxId = quanxId;
    }

    public String getQuanxbh() {
        return quanxbh;
    }

    public void setQuanxbh(String quanxbh) {
        this.quanxbh = quanxbh == null ? null : quanxbh.trim();
    }

    public String getQuanxmc() {
        return quanxmc;
    }

    public void setQuanxmc(String quanxmc) {
        this.quanxmc = quanxmc == null ? null : quanxmc.trim();
    }

    public Long getMokId() {
        return mokId;
    }

    public void setMokId(Long mokId) {
        this.mokId = mokId;
    }

    public String getShifkxg() {
        return shifkxg;
    }

    public void setShifkxg(String shifkxg) {
        this.shifkxg = shifkxg == null ? null : shifkxg.trim();
    }

    public Long getJuesId() {
        return juesId;
    }

    public void setJuesId(Long juesId) {
        this.juesId = juesId;
    }

    public String getQuanxsm() {
        return quanxsm;
    }

    public void setQuanxsm(String quanxsm) {
        this.quanxsm = quanxsm == null ? null : quanxsm.trim();
    }

    public Long getJilcjz() {
        return jilcjz;
    }

    public void setJilcjz(Long jilcjz) {
        this.jilcjz = jilcjz;
    }

    public Date getJilcjsj() {
        return jilcjsj;
    }

    public void setJilcjsj(Date jilcjsj) {
        this.jilcjsj = jilcjsj;
    }

    public Long getJilxgz() {
        return jilxgz;
    }

    public void setJilxgz(Long jilxgz) {
        this.jilxgz = jilxgz;
    }

    public Date getJilxgsj() {
        return jilxgsj;
    }

    public void setJilxgsj(Date jilxgsj) {
        this.jilxgsj = jilxgsj;
    }

    public Long getYonghId() {
        return yonghId;
    }

    public void setYonghId(Long yonghId) {
        this.yonghId = yonghId;
    }

    public Long getJuesjb() {
        return juesjb;
    }

    public void setJuesjb(Long juesjb) {
        this.juesjb = juesjb;
    }
}