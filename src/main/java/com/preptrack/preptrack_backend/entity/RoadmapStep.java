package com.preptrack.preptrack_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RoadmapStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private CompanyRoadmap roadmap;

    private int sequenceNumber;
    private String phase;
    private String weekOrDay;
    private String subject;
    private String topic;
    private String activity;
    @Column(length = 2000)
    private String description;
    private String difficulty;
    private String sourceType;
}
