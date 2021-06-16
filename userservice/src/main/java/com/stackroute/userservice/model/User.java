package com.stackroute.userservice.model;
import javax.persistence.*;
@Entity
@Table(name = "user")
public class User {

    private String username;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;
    private String password;
    public User() {
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
