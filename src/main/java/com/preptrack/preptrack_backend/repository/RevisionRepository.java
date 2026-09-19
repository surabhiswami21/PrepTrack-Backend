package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.RevisionProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import com.preptrack.preptrack_backend.entity.User;
import java.util.List;

public interface RevisionRepository
        extends JpaRepository<RevisionProgress, Long> {
        List<RevisionProgress> findAllByUserOrderByIdAsc(User user);
        List<RevisionProgress> findAllByUserIsNullOrderByIdAsc();
}