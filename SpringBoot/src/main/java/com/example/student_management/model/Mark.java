package com.example.student_management.model;
import com.example.student_management.dto.markDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "mark")
public class Mark {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String rollno;
    private int english;
    private int hindi;
    private int maths;
    private int science;
    private int social;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public markDto getmarkDto(){
    	markDto MarkDto = new markDto();
    	MarkDto.setId(id);
    	MarkDto.setName(name);
    	MarkDto.setRollno(rollno);
    	MarkDto.setEnglish(english);
    	MarkDto.setHindi(hindi);
    	MarkDto.setMaths(maths);
    	MarkDto.setScience(science);
    	MarkDto.setSocial(social);
    	MarkDto.setUserId(user.getId());
    	MarkDto.setPostedBy(user.getName());
        return MarkDto;
    }
}
