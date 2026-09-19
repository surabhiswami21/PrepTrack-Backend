package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.PreparationQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreparationQuestionRepository extends JpaRepository<PreparationQuestion, Long> {
    Optional<PreparationQuestion> findByTopicIdAndQuestionTextIgnoreCase(Long topicId, String questionText);
}
