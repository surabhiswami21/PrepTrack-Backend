package com.preptrack.preptrack_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PreparationQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Topic topic;

    @Column(length = 4000, nullable = false)
    private String questionText;
    @Column(length = 8000)
    private String answer;
    @Column(length = 8000)
    private String explanation;
    private String questionType;
    private String difficulty;
    private String sourceType;
}
