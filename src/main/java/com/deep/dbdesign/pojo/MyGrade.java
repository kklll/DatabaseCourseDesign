package com.deep.dbdesign.pojo;

/**
 * Created by Deep on 2020/1/3 16:38
 */
public class MyGrade {
    private String Sno;
    private String Cname;
    private String Ctime;
    private String laim;
    private String Catt;
    private String Achievement;

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
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

    public String getAchievement() {
        return Achievement;
    }

    public void setAchievement(String achievement) {
        Achievement = achievement;
    }
}
