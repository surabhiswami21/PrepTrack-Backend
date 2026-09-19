package com.preptrack.preptrack_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"subject_id", "name"}))
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Subject subject;

    @Column(nullable = false)
    private String name;
    @Column(length = 2000)
    private String description;
    private String sourceType;
}
