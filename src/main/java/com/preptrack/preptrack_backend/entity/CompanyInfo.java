package com.preptrack.preptrack_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CompanyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String category;
    private String batch;
    private String location;
    private String internship;
    private String stipend;
    private String ctc;
    private String fixedCompensation;
    private String registrationDeadline;
    private String registrationLink;
    private String sourceType;

    private String packageOffered;
    private String eligibility;
    private String hiringProcess;
    private String aptitudeTopics;
    private String codingTopics;
    private String interviewQuestions;
}
