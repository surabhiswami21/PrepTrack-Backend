package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.RecruitmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecruitmentDetailRepository extends JpaRepository<RecruitmentDetail, Long> {
    Optional<RecruitmentDetail> findByCompanyId(Long companyId);
}
