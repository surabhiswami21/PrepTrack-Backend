package com.preptrack.preptrack_backend.service;

import com.preptrack.preptrack_backend.entity.DsaProgress;
import com.preptrack.preptrack_backend.repository.DsaProgressRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.List;

@Service
public class DsaService {

    private final DsaProgressRepository repository;

    public DsaService(DsaProgressRepository repository) {
        this.repository = repository;
    }

    public int getSolvedQuestions(com.preptrack.preptrack_backend.entity.User user) {
        return getAllProgress(user).stream()
                .mapToInt(item -> item.getEasy() + item.getMedium() + item.getHard())
                .sum();
    }



    public DsaProgress save(DsaProgress progress, com.preptrack.preptrack_backend.entity.User user) {

        progress.setCreatedDate(LocalDate.now());
        progress.setUser(user);

        return repository.save(progress);
    }

    // ADD THIS METHOD
    public List<DsaProgress> getAllProgress(com.preptrack.preptrack_backend.entity.User user) {
        return repository.findAllByUserOrderByIdAsc(user);
    }

    public void deleteProgress(Long id, com.preptrack.preptrack_backend.entity.User user) {
        DsaProgress existing = repository.findById(id).orElseThrow();
        if (existing.getUser() == null) throw new org.springframework.security.access.AccessDeniedException("Unassigned legacy progress requires migration");
        if (!user.getId().equals(existing.getUser().getId())) throw new org.springframework.security.access.AccessDeniedException("Progress does not belong to the authenticated user");
        repository.delete(existing);
    }

    public DsaProgress updateProgress(Long id, DsaProgress progress, com.preptrack.preptrack_backend.entity.User user) {

        DsaProgress existing =
                repository.findById(id).orElseThrow();

        if (existing.getUser() == null) existing.setUser(user);
        if (!user.getId().equals(existing.getUser().getId())) throw new org.springframework.security.access.AccessDeniedException("Progress does not belong to the authenticated user");

        existing.setEasy(progress.getEasy());
        existing.setMedium(progress.getMedium());
        existing.setHard(progress.getHard());

        return repository.save(existing);
    }

    public int getStreak(com.preptrack.preptrack_backend.entity.User user) {

        return (int) repository.findAllByUserOrderByIdAsc(user)
                .stream()
                .map(DsaProgress::getCreatedDate)
                .distinct()
                .count();
    }
}