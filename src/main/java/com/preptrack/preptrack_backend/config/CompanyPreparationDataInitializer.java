package com.preptrack.preptrack_backend.config;

import com.preptrack.preptrack_backend.entity.*;
import com.preptrack.preptrack_backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.Arrays;
import java.util.List;

@Configuration
@Order(1)
@ConditionalOnProperty(name = "preptrack.seed-company-data", havingValue = "true")
public class CompanyPreparationDataInitializer {
    private static final String PROVIDED = "PROVIDED_BY_USER";
    private static final String COMPANY_JD = "COMPANY_JD";
    private static final String INTERVIEW = "INTERVIEW_PREPARATION";

    @Bean
    CommandLineRunner seedCompanyPreparation(
            CompanyInfoRepository companies,
            RecruitmentDetailRepository recruitmentDetails,
            CompanyRoleRepository roles,
            HiringStageRepository stages,
            RegistrationLinkRepository links,
            SubjectRepository subjects,
            CompanySubjectRepository companySubjects,
            TopicRepository topics,
            CompanyTopicRepository companyTopics,
            PreparationQuestionRepository questions,
            CompanyQuestionRepository companyQuestions) {
        return args -> {
            CompanyInfo quantiphi = company(companies, "Quantiphi", "Technical / Software / Machine Learning", "2027 Batch", "Mumbai/Bangalore", "6 months", "INR 24,000/month", "INR 8.5 LPA", "INR 6.5 LPA", "August 06, 10:00 AM", "https://unstop.com/p/quantiphi-campus-hiring-2027-lnct-quantiphi-1730833");
            details(recruitmentDetails, quantiphi, "MCA; B.Tech; M.Tech; 70% or above in 10th, 12th and Graduation; no active or historical reappears/backlogs", "Intern - Framework Engineer; Intern - Machine Learning Engineer", "Mumbai/Bangalore depending on business requirement", "6 months", "INR 24,000/month", "INR 8.5 LPA", "INR 6.5 LPA", "", "INR 2 Lakhs QCDP Bonus", "", "", "", "", "", "", "", "NAPS registration and KYC are mandatory before Unstop registration; invalid NAPS ID may result in disqualification.");
            role(roles, quantiphi, "Intern - Framework Engineer", "MCA; B.Tech; M.Tech", "CSE/IT and related specialization", "Software Development; Platform Engineer; Data Engineer", "", "", COMPANY_JD);
            role(roles, quantiphi, "Intern - Machine Learning Engineer", "MCA; B.Tech; M.Tech", "All eligible specializations", "Machine Learning Engineer", "", "", COMPANY_JD);
            link(links, quantiphi, "NAPS Portal Registration", "https://www.apprenticeshipindia.gov.in/candidate-login", "Before Unstop registration", "Complete KYC and submit bank details; NAPS Candidate ID is mandatory.", PROVIDED);
            link(links, quantiphi, "Campus Registration", "https://unstop.com/p/quantiphi-campus-hiring-2027-lnct-quantiphi-1730833", "August 06, 10:00 AM", "NAPS Candidate ID is required.", PROVIDED);
            subjectFor(companySubjects, subjects, quantiphi, "Software Development", "Technical", PROVIDED);
            subjectFor(companySubjects, subjects, quantiphi, "Platform Engineering", "Technical", PROVIDED);
            subjectFor(companySubjects, subjects, quantiphi, "Data Engineering", "Technical", PROVIDED);
            subjectFor(companySubjects, subjects, quantiphi, "Machine Learning", "Technical", PROVIDED);

            CompanyInfo maventic = company(companies, "Maventic", "Technical / Software Preparation", "2027 Batch", "Bangalore", "6 months or until graduation, whichever is higher", "INR 21,500 including PF & ESI deduction", "BLUE BAND: INR 7,00,000 (INR 6,00,000 fixed + INR 1,00,000 variable); GREEN BAND: INR 4,50,000", "INR 6,00,000", "29 July 2026, 4:00 PM", "https://forms.gle/R4YEv13dCJsu9XP97");
            details(recruitmentDetails, maventic, "B.Tech all branches; MCA; BCA; current course CGPA 7.5 or above; 2027 pass outs", "Software Developer", "Bangalore", "6 months or until graduation, whichever is higher", "INR 21,500 including PF & ESI deduction", "BLUE BAND: INR 7,00,000 (INR 6,00,000 fixed + INR 1,00,000 variable); GREEN BAND: INR 4,50,000", "INR 6,00,000", "INR 1,00,000 variable", "", "Training plus 2 years of employment", "6 months or until graduation, whichever is higher", "Immediate", "Work From Office", "", "", "", "Immediate joining required.");
            stages(stages, maventic, List.of("Coding Test", "Coding Test", "Short Technical Interview", "Final Technical Interview", "HR Round"), COMPANY_JD);
            link(links, maventic, "Registration", "https://forms.gle/R4YEv13dCJsu9XP97", "29 July 2026, 4:00 PM", "", PROVIDED);
            role(roles, maventic, "Software Developer", "B.Tech; MCA; BCA", "All branches where stated", "Software Developer", "Good communication; strong logical ability; ability to write programs; C; C++; Java; HTML5; JavaScript; basic programming; databases; Operating Systems", "Large-scale projects; scalable, robust, secure, high-quality programs; software design and coding; unit testing; system testing; code maintenance; reports; development support; module backups: BOL, UI, ADM, Account Console, Mobile, Automation", COMPANY_JD);
            for (String name : new String[]{"Programming", "C", "C++", "Java", "JavaScript", "HTML", "DBMS", "Operating Systems", "Coding", "Software Development"}) {
                subjectFor(companySubjects, subjects, maventic, name, "Technical", PROVIDED);
            }

            CompanyInfo tcs = company(companies, "TCS", "Technical / Software Preparation", "", "", "", "", "", "", "", "");
            for (String name : new String[]{"SQL", "OOP", "Programming - Arrays & Strings", "Projects", "Resume"}) {
                subjectFor(companySubjects, subjects, tcs, name, "Technical", PROVIDED);
            }
            subjectFor(companySubjects, subjects, tcs, "HR", "HR", PROVIDED);
            topicAndMap(topics, companyTopics, subjects, tcs, "SQL", "SELECT", PROVIDED, "Important preparation topic provided for TCS");
            for (String name : new String[]{"JOINs", "GROUP BY", "HAVING", "Subqueries", "Aggregate Functions", "Database concepts", "Query writing"}) {
                topicAndMap(topics, companyTopics, subjects, tcs, "SQL", name, PROVIDED, "Important preparation topic provided for TCS");
            }
            for (String name : new String[]{"Abstraction", "Inheritance", "Polymorphism", "Encapsulation", "Interfaces", "Method Overloading", "Method Overriding", "Abstract Class vs Interface"}) {
                topicAndMap(topics, companyTopics, subjects, tcs, "OOP", name, PROVIDED, "Important preparation topic provided for TCS");
            }
            for (String name : new String[]{"Array-based problems", "String reversal", "Basic array coding", "Basic string coding", "String vs StringBuilder vs StringBuffer"}) {
                topicAndMap(topics, companyTopics, subjects, tcs, "Programming - Arrays & Strings", name, PROVIDED, "Important preparation topic provided for TCS");
            }
            for (String name : new String[]{"String", "StringBuilder", "StringBuffer"}) {
                topicAndMap(topics, companyTopics, subjects, tcs, "Programming - Arrays & Strings", name, PROVIDED, "Important preparation topic provided for TCS");
            }
            for (String name : new String[]{"Project objective", "Technologies used", "Individual contribution", "Challenges faced", "How challenges were solved"}) {
                topicAndMap(topics, companyTopics, subjects, tcs, "Projects", name, PROVIDED, "Project question coverage provided for TCS");
            }
            for (String name : new String[]{"Skills", "Technologies", "Certifications", "Internships", "Projects"}) {
                topicAndMap(topics, companyTopics, subjects, tcs, "Resume", name, PROVIDED, "Resume question coverage provided for TCS");
            }
            for (String question : new String[]{"Tell me about yourself", "Willingness to relocate", "Willingness to work in night shifts", "Career goals", "Strengths", "Weaknesses", "Why do you want to join?"}) {
                Topic hr = topic(topics, subjects, "HR", "HR Questions", PROVIDED, "Interview preparation questions provided for TCS");
                questionFor(questions, companyQuestions, tcs, hr, question, "HR", PROVIDED);
            }

            CompanyInfo epam = company(companies, "EPAM", "Technical / Software Preparation", "2027 Batch", "Hyderabad; Coimbatore; Chennai", "", "INR 27,500/month", "INR 8,48,000 per annum", "INR 8,00,000", "14 July 2026, 10:00 AM", "https://forms.gle/SVwXTAjTbinV1XpB6");
            details(recruitmentDetails, epam, "B.Tech CSE/all related CSE streams; MCA; 10th 60%; 12th 60%; Graduation minimum 70% or equivalent CGPA; no current backlogs", "", "EPAM India offices: Hyderabad; Coimbatore; Chennai", "", "INR 27,500/month (INR 25,000 base stipend + INR 2,500 food allowance)", "INR 8,48,000 per annum", "INR 8,00,000", "", "INR 48,000 customizable insurance", "", "", "", "", "No gap between Class 10th and 12th; maximum 12 months between Class 12th and Graduation", "Hyderabad; Coimbatore; Chennai", "", "Candidates must be flexible for EPAM India offices.");
            stages(stages, epam, List.of("Online Assessment: MCQs and Coding", "Pre-Placement Talk", "In-Person Coding Test", "Group Discussion", "Technical Interview", "Managerial & Final Round Interview"), COMPANY_JD);
            link(links, epam, "Registration", "https://forms.gle/SVwXTAjTbinV1XpB6", "14 July 2026, 10:00 AM", "", PROVIDED);
            for (String name : new String[]{"Coding", "Technical MCQs", "Technical Interview", "Problem Solving", "Group Discussion", "Managerial Interview", "Final Interview"}) {
                subjectFor(companySubjects, subjects, epam, name, "Technical", PROVIDED);
            }

            CompanyInfo sap = company(companies, "SAP", "Software / Programming / AI/ML", "2026 Batch", "Bangalore, India: Whitefield; Devanahalli Campus", "24 months / 2 years", "INR 40,850/month during first year", "INR 11,15,000 LPA", "", "14 July 2026, 10:00 AM", "https://forms.gle/CARs7TRjvpduZKTA8");
                    details(
                        recruitmentDetails,
                        sap,
                        "B.Tech; CSE; CSE-AIML; LNCT Group; 70% throughout in 10th, 12th/Diploma and B.Tech; no active backlog at joining",
                        "STAR Tech Campus / STAR Program",
                        "Bangalore, India: Whitefield; Devanahalli Campus",
                        "24 months / 2 years",
                        "INR 40,850/month during first year",
                        "INR 11,15,000 LPA",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "Selected/offered students will not be allowed to sit for other campus opportunities.");
            link(links, sap, "Registration", "https://forms.gle/CARs7TRjvpduZKTA8", "14 July 2026, 10:00 AM", "", PROVIDED);
            for (String name : new String[]{"Software", "Programming", "AI/ML", "Technical Interview"}) {
                subjectFor(companySubjects, subjects, sap, name, "Technical", PROVIDED);
            }

            CompanyInfo infosys = company(companies, "Infosys", "Technical / Software Preparation", "2027 Batch", "", "", "INR 6.25 LPA to INR 21 LPA depending on role", "INR 21 LPA for Specialist Programmer L3", "", "", "");
                    details(
                        recruitmentDetails,
                        infosys,
                        "B.Tech; M.Tech; MCA; CSE, AIML, AIDS, IOT, Cyber Security, Data Science, EC, EC-ACT, EX, EE; 10th 60%; 12th 60%; Diploma 65%; Graduation 60%; current course 6 CGPA",
                        "Specialist Programmer L3; Specialist Programmer L2; Specialist Programmer L1; Digital Specialist Engineer",
                        "",
                        "",
                        "",
                        "Specialist Programmer L3: INR 21 LPA; L2: INR 16 LPA; L1: INR 10 LPA + INR 1 Lakh joining bonus; DSE: INR 6.25 LPA + INR 75,000 joining bonus",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "Infosys preparation document was not present in the project; no company-specific questions were invented.");
            role(roles, infosys, "Specialist Programmer L3", "B.Tech; M.Tech; MCA", "CSE, AIML, AIDS, IOT, Cyber Security, Data Science, EC, EC-ACT, EX, EE", "Specialist Programmer L3", "", "", PROVIDED);
            role(roles, infosys, "Specialist Programmer L2", "B.Tech; M.Tech; MCA", "CSE, AIML, AIDS, IOT, Cyber Security, Data Science, EC, EC-ACT, EX, EE", "Specialist Programmer L2", "", "", PROVIDED);
            role(roles, infosys, "Specialist Programmer L1", "B.Tech; M.Tech; MCA", "CSE, AIML, AIDS, IOT, Cyber Security, Data Science, EC, EC-ACT, EX, EE", "Specialist Programmer L1", "", "", PROVIDED);
            role(roles, infosys, "Digital Specialist Engineer", "B.Tech; M.Tech; MCA", "CSE, AIML, AIDS, IOT, Cyber Security, Data Science, EC, EC-ACT, EX, EE", "Digital Specialist Engineer", "", "", PROVIDED);
        };
    }

