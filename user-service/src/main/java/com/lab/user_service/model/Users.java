package com.lab.user_service.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    public enum Role{
        STUDENT,
        TEACHER,
        ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String studentId;
    @ElementCollection
    @CollectionTable(name = "student_classes", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "class_id")
    private List<String> enrolledClasses;

    private String teacher;

    @ElementCollection
    @CollectionTable(name = "teacher_classes", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "class_id")
    private List<String> assignedClasses;

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getTeacher() {
        return teacher;
    }

    public List<String> getEnrolledClasses() {
        return enrolledClasses;
    }

    public List<String> getAssignedClasses() {
        return assignedClasses;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setEnrolledClasses(List<String> enrolledClasses) {
        this.enrolledClasses = enrolledClasses;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setAssignedClasses(List<String> assignedClasses) {
        this.assignedClasses = assignedClasses;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", studentId='" + studentId + '\'' +
                ", enrolledClasses=" + enrolledClasses +
                ", teacher='" + teacher + '\'' +
                ", assignedClasses=" + assignedClasses +
                '}';
    }
}
