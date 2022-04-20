package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "userIdno")
    private String userIdno;

    @Column(name = "sharerIdno")
    private String sharerIdno;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserIdno() {
        return userIdno;
    }

    public void setUserIdno(String userIdno) {
        this.userIdno = userIdno;
    }

    public String getSharerIdno() {
        return sharerIdno;
    }

    public void setSharerIdno(String sharerIdno) {
        this.sharerIdno = sharerIdno;
    }
}
