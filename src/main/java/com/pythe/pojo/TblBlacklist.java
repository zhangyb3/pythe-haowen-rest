package com.pythe.pojo;

import java.util.Date;

public class TblBlacklist {
    private Long blacklistid;

    private Long answerid;

    private Long userid;

    private Date starttime;

    private Long complainedid;

    private Integer status;

    private String reason;

    public Long getBlacklistid() {
        return blacklistid;
    }

    public void setBlacklistid(Long blacklistid) {
        this.blacklistid = blacklistid;
    }

    public Long getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Long answerid) {
        this.answerid = answerid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Long getComplainedid() {
        return complainedid;
    }

    public void setComplainedid(Long complainedid) {
        this.complainedid = complainedid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}