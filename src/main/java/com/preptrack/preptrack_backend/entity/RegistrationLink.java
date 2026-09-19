package com.preptrack.preptrack_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RegistrationLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private CompanyInfo company;

    private String label;
    @Column(length = 1000)
    private String url;
    private String deadline;
    @Column(length = 2000)
    private String instructions;
    private String sourceType;
}
