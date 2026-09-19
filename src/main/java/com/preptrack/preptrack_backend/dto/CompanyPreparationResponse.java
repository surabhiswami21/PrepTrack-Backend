package com.preptrack.preptrack_backend.dto;

import com.preptrack.preptrack_backend.entity.*;

import java.util.List;

public record CompanyPreparationResponse(
        CompanyInfo company,
        RecruitmentDetail recruitment,
        List<CompanyRole> roles,
        List<HiringStage> hiringProcess,
        List<RegistrationLink> registrationLinks,
        List<CompanySubject> subjects,
        List<CompanyTopic> topics,
        List<CompanyQuestion> questions,
        CompanyRoadmap roadmap,
        List<RoadmapStep> roadmapSteps
) {
}