    private CompanyInfo company(CompanyInfoRepository repository, String name, String category, String batch, String location, String internship, String stipend, String ctc, String fixed, String deadline, String link) {
        CompanyInfo company = repository.findByCompanyNameIgnoreCase(name).orElseGet(CompanyInfo::new);
        company.setCompanyName(name);
        company.setCategory(category);
        company.setBatch(batch);
        company.setLocation(location);
        company.setInternship(internship);
        company.setStipend(stipend);
        company.setCtc(ctc);
        company.setFixedCompensation(fixed);
        company.setRegistrationDeadline(deadline);
        company.setRegistrationLink(link);
        company.setSourceType(PROVIDED);
        company.setPackageOffered(ctc);
        return repository.save(company);
    }

    private void details(RecruitmentDetailRepository repository, CompanyInfo company, String... values) {
        RecruitmentDetail detail = repository.findByCompanyId(company.getId()).orElseGet(RecruitmentDetail::new);
        detail.setCompany(company);
        detail.setEligibility(value(values, 0));
        detail.setRoles(value(values, 1));
        detail.setLocation(value(values, 2));
        detail.setInternship(value(values, 3));
        detail.setStipend(value(values, 4));
        detail.setCtc(value(values, 5));
        detail.setFixedCompensation(value(values, 6));
        detail.setVariableCompensation(value(values, 7));
        detail.setBonus(value(values, 8));
        detail.setServiceAgreement(value(values, 9));
        detail.setTrainingPeriod(value(values, 10));
        detail.setJoining(value(values, 11));
        detail.setWorkMode(value(values, 12));
        detail.setDegree(value(values, 13));
        detail.setEducationGap(value(values, 14));
        detail.setOnboardingLocations(value(values, 15));
        detail.setNotes(value(values, 16));
        repository.save(detail);
    }

