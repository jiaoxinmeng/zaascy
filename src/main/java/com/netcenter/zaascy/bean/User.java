package com.netcenter.zaascy.bean;

import java.util.Date;

public class User {
    private Long yonghId;

    private String denglm;

    private String mim;

    private Long xitmk;

    private Long renyId;

    private Long jilcjz;

    private Date jilcjsj;

    private Long jilxgz;

    private Date jilxgsj;

    private Integer boshihId;

    private Integer yanjiusId;

    private Integer linshiryId;

    private Integer laowupqryId;

    private Integer shenhezt;

    private Integer renyLx;

    private String shenfenz;

    private String xingm;

    private String tijzt;

    private String shenhzt;

    private String jiaoyzt;

    private String tijr;

    private String shenhr;

    private String jiaoyr;

    private Long tijrId;

    private Long shenhrId;

    private Long jiaoyrId;

    private String zhaop;

    private Integer shifouyx;

    private Date youxiaoq;

    private String shouj;

    private String email;

    private Long danwId;

    public User(Long yonghId, String denglm, String mim, Long xitmk, Long renyId, Long jilcjz, Date jilcjsj, Long jilxgz, Date jilxgsj, Integer boshihId, Integer yanjiusId, Integer linshiryId, Integer laowupqryId, Integer shenhezt, Integer renyLx, String shenfenz, String xingm, String tijzt, String shenhzt, String jiaoyzt, String tijr, String shenhr, String jiaoyr, Long tijrId, Long shenhrId, Long jiaoyrId, String zhaop, Integer shifouyx, Date youxiaoq, String shouj, String email, Long danwId) {
        this.yonghId = yonghId;
        this.denglm = denglm;
        this.mim = mim;
        this.xitmk = xitmk;
        this.renyId = renyId;
        this.jilcjz = jilcjz;
        this.jilcjsj = jilcjsj;
        this.jilxgz = jilxgz;
        this.jilxgsj = jilxgsj;
        this.boshihId = boshihId;
        this.yanjiusId = yanjiusId;
        this.linshiryId = linshiryId;
        this.laowupqryId = laowupqryId;
        this.shenhezt = shenhezt;
        this.renyLx = renyLx;
        this.shenfenz = shenfenz;
        this.xingm = xingm;
        this.tijzt = tijzt;
        this.shenhzt = shenhzt;
        this.jiaoyzt = jiaoyzt;
        this.tijr = tijr;
        this.shenhr = shenhr;
        this.jiaoyr = jiaoyr;
        this.tijrId = tijrId;
        this.shenhrId = shenhrId;
        this.jiaoyrId = jiaoyrId;
        this.zhaop = zhaop;
        this.shifouyx = shifouyx;
        this.youxiaoq = youxiaoq;
        this.shouj = shouj;
        this.email = email;
        this.danwId = danwId;
    }

    @Override
    public String toString() {
        return "User{" +
                "yonghId=" + yonghId +
                ", denglm='" + denglm + '\'' +
                ", mim='" + mim + '\'' +
                ", xitmk=" + xitmk +
                ", renyId=" + renyId +
                ", jilcjz=" + jilcjz +
                ", jilcjsj=" + jilcjsj +
                ", jilxgz=" + jilxgz +
                ", jilxgsj=" + jilxgsj +
                ", boshihId=" + boshihId +
                ", yanjiusId=" + yanjiusId +
                ", linshiryId=" + linshiryId +
                ", laowupqryId=" + laowupqryId +
                ", shenhezt=" + shenhezt +
                ", renyLx=" + renyLx +
                ", shenfenz='" + shenfenz + '\'' +
                ", xingm='" + xingm + '\'' +
                ", tijzt='" + tijzt + '\'' +
                ", shenhzt='" + shenhzt + '\'' +
                ", jiaoyzt='" + jiaoyzt + '\'' +
                ", tijr='" + tijr + '\'' +
                ", shenhr='" + shenhr + '\'' +
                ", jiaoyr='" + jiaoyr + '\'' +
                ", tijrId=" + tijrId +
                ", shenhrId=" + shenhrId +
                ", jiaoyrId=" + jiaoyrId +
                ", zhaop='" + zhaop + '\'' +
                ", shifouyx=" + shifouyx +
                ", youxiaoq=" + youxiaoq +
                ", shouj='" + shouj + '\'' +
                ", email='" + email + '\'' +
                ", danwId=" + danwId +
                '}';
    }

    public User() {
        super();
    }

