package com.preptrack.preptrack_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"company_id", "question_id"}))
public class CompanyQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private CompanyInfo company;

    @ManyToOne(optional = false)
    private PreparationQuestion question;

    private String section;
    private int priority;
    private String sourceType;
}
