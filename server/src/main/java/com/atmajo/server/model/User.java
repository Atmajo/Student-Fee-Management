package com.atmajo.server.model;

import jakarta.persistence.Entity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_tab")
public class User {

    @Id
    private Long enrollment;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role;
    private Integer semester;
    private Long pending;
    private String password;

    public User(){}

    public User(Long enrollment, String firstName, String lastName, String email, String phone, String role, Integer semester, Long pending, String password) {
        this.enrollment = enrollment;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.semester = semester;
        this.pending = pending;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phoneNo) {
        this.phone = phoneNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Long enrollmentNo) {
        this.enrollment = enrollmentNo;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        semester++;
        this.semester = semester;
    }

    public Long getPending() {
        return pending;
    }

    public void setPending(Long pending) {
        this.pending = pending;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }
}