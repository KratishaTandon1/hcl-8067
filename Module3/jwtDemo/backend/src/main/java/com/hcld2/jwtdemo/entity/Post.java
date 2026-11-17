package com.hcld2.jwtdemo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;


@Entity 
@Getter 
@NoArgsConstructor 
@AllArgsConstructor 
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column (nullable=false)
    private String title;
    @Column (nullable=false)
    private String content;
    @Column (nullable=false)
    private String author;
    private LocalDateTime createdAt=LocalDateTime.now();
}
