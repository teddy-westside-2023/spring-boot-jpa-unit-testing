package com.hungrybird.springbootcaching2.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="airport")
    private String airport;
//    @CreationTimestamp
    @Column(name="created_at")
    private String createdAt;
//    @CreationTimestamp
    @Column(name="updated_at")
    private Date updatedAt;

//    @PrePersist
//    protected void onCreate() {
//        createdAt = new Date();
//    }
//
//    @PreUpdate
//    @CreationTimestamp
//    protected void onUpdate() {
//        updatedAt = new Date();
//    }
}
