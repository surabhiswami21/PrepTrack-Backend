package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findBySubjectIdAndNameIgnoreCase(Long subjectId, String name);
}
