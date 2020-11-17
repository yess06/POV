package com.example.pov;

public class Qualifications {
    private String id;
    private String name;
    private String email;
    private String lesson_id;
    private String qualification;

    public Qualifications(String name, String email, String lesson_id, String qualification){
        this.name = name;
        this.email = email;
        this.lesson_id = lesson_id;
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public String getLesson_id() {
        return lesson_id;
    }

    public String getQualification() {
        return qualification;
    }

    public String getEmail() {
        return email;
    }
}
