package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.CompanyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyQuestionRepository extends JpaRepository<CompanyQuestion, Long> {
    List<CompanyQuestion> findAllByCompanyIdOrderByPriorityAsc(Long companyId);
    Optional<CompanyQuestion> findByCompanyIdAndQuestionId(Long companyId, Long questionId);
}
