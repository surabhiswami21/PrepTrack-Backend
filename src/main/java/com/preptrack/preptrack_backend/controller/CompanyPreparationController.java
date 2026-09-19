package com.preptrack.preptrack_backend.controller;

import com.preptrack.preptrack_backend.dto.CompanyPreparationResponse;
import com.preptrack.preptrack_backend.entity.CompanyInfo;
import com.preptrack.preptrack_backend.service.CompanyPreparationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-preparation")
@CrossOrigin(origins = "http://localhost:5173")
public class CompanyPreparationController {
    private final CompanyPreparationService service;

    public CompanyPreparationController(CompanyPreparationService service) {
        this.service = service;
    }

    @GetMapping("/companies")
    public List<CompanyInfo> getCompanies() {
        return service.getCompanies();
    }

    @GetMapping("/companies/{id}")
    public CompanyPreparationResponse getCompany(@PathVariable Long id) {
        return service.getCompany(id);
    }

    @GetMapping("/subjects")
    public List<com.preptrack.preptrack_backend.entity.Subject> getSubjects() {
        return service.getSubjects();
    }

    @GetMapping("/questions")
    public List<com.preptrack.preptrack_backend.entity.CompanyQuestion> getQuestions(
            @RequestParam(required = false) Long companyId,
            @RequestParam(required = false) String section,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String difficulty) {
        return service.getQuestions(companyId, section, search, difficulty);
    }
}
