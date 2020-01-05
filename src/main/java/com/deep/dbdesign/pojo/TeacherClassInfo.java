package com.deep.dbdesign.pojo;

/**
 * Created by Deep on 2020/1/1 14:15
 */
public class TeacherClassInfo {

    private String Con; //班级号
    private int Number; //班级人数
    private String Major;//专业
    private String Cname;//课程名称
    private String Ctime;//课程学时
    private String laim;
    private String Catt;//课程属性

    public String getCon() {
        return Con;
    }

    public void setCon(String con) {
        Con = con;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCtime() {
        return Ctime;
    }

    public void setCtime(String ctime) {
        Ctime = ctime;
    }

    public String getLaim() {
        return laim;
    }

    public void setLaim(String laim) {
        this.laim = laim;
    }

    public String getCatt() {
        return Catt;
    }

    public void setCatt(String catt) {
        Catt = catt;
    }
}
