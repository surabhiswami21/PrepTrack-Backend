package com.preptrack.preptrack_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class HiringStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private CompanyInfo company;

    private int sequenceNumber;
    private String name;
    private String details;
    private String sourceType;
}
