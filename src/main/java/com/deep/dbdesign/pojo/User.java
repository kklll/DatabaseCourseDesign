package com.deep.dbdesign.pojo;

/**
 * @author DeepBlue
 * @date 2019/10/31  15:09
 */
public class User {
    private long id;
    private String identity;
    private String username;
    private String password;


    public User() {
    }

    public User(String identity, String username, String password) {
        this.identity = identity;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
