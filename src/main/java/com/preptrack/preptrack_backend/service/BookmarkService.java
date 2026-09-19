package com.preptrack.preptrack_backend.service;

import com.preptrack.preptrack_backend.entity.Bookmark;
import com.preptrack.preptrack_backend.repository.BookmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(
            BookmarkRepository bookmarkRepository
    ) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public Bookmark save(Bookmark bookmark, com.preptrack.preptrack_backend.entity.User user) {
        bookmark.setUser(user);
        return bookmarkRepository.save(bookmark);
    }

    public List<Bookmark> getAll(com.preptrack.preptrack_backend.entity.User user) {
        return bookmarkRepository.findAllByUserOrderByIdAsc(user);
    }

    public void delete(Long id, com.preptrack.preptrack_backend.entity.User user) {
        Bookmark row = bookmarkRepository.findById(id).orElseThrow();
        if (row.getUser() == null) throw new org.springframework.security.access.AccessDeniedException("Unassigned legacy bookmark requires migration");
        if (!user.getId().equals(row.getUser().getId())) throw new org.springframework.security.access.AccessDeniedException("Bookmark does not belong to the authenticated user");
        bookmarkRepository.delete(row);
    }
}