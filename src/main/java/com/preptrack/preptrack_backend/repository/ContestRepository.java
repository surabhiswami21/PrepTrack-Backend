package com.preptrack.preptrack_backend.repository;
import com.preptrack.preptrack_backend.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import com.preptrack.preptrack_backend.entity.User;
import java.util.List;

public interface ContestRepository
        extends JpaRepository<Contest, Long> {
        List<Contest> findAllByUserOrderByIdAsc(User user);
        List<Contest> findAllByUserIsNullOrderByIdAsc();
}
