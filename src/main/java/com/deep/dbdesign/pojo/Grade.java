package com.deep.dbdesign.pojo;

/**
 * Created by Deep on 2020/1/2 16:10
 */
public class Grade {
    private String sno;
    private String sname;
    private String ssex;
    private String sclass;
    private String Cname;
    private String Achievement;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getAchievement() {
        return Achievement;
    }

    public void setAchievement(String achievement) {
        Achievement = achievement;
    }
}
