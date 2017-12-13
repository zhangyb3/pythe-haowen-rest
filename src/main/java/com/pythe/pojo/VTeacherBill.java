package com.pythe.pojo;

import java.util.Date;

public class VTeacherBill {
    private Long id;

    private Long teacherOutid;

    private Long studentOutid;

    private Long teacherInid;

    private Long studentInid;

    private Double money;

    private Long objectid;

    private String operationtype;

    private Date operationtime;

    private String payId;

    private String outTradeNo;

    private Integer paid;

    private String username;

    private String userimg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherOutid() {
        return teacherOutid;
    }

    public void setTeacherOutid(Long teacherOutid) {
        this.teacherOutid = teacherOutid;
    }

    public Long getStudentOutid() {
        return studentOutid;
    }

    public void setStudentOutid(Long studentOutid) {
        this.studentOutid = studentOutid;
    }

    public Long getTeacherInid() {
        return teacherInid;
    }

    public void setTeacherInid(Long teacherInid) {
        this.teacherInid = teacherInid;
    }

    public Long getStudentInid() {
        return studentInid;
    }

    public void setStudentInid(Long studentInid) {
        this.studentInid = studentInid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Long getObjectid() {
        return objectid;
    }

    public void setObjectid(Long objectid) {
        this.objectid = objectid;
    }

    public String getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(String operationtype) {
        this.operationtype = operationtype == null ? null : operationtype.trim();
    }

    public Date getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Date operationtime) {
        this.operationtime = operationtime;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg == null ? null : userimg.trim();
    }
}