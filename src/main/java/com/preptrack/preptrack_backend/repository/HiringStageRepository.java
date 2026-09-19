package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.HiringStage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HiringStageRepository extends JpaRepository<HiringStage, Long> {
    List<HiringStage> findAllByCompanyIdOrderBySequenceNumber(Long companyId);
}
