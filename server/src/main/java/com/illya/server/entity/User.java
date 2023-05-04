package com.illya.server.entity;

import jakarta.persistence.*;

@Entity // create database
@Table(name = "user") // Create table in db
public class User {
    @Id
    @Column(name="user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "user_name", length = 255)
    private String userName;

    @Column(name="email", length = 255)
    private String email;
    @Column(name = "password", length = 255)
    private String password;

}
