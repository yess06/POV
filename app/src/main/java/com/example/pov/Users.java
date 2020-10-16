package com.example.pov;

public class Users {
    private String id;
    private String name;
    private String email;
    private String email_verified_at;
    private String password;
    private String remember_token;
    private String created_at;
    private String updated_at;

    public Users(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
