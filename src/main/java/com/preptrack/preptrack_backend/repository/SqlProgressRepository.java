package com.preptrack.preptrack_backend.repository;


import com.preptrack.preptrack_backend.entity.SqlProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import com.preptrack.preptrack_backend.entity.User;
import java.util.List;

public interface SqlProgressRepository
        extends JpaRepository<SqlProgress, Long> {
        List<SqlProgress> findAllByUserOrderByIdAsc(User user);
        List<SqlProgress> findAllByUserIsNullOrderByIdAsc();

}