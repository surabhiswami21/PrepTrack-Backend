package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.DsaProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import com.preptrack.preptrack_backend.entity.User;
import java.util.List;

public interface DsaProgressRepository
        extends JpaRepository<DsaProgress, Long> {
        List<DsaProgress> findAllByUserOrderByIdAsc(User user);
        List<DsaProgress> findAllByUserIsNullOrderByIdAsc();
}