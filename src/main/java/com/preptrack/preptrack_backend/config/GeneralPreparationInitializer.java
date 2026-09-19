package com.preptrack.preptrack_backend.config;

import com.preptrack.preptrack_backend.entity.*;
import com.preptrack.preptrack_backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.List;

@Configuration
@Order(2)
@ConditionalOnProperty(name = "preptrack.seed-general-preparation", havingValue = "true")
public class GeneralPreparationInitializer {
    private static final String SOURCE = "GENERAL_PREPARATION";

    @Bean
    CommandLineRunner seedGeneralPreparation(CompanyInfoRepository companies, SubjectRepository subjects,
                                              TopicRepository topics, PreparationQuestionRepository questions,
                                              CompanySubjectRepository companySubjects, CompanyTopicRepository companyTopics,
                                              CompanyQuestionRepository companyQuestions) {
        return args -> {
            List<CompanyInfo> allCompanies = companies.findAll();
            String[][] technical = {
                    {"Programming", "Basic programming", "Explain variables, data types, loops, and conditional statements.", "Easy"},
                    {"Programming", "Memory concepts", "What is the difference between stack memory and heap memory?", "Medium"},
                    {"Java", "Exception handling", "How do checked and unchecked exceptions differ in Java?", "Medium"},
                    {"Java", "Multithreading", "What is the difference between a process, a thread, and a Java thread?", "Medium"},
                    {"C", "Pointers and memory", "What is a pointer and how is pointer arithmetic used?", "Medium"},
                    {"C++", "STL", "When would you use vector, map, and unordered_map in C++?", "Medium"},
                    {"Python", "Core syntax", "How do lists, tuples, sets, and dictionaries differ in Python?", "Easy"},
                    {"JavaScript", "Async programming", "Explain the event loop, promises, and async/await.", "Medium"},
                    {"OOP", "Class vs Object", "What is the difference between a class and an object?", "Easy"},
                    {"OOP", "Encapsulation", "What is encapsulation and why does it reduce coupling?", "Easy"},
                    {"OOP", "Abstraction", "How does abstraction hide implementation details?", "Easy"},
                    {"OOP", "Inheritance", "What are the benefits and risks of inheritance?", "Easy"},
                    {"OOP", "Polymorphism", "Compare compile-time and runtime polymorphism.", "Medium"},
                    {"OOP", "Method overloading", "What is method overloading and when is it useful?", "Easy"},
                    {"OOP", "Method overriding", "What rules apply when a subclass overrides a method?", "Medium"},
                    {"OOP", "Interface vs Abstract class", "Compare an interface and an abstract class.", "Medium"},
                    {"OOP", "Constructor", "What is a constructor and what is constructor overloading?", "Easy"},
                    {"OOP", "Composition and aggregation", "Compare association, aggregation, and composition.", "Medium"},
                    {"DBMS", "Keys", "Compare primary, foreign, candidate, and super keys.", "Easy"},
                    {"DBMS", "Normalization", "Explain 1NF, 2NF, 3NF, and BCNF.", "Medium"},
                    {"DBMS", "ACID", "What do the ACID properties guarantee?", "Easy"},
                    {"DBMS", "Transactions", "What are transaction isolation levels?", "Medium"},
                    {"DBMS", "Indexing", "How do indexes improve reads and affect writes?", "Medium"},
                    {"SQL", "Joins", "Explain INNER JOIN, LEFT JOIN, RIGHT JOIN, and FULL JOIN.", "Easy"},
                    {"SQL", "GROUP BY and HAVING", "What is the difference between WHERE and HAVING?", "Easy"},
                    {"SQL", "Subqueries", "When would you use a correlated subquery?", "Medium"},
                    {"SQL", "DELETE vs DROP vs TRUNCATE", "Compare DELETE, DROP, and TRUNCATE.", "Easy"},
                    {"Operating Systems", "Process vs Thread", "Compare a process and a thread.", "Easy"},
                    {"Operating Systems", "Scheduling", "Compare FCFS, SJF, Round Robin, and priority scheduling.", "Medium"},
                    {"Operating Systems", "Deadlock", "What are the four necessary conditions for deadlock?", "Medium"},
                    {"Operating Systems", "Synchronization", "Compare a semaphore and a mutex.", "Medium"},
                    {"Operating Systems", "Virtual memory", "How do paging and page replacement support virtual memory?", "Medium"},
                    {"Operating Systems", "System calls", "What is a system call and why is user mode separated from kernel mode?", "Medium"},
                    {"Computer Networks", "OSI model", "Describe the seven layers of the OSI model.", "Easy"},
                    {"Computer Networks", "TCP vs UDP", "Compare TCP and UDP and give use cases for each.", "Easy"},
                    {"Computer Networks", "HTTP and HTTPS", "How does HTTPS protect an HTTP request?", "Medium"},
                    {"Computer Networks", "DNS", "What happens during DNS resolution?", "Medium"},
                    {"Computer Networks", "TCP three-way handshake", "Explain the TCP three-way handshake.", "Medium"},
                    {"Computer Networks", "MAC vs IP", "Compare MAC addresses and IP addresses.", "Easy"},
                    {"Data Structures", "Arrays", "How would you find the maximum subarray sum?", "Medium"},
                    {"Data Structures", "Linked List", "How do you detect a cycle in a linked list?", "Medium"},
                    {"Data Structures", "Stack and Queue", "Compare stacks and queues with practical examples.", "Easy"},
                    {"Data Structures", "Hashing", "How do hash tables handle collisions?", "Medium"},
                    {"Data Structures", "Trees and BST", "What property makes a binary search tree useful?", "Easy"},
                    {"Algorithms", "Sorting", "Compare the time complexity of common sorting algorithms.", "Medium"},
                    {"Algorithms", "Searching", "When should binary search be used?", "Easy"},
                    {"Algorithms", "Sliding Window", "Describe a sliding-window approach for a fixed-size subarray problem.", "Medium"},
                    {"Algorithms", "Dynamic Programming", "How do overlapping subproblems and optimal substructure enable dynamic programming?", "Hard"},
                    {"APIs", "HTTP methods", "Compare GET, POST, PUT, PATCH, and DELETE.", "Easy"},
                    {"Backend", "Authentication", "Explain the difference between authentication and authorization.", "Easy"},
                    {"Frontend", "State management", "How should a frontend synchronize state with an API response?", "Medium"},
                    {"Projects", "Architecture", "Explain the architecture of a project and the responsibilities of each layer.", "Medium"},
                    {"Projects", "JWT", "How does JWT authentication work in a frontend and backend application?", "Medium"},
                    {"Software Engineering", "Testing", "What is the difference between unit, integration, and end-to-end testing?", "Easy"},
                    {"Git/GitHub", "Collaboration", "How do branches, pull requests, and code review support collaboration?", "Easy"},
                    {"Machine Learning / AI", "Model evaluation", "Why should model evaluation use metrics appropriate to the problem?", "Medium"}
            };
            for (String[] item : technical) add(item[0], item[1], item[2], item[3], "TECHNICAL_INTERVIEW", allCompanies, subjects, topics, questions, companySubjects, companyTopics, companyQuestions);

            String[][] coding = {
                    {"Data Structures", "Arrays", "Solve an array problem using a clear invariant and state its time complexity.", "Easy"},
                    {"Data Structures", "Strings", "Determine whether two strings are anagrams.", "Easy"},
                    {"Data Structures", "Linked List", "Reverse a singly linked list iteratively and recursively.", "Medium"},
                    {"Data Structures", "Searching", "Find an element in a sorted array using binary search.", "Easy"},
                    {"Data Structures", "Sorting", "Explain and implement merge sort.", "Medium"},
                    {"Data Structures", "Stack", "Validate balanced parentheses using a stack.", "Easy"},
                    {"Data Structures", "Queue", "Design a queue using two stacks.", "Medium"},
                    {"Algorithms", "Recursion", "Generate all subsets of a set using recursion.", "Medium"},
                    {"Algorithms", "Backtracking", "Solve a constraint problem using backtracking.", "Hard"},
                    {"Algorithms", "Greedy", "Explain when a greedy choice can be proven correct.", "Medium"},
                    {"Algorithms", "Graph", "Traverse a graph using BFS and DFS.", "Medium"},
                    {"Algorithms", "Dynamic Programming", "Solve a one-dimensional dynamic programming problem.", "Medium"},
                    {"Programming", "Basic programming", "Write a program to count character frequencies.", "Easy"}
            };
            for (String[] item : coding) add(item[0], item[1], item[2], item[3], "CODING", allCompanies, subjects, topics, questions, companySubjects, companyTopics, companyQuestions);

            String[][] hr = {
                    {"Introduction", "Tell me about yourself."},
                    {"Introduction", "Walk me through your resume."},
                    {"Introduction", "Tell me about your background."},
                    {"Company", "Why do you want to join this company?"},
                    {"Company", "What do you know about our company?"},
                    {"Company", "Why are you interested in this role?"},
                    {"Company", "Why should we hire you?"},
                    {"Strengths and Weaknesses", "What are your strengths?"},
                    {"Strengths and Weaknesses", "What is one weakness you are actively improving?"},
                    {"Behavioral", "Tell me about a challenge you faced and how you handled it."},
                    {"Behavioral", "Tell me about a failure and what you learned."},
                    {"Teamwork", "Tell me about a time you worked in a team."},
                    {"Leadership", "Tell me about a time you took ownership or led an effort."},
                    {"Conflict", "Tell me about a conflict and how you resolved it."},
                    {"Pressure and Deadlines", "How do you handle pressure and multiple deadlines?"},
                    {"Career Goals", "Where do you see yourself in five years?"},
                    {"Relocation", "Are you willing to relocate?"},
                    {"Work From Office", "Are you comfortable working from office?"},
                    {"Shifts and Travel", "Are you comfortable with shifts, night shifts, or travel?"},
                    {"Higher Studies", "Are you planning higher studies?"},
                    {"Projects", "What was your individual contribution to a project?"},
                    {"Internship", "What did you learn during your internship?"},
                    {"Certifications", "How have your certifications influenced your skills?"},
                    {"Situational", "What would you do if a teammate was not contributing?"}
            };
            for (String[] item : hr) add(item[0], item[0], item[1], "Easy", "HR", allCompanies, subjects, topics, questions, companySubjects, companyTopics, companyQuestions);
        };
    }

