package com.preptrack.preptrack_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"company_id", "subject_id"}))
public class CompanySubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private CompanyInfo company;

    @ManyToOne(optional = false)
    private Subject subject;

    private int priority;
    private String notes;
    private String sourceType;
}
