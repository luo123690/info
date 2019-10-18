package com.six.info.entity;


import java.util.Date;

/**
 * Created by Cookie on 2019/1/23.
 */
public class User {

//    role,username,password,mobile,email,avatar,sex,area,description,expertstag,expertstitle,expertsintro
    private Integer id;
    private String username;
    private String name;
    private String password;
    private String tel;
    private String indentify;
    private String avatar;
    private String address;
    private String sex;
    private String oldPassword;
    private int news;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIndentify() {
        return indentify;
    }

    public void setIndentify(String indentify) {
        this.indentify = indentify;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public int getNews() {
        return news;
    }

    public void setNews(int news) {
        this.news = news;
    }
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", nickname='" + nickname + '\'' +
//                ", name='" + name + '\'' +
//                ", role=" + role +
//                ", password='" + password + '\'' +
//                ", mobile='" + mobile + '\'' +
//                ", email='" + email + '\'' +
//                ", avatar='" + avatar + '\'' +
//                ", sex='" + sex + '\'' +
//                ", area='" + area + '\'' +
//                ", description='" + description + '\'' +
//                ", expertstag='" + expertstag + '\'' +
//                ", expertstitle='" + expertstitle + '\'' +
//                ", expertsintro='" + expertsintro + '\'' +
//                ", research='" + research + '\'' +
//                ", expertslevel='" + expertslevel + '\'' +
//                ", expertstype='" + expertstype + '\'' +
//                ", expertsachievement='" + expertsachievement + '\'' +
//                ", classification='" + classification + '\'' +
//                ", oldPassword='" + oldPassword + '\'' +
//                ", news=" + news +
//                ", state=" + state +
//                ", level=" + level +
//                ", bp=" + bp +
//                ", hits=" + hits +
//                ", createTime=" + createTime +
//                ", updateTime=" + updateTime +
//                ", deleteTime=" + deleteTime +
//                '}';
//    }
}