    private void add(String subjectName, String topicName, String questionText, String difficulty, String section,
                     List<CompanyInfo> companies, SubjectRepository subjects, TopicRepository topics,
                     PreparationQuestionRepository questions, CompanySubjectRepository companySubjects,
                     CompanyTopicRepository companyTopics, CompanyQuestionRepository companyQuestions) {
        Subject subject = subjects.findByNameIgnoreCase(subjectName).orElseGet(Subject::new);
        subject.setName(subjectName);
        subject.setCategory(section.equals("HR") ? "HR" : "TECHNICAL");
        subject.setSourceType(SOURCE);
        subject = subjects.save(subject);
        Topic topic = topics.findBySubjectIdAndNameIgnoreCase(subject.getId(), topicName).orElseGet(Topic::new);
        topic.setSubject(subject);
        topic.setName(topicName);
        topic.setDescription("General preparation material; not a verified company question.");
        topic.setSourceType(SOURCE);
        topic = topics.save(topic);
        PreparationQuestion question = questions.findByTopicIdAndQuestionTextIgnoreCase(topic.getId(), questionText).orElseGet(PreparationQuestion::new);
        question.setTopic(topic);
        question.setQuestionText(questionText);
        question.setDifficulty(difficulty);
        question.setQuestionType(section.equals("CODING") ? "Coding" : "Interview");
        question.setSourceType(SOURCE);
        question = questions.save(question);
        for (CompanyInfo company : companies) {
            if (companySubjects.findByCompanyIdAndSubjectId(company.getId(), subject.getId()).isEmpty()) {
                CompanySubject mapping = new CompanySubject();
                mapping.setCompany(company);
                mapping.setSubject(subject);
                mapping.setPriority(100);
                mapping.setSourceType(SOURCE);
                companySubjects.save(mapping);
            }
            if (companyTopics.findByCompanyIdAndTopicId(company.getId(), topic.getId()).isEmpty()) {
                CompanyTopic mapping = new CompanyTopic();
                mapping.setCompany(company);
                mapping.setTopic(topic);
                mapping.setSection(section);
                mapping.setPriority(100);
                mapping.setSourceType(SOURCE);
                companyTopics.save(mapping);
            }
            if (companyQuestions.findByCompanyIdAndQuestionId(company.getId(), question.getId()).isEmpty()) {
                CompanyQuestion mapping = new CompanyQuestion();
                mapping.setCompany(company);
                mapping.setQuestion(question);
                mapping.setSection(section);
                mapping.setPriority(100);
                mapping.setSourceType(SOURCE);
                companyQuestions.save(mapping);
            }
        }
    }
}
