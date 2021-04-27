package com.cs.assignment2.Models;

public class SecondInfo {

    private String experience;
    private String GPA;
    private String linkedin;
    private String skill;

    public SecondInfo() {
    }

    public SecondInfo(String experience, String GPA, String linkedin, String skill) {

        this.experience=experience;
        this.GPA=GPA;
        this.linkedin=linkedin;
        this.skill=skill;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience= experience;
    }

    public String getGPA() {
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
