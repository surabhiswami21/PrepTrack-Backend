package com.preptrack.preptrack_backend.controller;

import com.preptrack.preptrack_backend.entity.Bookmark;
import com.preptrack.preptrack_backend.service.BookmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;
import com.preptrack.preptrack_backend.entity.User;
import com.preptrack.preptrack_backend.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class BookmarkController {

    private final BookmarkService bookmarkService;
    private final UserRepository userRepository;

    public BookmarkController(
            BookmarkService bookmarkService, UserRepository userRepository
    ) {
        this.bookmarkService = bookmarkService;
            this.userRepository = userRepository;
    }

    private User user(Principal principal) { return userRepository.findByEmail(principal.getName()).orElseThrow(); }

    @PostMapping("/api/bookmarks/save")
    public Bookmark save(
            @RequestBody Bookmark bookmark, Principal principal
    ) {
        return bookmarkService.save(bookmark, user(principal));
    }

    @GetMapping("/api/bookmarks/all")
    public List<Bookmark> getAll(Principal principal) {
        return bookmarkService.getAll(user(principal));
    }

    @DeleteMapping("/api/bookmarks/delete/{id}")
    public void delete(
            @PathVariable Long id, Principal principal
    ) {
        bookmarkService.delete(id, user(principal));
    }
}
