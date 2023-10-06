package com.example.student_management.dto;

public class markDto {
	private Long id;

    private String name;

    private String rollno;
    
    private int english;
    private int hindi;
    private int maths;
    private int science;
    private int social;

    private Long userId;

    private String postedBy; 


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }
    
    public int getHindi() {
        return hindi;
    }

    public void setHindi(int hindi) {
        this.hindi = hindi;
    }
    
    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }
    
    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }
    
    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social= social;
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
}
