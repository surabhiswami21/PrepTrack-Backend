package com.preptrack.preptrack_backend.service;

import com.preptrack.preptrack_backend.dto.CompanyPreparationResponse;
import com.preptrack.preptrack_backend.entity.CompanyInfo;
import com.preptrack.preptrack_backend.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyPreparationService {
    private final CompanyInfoRepository companyRepository;
    private final RecruitmentDetailRepository recruitmentRepository;
    private final CompanyRoleRepository roleRepository;
    private final HiringStageRepository hiringStageRepository;
    private final RegistrationLinkRepository registrationLinkRepository;
    private final CompanySubjectRepository companySubjectRepository;
    private final CompanyTopicRepository companyTopicRepository;
    private final CompanyQuestionRepository companyQuestionRepository;
    private final SubjectRepository subjectRepository;
    private final CompanyRoadmapRepository roadmapRepository;
    private final RoadmapStepRepository roadmapStepRepository;

    public CompanyPreparationService(
            CompanyInfoRepository companyRepository,
            RecruitmentDetailRepository recruitmentRepository,
            CompanyRoleRepository roleRepository,
            HiringStageRepository hiringStageRepository,
            RegistrationLinkRepository registrationLinkRepository,
            CompanySubjectRepository companySubjectRepository,
            CompanyTopicRepository companyTopicRepository,
            CompanyQuestionRepository companyQuestionRepository,
            SubjectRepository subjectRepository,
            CompanyRoadmapRepository roadmapRepository,
            RoadmapStepRepository roadmapStepRepository) {
        this.companyRepository = companyRepository;
        this.recruitmentRepository = recruitmentRepository;
        this.roleRepository = roleRepository;
        this.hiringStageRepository = hiringStageRepository;
        this.registrationLinkRepository = registrationLinkRepository;
        this.companySubjectRepository = companySubjectRepository;
        this.companyTopicRepository = companyTopicRepository;
        this.companyQuestionRepository = companyQuestionRepository;
        this.subjectRepository = subjectRepository;
        this.roadmapRepository = roadmapRepository;
        this.roadmapStepRepository = roadmapStepRepository;
    }

    public List<CompanyInfo> getCompanies() {
        return companyRepository.findAll();
    }

    public CompanyPreparationResponse getCompany(Long id) {
        CompanyInfo company = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company not found: " + id));

        var roadmap = roadmapRepository.findByCompanyId(id).orElse(null);
        return new CompanyPreparationResponse(
                company,
                recruitmentRepository.findByCompanyId(id).orElse(null),
                roleRepository.findAllByCompanyIdOrderById(id),
                hiringStageRepository.findAllByCompanyIdOrderBySequenceNumber(id),
                registrationLinkRepository.findAllByCompanyIdOrderById(id),
                companySubjectRepository.findAllByCompanyIdOrderByPriorityAsc(id),
                companyTopicRepository.findAllByCompanyIdOrderByPriorityAsc(id),
                companyQuestionRepository.findAllByCompanyIdOrderByPriorityAsc(id),
                roadmap,
                roadmap == null ? List.of() : roadmapStepRepository.findAllByRoadmapIdOrderBySequenceNumber(roadmap.getId()));
    }

    public List<com.preptrack.preptrack_backend.entity.Subject> getSubjects() {
        return subjectRepository.findAll();
    }

        public List<com.preptrack.preptrack_backend.entity.CompanyQuestion> getQuestions(Long companyId, String section, String search, String difficulty) {
        var rows = companyId == null ? companyQuestionRepository.findAll() : companyQuestionRepository.findAllByCompanyIdOrderByPriorityAsc(companyId);
        return rows.stream().filter(item -> section == null || section.isBlank() || section.equalsIgnoreCase(item.getSection()))
            .filter(item -> difficulty == null || difficulty.isBlank() || difficulty.equalsIgnoreCase(item.getQuestion().getDifficulty()))
            .filter(item -> search == null || search.isBlank() || item.getQuestion().getQuestionText().toLowerCase().contains(search.toLowerCase())
                || item.getQuestion().getTopic().getName().toLowerCase().contains(search.toLowerCase())
                || item.getQuestion().getTopic().getSubject().getName().toLowerCase().contains(search.toLowerCase()))
            .toList();
    }
}
