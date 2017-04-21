package com.netcenter.zaascy.bean;

public class TradeResource {
    private Long id;

    private String type;

    private String key;

    private String value;

    private Integer sortNum;

    public TradeResource(Long id, String type, String key, String value, Integer sortNum) {
        this.id = id;
        this.type = type;
        this.key = key;
        this.value = value;
        this.sortNum = sortNum;
    }

    public TradeResource() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}