    private String value(String[] values, int index) {
        return index < values.length ? values[index] : "";
    }

    private void role(CompanyRoleRepository repository, CompanyInfo company, String name, String programs, String branches, String hiringRole, String expectations, String responsibilities, String sourceType) {
        CompanyRole role = repository.findAllByCompanyIdOrderById(company.getId()).stream().filter(item -> item.getName().equalsIgnoreCase(name)).findFirst().orElseGet(CompanyRole::new);
        role.setCompany(company);
        role.setName(name);
        role.setEligiblePrograms(programs);
        role.setEligibleBranches(branches);
        role.setHiringRole(hiringRole);
        role.setExpectations(expectations);
        role.setResponsibilities(responsibilities);
        role.setSourceType(sourceType);
        repository.save(role);
    }

    private void stages(HiringStageRepository repository, CompanyInfo company, List<String> names, String sourceType) {
        if (!repository.findAllByCompanyIdOrderBySequenceNumber(company.getId()).isEmpty()) return;
        for (int index = 0; index < names.size(); index++) {
            HiringStage stage = new HiringStage();
            stage.setCompany(company);
            stage.setSequenceNumber(index + 1);
            stage.setName(names.get(index));
            stage.setDetails(names.get(index));
            stage.setSourceType(sourceType);
            repository.save(stage);
        }
    }

