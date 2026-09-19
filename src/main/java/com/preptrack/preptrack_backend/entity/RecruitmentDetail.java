package com.preptrack.preptrack_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RecruitmentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private CompanyInfo company;

    @Column(length = 2000)
    private String eligibility;
    private String roles;
    private String location;
    private String internship;
    private String stipend;
    private String ctc;
    private String fixedCompensation;
    private String variableCompensation;
    private String bonus;
    private String serviceAgreement;
    private String trainingPeriod;
    private String joining;
    private String workMode;
    private String degree;
    private String educationGap;
    private String onboardingLocations;
    private String notes;
}
