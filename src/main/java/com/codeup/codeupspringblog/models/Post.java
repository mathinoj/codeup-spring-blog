package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="posts") //This manually controls what we want to name the table, cuz otherwise it would name it to just 'post'
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 60)
    private String title;

    @Column(nullable = false, length = 500)
    private String body;

    @ManyToOne(cascade = CascadeType.PERSIST) //cuz many posts can be made by one user
    @JoinColumn(name="user_id")
    private User user;

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }
}