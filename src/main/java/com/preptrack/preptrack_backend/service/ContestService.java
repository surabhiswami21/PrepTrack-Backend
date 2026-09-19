package com.preptrack.preptrack_backend.service;

import com.preptrack.preptrack_backend.entity.Contest;
import com.preptrack.preptrack_backend.repository.ContestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {

    private final ContestRepository contestRepository;

    public ContestService(
            ContestRepository contestRepository
    ) {
        this.contestRepository = contestRepository;
    }

    public Contest save(Contest contest, com.preptrack.preptrack_backend.entity.User user) {
        contest.setUser(user);
        return contestRepository.save(contest);
    }

    public List<Contest> getAll(com.preptrack.preptrack_backend.entity.User user) {
        return contestRepository.findAllByUserOrderByIdAsc(user);
    }

    public void delete(Long id, com.preptrack.preptrack_backend.entity.User user) {
        Contest row = contestRepository.findById(id).orElseThrow();
        if (row.getUser() == null) throw new org.springframework.security.access.AccessDeniedException("Unassigned legacy contest requires migration");
        if (!user.getId().equals(row.getUser().getId())) throw new org.springframework.security.access.AccessDeniedException("Contest does not belong to the authenticated user");
        contestRepository.delete(row);
    }
}