    private void link(RegistrationLinkRepository repository, CompanyInfo company, String label, String url, String deadline, String instructions, String sourceType) {
        boolean exists = repository.findAllByCompanyIdOrderById(company.getId()).stream().anyMatch(item -> item.getUrl().equals(url));
        if (exists) return;
        RegistrationLink link = new RegistrationLink();
        link.setCompany(company);
        link.setLabel(label);
        link.setUrl(url);
        link.setDeadline(deadline);
        link.setInstructions(instructions);
        link.setSourceType(sourceType);
        repository.save(link);
    }

    private Subject subject(SubjectRepository repository, String name, String category, String sourceType) {
        Subject subject = repository.findByNameIgnoreCase(name).orElseGet(Subject::new);
        subject.setName(name);
        subject.setCategory(category);
        subject.setSourceType(sourceType);
        return repository.save(subject);
    }

    private void subjectFor(CompanySubjectRepository mappings, SubjectRepository subjects, CompanyInfo company, String name, String category, String sourceType) {
        Subject subject = subject(subjects, name, category, sourceType);
        if (mappings.findByCompanyIdAndSubjectId(company.getId(), subject.getId()).isPresent()) return;
        CompanySubject mapping = new CompanySubject();
        mapping.setCompany(company);
        mapping.setSubject(subject);
        mapping.setPriority(mappings.findAllByCompanyIdOrderByPriorityAsc(company.getId()).size() + 1);
        mapping.setSourceType(sourceType);
        mappings.save(mapping);
    }

