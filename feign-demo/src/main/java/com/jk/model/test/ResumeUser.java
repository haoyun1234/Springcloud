package com.jk.model.test;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResumeUser implements Serializable {
    private Integer id;

    private String name;

    private Date crdate;

    private Integer age;

    private String education;

    private Integer sex;

    private String address;

    private String workinglife;

    private String specialties;

    private String mail;

    private String natureofwork;

    private String targetposition;

    private String salaryexpectation;

    private String workaddress;

    private String mobilephone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCrdate() {


        String format = null;
        if (crdate!=null){
            format = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            format = sdf.format(crdate);
        }
        return format;
    }

    public void setCrdate(Date crdate) {
        this.crdate = crdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getSex() {
        String sexStr = "";
        /*sex%2 >0? sexStr="男":sexStr="女";*/
        if (sex%2 >0){sexStr="男";}else {sexStr="女";}
        return sexStr;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getWorkinglife() {
        return workinglife;
    }

    public void setWorkinglife(String workinglife) {
        this.workinglife = workinglife == null ? null : workinglife.trim();
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties == null ? null : specialties.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getNatureofwork() {
        return natureofwork;
    }

    public void setNatureofwork(String natureofwork) {
        this.natureofwork = natureofwork == null ? null : natureofwork.trim();
    }

    public String getTargetposition() {
        return targetposition;
    }

    public void setTargetposition(String targetposition) {
        this.targetposition = targetposition == null ? null : targetposition.trim();
    }

    public String getSalaryexpectation() {
        return salaryexpectation;
    }

    public void setSalaryexpectation(String salaryexpectation) {
        this.salaryexpectation = salaryexpectation == null ? null : salaryexpectation.trim();
    }

    public String getWorkaddress() {
        return workaddress;
    }

    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress == null ? null : workaddress.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
}