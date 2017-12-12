package com.pythe.pojo;

public class TblIdentifier {
    private Long id;

    private String miniprogramOpenid;

    private String publicOpenid;

    private String unionid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMiniprogramOpenid() {
        return miniprogramOpenid;
    }

    public void setMiniprogramOpenid(String miniprogramOpenid) {
        this.miniprogramOpenid = miniprogramOpenid == null ? null : miniprogramOpenid.trim();
    }

    public String getPublicOpenid() {
        return publicOpenid;
    }

    public void setPublicOpenid(String publicOpenid) {
        this.publicOpenid = publicOpenid == null ? null : publicOpenid.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }
}