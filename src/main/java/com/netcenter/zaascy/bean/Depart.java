package com.netcenter.zaascy.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Depart {
    private BigDecimal danwId;

    private String danwbh;

    private String danwmc;

    private String jigbzdm;

    private String danwjc;

    private String shifwxcdw;

    private String danwdh;

    private String shuom;

    private String beiz;

    private String shifwdjg;

    private String shifwxtkydw;

    private BigDecimal jilcjz;

    private Date jilcjsj;

    private BigDecimal jilxgz;

    private Date jilxgsj;

    private String paixh;

    public Depart(BigDecimal danwId, String danwbh, String danwmc, String jigbzdm, String danwjc, String shifwxcdw, String danwdh, String shuom, String beiz, String shifwdjg, String shifwxtkydw, BigDecimal jilcjz, Date jilcjsj, BigDecimal jilxgz, Date jilxgsj, String paixh) {
        this.danwId = danwId;
        this.danwbh = danwbh;
        this.danwmc = danwmc;
        this.jigbzdm = jigbzdm;
        this.danwjc = danwjc;
        this.shifwxcdw = shifwxcdw;
        this.danwdh = danwdh;
        this.shuom = shuom;
        this.beiz = beiz;
        this.shifwdjg = shifwdjg;
        this.shifwxtkydw = shifwxtkydw;
        this.jilcjz = jilcjz;
        this.jilcjsj = jilcjsj;
        this.jilxgz = jilxgz;
        this.jilxgsj = jilxgsj;
        this.paixh = paixh;
    }

    public Depart(BigDecimal danwId, String danwbh, String danwmc, String danwjc){
        this.danwId = danwId;
        this.danwbh = danwbh;
        this.danwmc = danwmc;
        this.danwjc = danwjc;
    }

    public Depart() {
        super();
    }

    public BigDecimal getDanwId() {
        return danwId;
    }

    public void setDanwId(BigDecimal danwId) {
        this.danwId = danwId;
    }

    public String getDanwbh() {
        return danwbh;
    }

    public void setDanwbh(String danwbh) {
        this.danwbh = danwbh == null ? null : danwbh.trim();
    }

    public String getDanwmc() {
        return danwmc;
    }

    public void setDanwmc(String danwmc) {
        this.danwmc = danwmc == null ? null : danwmc.trim();
    }

    public String getJigbzdm() {
        return jigbzdm;
    }

    public void setJigbzdm(String jigbzdm) {
        this.jigbzdm = jigbzdm == null ? null : jigbzdm.trim();
    }

    public String getDanwjc() {
        return danwjc;
    }

    public void setDanwjc(String danwjc) {
        this.danwjc = danwjc == null ? null : danwjc.trim();
    }

    public String getShifwxcdw() {
        return shifwxcdw;
    }

    public void setShifwxcdw(String shifwxcdw) {
        this.shifwxcdw = shifwxcdw == null ? null : shifwxcdw.trim();
    }

    public String getDanwdh() {
        return danwdh;
    }

    public void setDanwdh(String danwdh) {
        this.danwdh = danwdh == null ? null : danwdh.trim();
    }

    public String getShuom() {
        return shuom;
    }

    public void setShuom(String shuom) {
        this.shuom = shuom == null ? null : shuom.trim();
    }

    public String getBeiz() {
        return beiz;
    }

    public void setBeiz(String beiz) {
        this.beiz = beiz == null ? null : beiz.trim();
    }

    public String getShifwdjg() {
        return shifwdjg;
    }

    public void setShifwdjg(String shifwdjg) {
        this.shifwdjg = shifwdjg == null ? null : shifwdjg.trim();
    }

    public String getShifwxtkydw() {
        return shifwxtkydw;
    }

    public void setShifwxtkydw(String shifwxtkydw) {
        this.shifwxtkydw = shifwxtkydw == null ? null : shifwxtkydw.trim();
    }

    public BigDecimal getJilcjz() {
        return jilcjz;
    }

    public void setJilcjz(BigDecimal jilcjz) {
        this.jilcjz = jilcjz;
    }

    public Date getJilcjsj() {
        return jilcjsj;
    }

    public void setJilcjsj(Date jilcjsj) {
        this.jilcjsj = jilcjsj;
    }

    public BigDecimal getJilxgz() {
        return jilxgz;
    }

    public void setJilxgz(BigDecimal jilxgz) {
        this.jilxgz = jilxgz;
    }

    public Date getJilxgsj() {
        return jilxgsj;
    }

    public void setJilxgsj(Date jilxgsj) {
        this.jilxgsj = jilxgsj;
    }

    public String getPaixh() {
        return paixh;
    }

    public void setPaixh(String paixh) {
        this.paixh = paixh == null ? null : paixh.trim();
    }
}