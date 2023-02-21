package com.myblog.pojo;

import java.util.Date;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/9 18:27
 * @Description:
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date createAt;

    public User() {
    }

    public User(Integer id, String username, String password, Date createAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createAt=" + createAt +
                '}';
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
