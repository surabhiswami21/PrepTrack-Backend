package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.CompanySubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanySubjectRepository extends JpaRepository<CompanySubject, Long> {
    List<CompanySubject> findAllByCompanyIdOrderByPriorityAsc(Long companyId);
    Optional<CompanySubject> findByCompanyIdAndSubjectId(Long companyId, Long subjectId);
}
