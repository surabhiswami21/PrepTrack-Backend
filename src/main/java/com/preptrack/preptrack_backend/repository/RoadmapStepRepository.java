package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.RoadmapStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoadmapStepRepository extends JpaRepository<RoadmapStep, Long> {
    List<RoadmapStep> findAllByRoadmapIdOrderBySequenceNumber(Long roadmapId);
}
