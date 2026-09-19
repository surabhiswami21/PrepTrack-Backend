package com.preptrack.preptrack_backend.config;

import com.preptrack.preptrack_backend.entity.CompanyInfo;
import com.preptrack.preptrack_backend.entity.CompanyRoadmap;
import com.preptrack.preptrack_backend.entity.RoadmapStep;
import com.preptrack.preptrack_backend.repository.CompanyInfoRepository;
import com.preptrack.preptrack_backend.repository.CompanyRoadmapRepository;
import com.preptrack.preptrack_backend.repository.RoadmapStepRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.List;

@Configuration
@Order(3)
@ConditionalOnProperty(name = "preptrack.seed-roadmaps", havingValue = "true")
public class RoadmapInitializer {
    private static final String SOURCE = "GENERAL_PREPARATION";

    @Bean
    CommandLineRunner seedRoadmaps(CompanyInfoRepository companies, CompanyRoadmapRepository roadmaps, RoadmapStepRepository steps) {
        return args -> {
            roadmap(companies, roadmaps, steps, "TCS", "TCS preparation roadmap", "Preparation based on the supplied TCS topics and general software requirements.", List.of(
                    new String[]{"Foundation", "1", "Programming", "Basic programming", "Revise programming fundamentals", "Easy"},
                    new String[]{"Coding", "2", "Data Structures", "Arrays and Strings", "Practice arrays and strings", "Medium"},
                    new String[]{"Technical", "3", "SQL", "Joins and subqueries", "Practice SQL query writing", "Medium"},
                    new String[]{"Technical Interview", "4", "OOP", "Abstraction and polymorphism", "Prepare concept explanations", "Medium"},
                    new String[]{"Project", "5", "Projects", "Project questions", "Prepare objective, contribution, and challenges", "Medium"},
                    new String[]{"HR", "6", "HR", "HR Questions", "Practice general HR questions", "Easy"}
            ));
            roadmap(companies, roadmaps, steps, "Maventic", "Maventic preparation roadmap", "Preparation based on the supplied Software Developer requirements.", List.of(
                    new String[]{"Foundation", "1", "C", "Basic programming", "Strengthen programming fundamentals", "Easy"},
                    new String[]{"Coding", "2", "C++", "Coding", "Practice implementation and problem solving", "Medium"},
                    new String[]{"Technical", "3", "Java", "Programming", "Revise Java fundamentals", "Medium"},
                    new String[]{"Technical", "4", "DBMS", "Database fundamentals", "Revise database concepts and SQL", "Medium"},
                    new String[]{"Technical", "5", "Operating Systems", "Processes and memory", "Review OS fundamentals", "Medium"},
                    new String[]{"Interview", "6", "Software Development", "Testing", "Prepare robust and maintainable code discussions", "Medium"}
            ));
            roadmap(companies, roadmaps, steps, "Quantiphi", "Quantiphi preparation roadmap", "Preparation based on the supplied software, platform, data, and machine learning role requirements.", List.of(
                    new String[]{"Foundation", "1", "Programming", "Basic programming", "Strengthen programming and problem solving", "Easy"},
                    new String[]{"Software", "2", "Software Development", "Software development", "Review scalable and secure development concepts", "Medium"},
                    new String[]{"Data", "3", "Data Engineering", "Data Engineering", "Review data pipeline fundamentals", "Medium"},
                    new String[]{"Machine Learning", "4", "Machine Learning", "Machine Learning", "Revise ML fundamentals only where relevant to the role", "Medium"},
                    new String[]{"Interview", "5", "Projects", "Project discussion", "Prepare one project from data to deployment", "Medium"}
            ));
            roadmap(companies, roadmaps, steps, "EPAM", "EPAM preparation roadmap", "Preparation based on the supplied selection process and general software preparation categories.", List.of(
                    new String[]{"Assessment", "1", "Coding", "Problem solving", "Practice coding and technical MCQs", "Medium"},
                    new String[]{"Assessment", "2", "Data Structures", "Algorithms", "Practice timed problem solving", "Medium"},
                    new String[]{"Communication", "3", "Group Discussion", "Group Discussion", "Prepare structured discussion points", "Easy"},
                    new String[]{"Interview", "4", "Technical Interview", "Technical Interview", "Review fundamentals and project explanations", "Medium"},
                    new String[]{"Final", "5", "Managerial Interview", "Final Interview", "Prepare managerial and behavioral responses", "Easy"}
            ));
            roadmap(companies, roadmaps, steps, "SAP", "SAP STAR preparation roadmap", "Preparation based on the supplied STAR program categories; no SAP-specific questions were invented.", List.of(
                    new String[]{"Foundation", "1", "Programming", "Programming", "Revise programming fundamentals", "Easy"},
                    new String[]{"Software", "2", "Software", "Software", "Practice software development concepts", "Medium"},
                    new String[]{"AI/ML", "3", "AI/ML", "AI/ML", "Review general AI/ML fundamentals", "Medium"},
                    new String[]{"Interview", "4", "Technical Interview", "Technical Interview", "Practice general technical explanations", "Medium"},
                    new String[]{"Revision", "5", "Revision", "Mock Test", "Review and practice a mock assessment", "Medium"}
            ));
            roadmap(companies, roadmaps, steps, "Infosys", "Infosys preparation roadmap", "General preparation based on available role requirements; the referenced Infosys preparation document was unavailable.", List.of(
                    new String[]{"Foundation", "1", "Programming", "Basic programming", "Revise programming fundamentals", "Easy"},
                    new String[]{"Coding", "2", "Coding", "Data Structures", "Practice general coding problems", "Medium"},
                    new String[]{"Technical", "3", "DBMS", "SQL", "Review DBMS and SQL fundamentals", "Medium"},
                    new String[]{"Interview", "4", "Projects", "Project questions", "Prepare project explanations from the actual resume", "Medium"},
                    new String[]{"HR", "5", "HR", "Introduction", "Practice general HR preparation", "Easy"}
            ));
        };
    }

    private void roadmap(CompanyInfoRepository companies, CompanyRoadmapRepository roadmaps, RoadmapStepRepository steps,
                         String companyName, String title, String description, List<String[]> values) {
        CompanyInfo company = companies.findByCompanyNameIgnoreCase(companyName).orElse(null);
        if (company == null || roadmaps.findByCompanyId(company.getId()).isPresent()) return;
        CompanyRoadmap roadmap = new CompanyRoadmap();
        roadmap.setCompany(company);
        roadmap.setTitle(title);
        roadmap.setDescription(description);
        roadmap.setSourceType(SOURCE);
        roadmap = roadmaps.save(roadmap);
        int sequence = 1;
        for (String[] value : values) {
            RoadmapStep step = new RoadmapStep();
            step.setRoadmap(roadmap);
            step.setSequenceNumber(sequence++);
            step.setPhase(value[0]);
            step.setWeekOrDay(value[1]);
            step.setSubject(value[2]);
            step.setTopic(value[3]);
            step.setActivity(value[4]);
            step.setDescription(value[4]);
            step.setDifficulty(value[5]);
            step.setSourceType(SOURCE);
            steps.save(step);
        }
    }
}
