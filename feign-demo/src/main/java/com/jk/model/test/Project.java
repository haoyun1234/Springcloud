package com.jk.model.test;

import java.io.Serializable;

public class Project implements Serializable {
    private Integer id;

    private Integer userid;

    private String stringnumber;

    private String title;

    private String developmentenvironment;

    private String projectframework;

    private String projestdescribe;

    private String responsibilitydescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getStringnumber() {
        return stringnumber;
    }

    public void setStringnumber(String stringnumber) {
        this.stringnumber = stringnumber == null ? null : stringnumber.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDevelopmentenvironment() {
        return developmentenvironment;
    }

    public void setDevelopmentenvironment(String developmentenvironment) {
        this.developmentenvironment = developmentenvironment == null ? null : developmentenvironment.trim();
    }

    public String getProjectframework() {
        return projectframework;
    }

    public void setProjectframework(String projectframework) {
        this.projectframework = projectframework == null ? null : projectframework.trim();
    }

    public String getProjestdescribe() {
        return projestdescribe;
    }

    public void setProjestdescribe(String projestdescribe) {
        this.projestdescribe = projestdescribe == null ? null : projestdescribe.trim();
    }

    public String getResponsibilitydescription() {
        return responsibilitydescription;
    }

    public void setResponsibilitydescription(String responsibilitydescription) {
        this.responsibilitydescription = responsibilitydescription == null ? null : responsibilitydescription.trim();
    }
}