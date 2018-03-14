package com.jk.model;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable{

    private String receiveName;//邮箱接收人
    private String mainTitle;//主题
    private String allinfo;//内容
    private String photo;//附件图片
    private String usertype;//类型
    private String userinfo;//详情
    private String userhobby;//爱好

    private Integer uid;
    private String uname;
    private String loginnumber;
    private String upassword;
    private Integer sex;
    private Integer deptid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String ueditor;
    private String headimg;
    //关联部门
    private String typename;

    //日期
    private  String   udateMin;
    private  String   udateMax;

    private Integer rid;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getLoginnumber() {
        return loginnumber;
    }

    public void setLoginnumber(String loginnumber) {
        this.loginnumber = loginnumber;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getCreateTime() {
        if(createTime==null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(createTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUeditor() {
        return ueditor;
    }

    public void setUeditor(String ueditor) {
        this.ueditor = ueditor;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getUdateMin() {
        return udateMin;
    }

    public void setUdateMin(String udateMin) {
        this.udateMin = udateMin;
    }

    public String getUdateMax() {
        return udateMax;
    }

    public void setUdateMax(String udateMax) {
        this.udateMax = udateMax;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getAllinfo() {
        return allinfo;
    }

    public void setAllinfo(String allinfo) {
        this.allinfo = allinfo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    public String getUserhobby() {
        return userhobby;
    }

    public void setUserhobby(String userhobby) {
        this.userhobby = userhobby;
    }
}
