package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {
    Optional<CompanyInfo> findByCompanyNameIgnoreCase(String companyName);
}
