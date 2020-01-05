package com.deep.dbdesign.pojo;

/**
 * Created by Deep on 2019/12/31 14:47
 */
public class Teacher {
    private String name;
    private String sex;
    private String dept;
    private String degree;
    private String tright;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTright() {
        return tright;
    }

    public void setTright(String tright) {
        this.tright = tright;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", dept='" + dept + '\'' +
                ", degree='" + degree + '\'' +
                ", tright='" + tright + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
