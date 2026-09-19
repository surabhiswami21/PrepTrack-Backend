package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.CompanyTopic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyTopicRepository extends JpaRepository<CompanyTopic, Long> {
    List<CompanyTopic> findAllByCompanyIdOrderByPriorityAsc(Long companyId);
    Optional<CompanyTopic> findByCompanyIdAndTopicId(Long companyId, Long topicId);
}
