package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name ="ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 256)
    private String title;

    @Column(nullable = false, length = 1024)
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST) //cuz many ads can be made by one user
    @JoinColumn(name="user_id")
    private User user;

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }
}