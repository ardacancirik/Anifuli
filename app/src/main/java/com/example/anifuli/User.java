package com.example.anifuli;

public class User {

    String name, username, password, email;


    public User (String name, String email, String username, String password){
        this.name=name;
        this.email=email;
        this.username=username;
        this.password=password;
    }

    public User(String username, String password){
        this.username=username;
        this.password=password;
        this.email="";
        this.name="";
    }


    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", e-mail=" + email +
                '}';
    }
}