    public Long getYonghId() {
        return yonghId;
    }

    public void setYonghId(Long yonghId) {
        this.yonghId = yonghId;
    }

    public String getDenglm() {
        return denglm;
    }

    public void setDenglm(String denglm) {
        this.denglm = denglm == null ? null : denglm.trim();
    }

    public String getMim() {
        return mim;
    }

    public void setMim(String mim) {
        this.mim = mim == null ? null : mim.trim();
    }

    public Long getXitmk() {
        return xitmk;
    }

    public void setXitmk(Long xitmk) {
        this.xitmk = xitmk;
    }

    public Long getRenyId() {
        return renyId;
    }

    public void setRenyId(Long renyId) {
        this.renyId = renyId;
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

    public Integer getBoshihId() {
        return boshihId;
    }

    public void setBoshihId(Integer boshihId) {
        this.boshihId = boshihId;
    }

    public Integer getYanjiusId() {
        return yanjiusId;
    }

    public void setYanjiusId(Integer yanjiusId) {
        this.yanjiusId = yanjiusId;
    }

    public Integer getLinshiryId() {
        return linshiryId;
    }

    public void setLinshiryId(Integer linshiryId) {
        this.linshiryId = linshiryId;
    }

    public Integer getLaowupqryId() {
        return laowupqryId;
    }

    public void setLaowupqryId(Integer laowupqryId) {
        this.laowupqryId = laowupqryId;
    }

    public Integer getShenhezt() {
        return shenhezt;
    }

    public void setShenhezt(Integer shenhezt) {
        this.shenhezt = shenhezt;
    }

    public Integer getRenyLx() {
        return renyLx;
    }

    public void setRenyLx(Integer renyLx) {
        this.renyLx = renyLx;
    }

    public String getShenfenz() {
        return shenfenz;
    }

    public void setShenfenz(String shenfenz) {
        this.shenfenz = shenfenz == null ? null : shenfenz.trim();
    }

    public String getXingm() {
        return xingm;
    }

    public void setXingm(String xingm) {
        this.xingm = xingm == null ? null : xingm.trim();
    }

    public String getTijzt() {
        return tijzt;
    }

    public void setTijzt(String tijzt) {
        this.tijzt = tijzt == null ? null : tijzt.trim();
    }

    public String getShenhzt() {
        return shenhzt;
    }

    public void setShenhzt(String shenhzt) {
        this.shenhzt = shenhzt == null ? null : shenhzt.trim();
    }

    public String getJiaoyzt() {
        return jiaoyzt;
    }

    public void setJiaoyzt(String jiaoyzt) {
        this.jiaoyzt = jiaoyzt == null ? null : jiaoyzt.trim();
    }

    public String getTijr() {
        return tijr;
    }

    public void setTijr(String tijr) {
        this.tijr = tijr == null ? null : tijr.trim();
    }

    public String getShenhr() {
        return shenhr;
    }

    public void setShenhr(String shenhr) {
        this.shenhr = shenhr == null ? null : shenhr.trim();
    }

    public String getJiaoyr() {
        return jiaoyr;
    }

    public void setJiaoyr(String jiaoyr) {
        this.jiaoyr = jiaoyr == null ? null : jiaoyr.trim();
    }

    public Long getTijrId() {
        return tijrId;
    }

    public void setTijrId(Long tijrId) {
        this.tijrId = tijrId;
    }

    public Long getShenhrId() {
        return shenhrId;
    }

    public void setShenhrId(Long shenhrId) {
        this.shenhrId = shenhrId;
    }

    public Long getJiaoyrId() {
        return jiaoyrId;
    }

    public void setJiaoyrId(Long jiaoyrId) {
        this.jiaoyrId = jiaoyrId;
    }

    public String getZhaop() {
        return zhaop;
    }

    public void setZhaop(String zhaop) {
        this.zhaop = zhaop == null ? null : zhaop.trim();
    }

    public Integer getShifouyx() {
        return shifouyx;
    }

    public void setShifouyx(Integer shifouyx) {
        this.shifouyx = shifouyx;
    }

    public Date getYouxiaoq() {
        return youxiaoq;
    }

    public void setYouxiaoq(Date youxiaoq) {
        this.youxiaoq = youxiaoq;
    }

    public String getShouj() {
        return shouj;
    }

    public void setShouj(String shouj) {
        this.shouj = shouj == null ? null : shouj.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getDanwId() {
        return danwId;
    }

    public void setDanwId(Long danwId) {
        this.danwId = danwId;
    }
}