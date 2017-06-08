package com.netcenter.zaascy.bean;

/**
 * Created by Administrator on 2017/5/29.
 */
public class ChartsDemo {
    private String depart;
    private Integer count;
    private String type;
    private String typeCode;

    @Override
    public String toString() {
        return "ChartsDemo{" +
                "depart='" + depart + '\'' +
                ", count=" + count +
                ", type='" + type + '\'' +
                ", typeCode='" + typeCode + '\'' +
                '}';
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
