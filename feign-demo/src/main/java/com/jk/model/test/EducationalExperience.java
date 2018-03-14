package com.jk.model.test;

import java.io.Serializable;

public class EducationalExperience implements Serializable {

    private Integer id;

    private Integer userid;

    private String timeInterval;

    private String school;

    private String education;

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

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "EducationalExperience{" +
                "id=" + id +
                ", userid=" + userid +
                ", timeInterval='" + timeInterval + '\'' +
                ", school='" + school + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