    private Topic topic(TopicRepository repository, SubjectRepository subjects, String subjectName, String topicName, String sourceType, String description) {
        Subject subject = subjects.findByNameIgnoreCase(subjectName).orElseThrow();
        Topic topic = repository.findBySubjectIdAndNameIgnoreCase(subject.getId(), topicName).orElseGet(Topic::new);
        topic.setSubject(subject);
        topic.setName(topicName);
        topic.setSourceType(sourceType);
        topic.setDescription(description);
        return repository.save(topic);
    }

    private void topicAndMap(TopicRepository topics, CompanyTopicRepository mappings, SubjectRepository subjects, CompanyInfo company, String subjectName, String topicName, String sourceType, String description) {
        Topic topic = topic(topics, subjects, subjectName, topicName, sourceType, description);
        if (mappings.findByCompanyIdAndTopicId(company.getId(), topic.getId()).isPresent()) return;
        CompanyTopic mapping = new CompanyTopic();
        mapping.setCompany(company);
        mapping.setTopic(topic);
        mapping.setSection(subjectName);
        mapping.setPriority(mappings.findAllByCompanyIdOrderByPriorityAsc(company.getId()).size() + 1);
        mapping.setSourceType(sourceType);
        mappings.save(mapping);
    }

    private void questionFor(PreparationQuestionRepository questions, CompanyQuestionRepository mappings, CompanyInfo company, Topic topic, String text, String section, String sourceType) {
        PreparationQuestion question = questions.findByTopicIdAndQuestionTextIgnoreCase(topic.getId(), text).orElseGet(PreparationQuestion::new);
        question.setTopic(topic);
        question.setQuestionText(text);
        question.setQuestionType("Interview");
        question.setSourceType(sourceType);
        question = questions.save(question);
        if (mappings.findByCompanyIdAndQuestionId(company.getId(), question.getId()).isPresent()) return;
        CompanyQuestion mapping = new CompanyQuestion();
        mapping.setCompany(company);
        mapping.setQuestion(question);
        mapping.setSection(section);
        mapping.setPriority(mappings.findAllByCompanyIdOrderByPriorityAsc(company.getId()).size() + 1);
        mapping.setSourceType(sourceType);
        mappings.save(mapping);
    }
}
