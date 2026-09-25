package com.devshowcase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String comment;

    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}