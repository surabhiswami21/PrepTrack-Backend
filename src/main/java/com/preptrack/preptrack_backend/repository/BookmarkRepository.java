package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import com.preptrack.preptrack_backend.entity.User;
import java.util.List;

public interface BookmarkRepository
        extends JpaRepository<Bookmark, Long> {
        List<Bookmark> findAllByUserOrderByIdAsc(User user);
        List<Bookmark> findAllByUserIsNullOrderByIdAsc();
}
