package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.CompanyRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRoleRepository extends JpaRepository<CompanyRole, Long> {
    List<CompanyRole> findAllByCompanyIdOrderById(Long companyId);
}
