package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.CompanyRoadmap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRoadmapRepository extends JpaRepository<CompanyRoadmap, Long> {
    Optional<CompanyRoadmap> findByCompanyId(Long companyId);
}
