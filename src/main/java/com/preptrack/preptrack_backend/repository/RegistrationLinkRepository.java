package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.RegistrationLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationLinkRepository extends JpaRepository<RegistrationLink, Long> {
    List<RegistrationLink> findAllByCompanyIdOrderById(Long companyId);
}
