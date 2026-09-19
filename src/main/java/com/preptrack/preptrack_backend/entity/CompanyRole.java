package com.preptrack.preptrack_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CompanyRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private CompanyInfo company;

    private String name;
    private String eligiblePrograms;
    private String eligibleBranches;
    private String hiringRole;
    private String expectations;
    private String responsibilities;
    private String sourceType;
}
