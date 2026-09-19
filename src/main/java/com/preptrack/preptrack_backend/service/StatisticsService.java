package com.preptrack.preptrack_backend.service;

import com.preptrack.preptrack_backend.dto.StatisticsResponse;
import com.preptrack.preptrack_backend.entity.User;
import com.preptrack.preptrack_backend.repository.CompanyQuestionRepository;
import com.preptrack.preptrack_backend.repository.DsaProgressRepository;
import com.preptrack.preptrack_backend.repository.RevisionRepository;
import com.preptrack.preptrack_backend.repository.SqlProgressRepository;
import com.preptrack.preptrack_backend.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    private final DsaProgressRepository dsa;
    private final SqlProgressRepository sql;
    private final RevisionRepository revisions;
    private final TaskRepository tasks;
    private final CompanyQuestionRepository questions;

    public StatisticsService(DsaProgressRepository dsa, SqlProgressRepository sql,
                             RevisionRepository revisions, TaskRepository tasks,
                             CompanyQuestionRepository questions) {
        this.dsa = dsa;
        this.sql = sql;
        this.revisions = revisions;
        this.tasks = tasks;
        this.questions = questions;
    }

    public StatisticsResponse get(User user) {
        long dsaSolved = dsa.findAllByUserOrderByIdAsc(user).stream()
                .mapToLong(item -> (long) item.getEasy() + item.getMedium() + item.getHard()).sum();
        long sqlQueries = sql.findAllByUserOrderByIdAsc(user).stream()
                .mapToLong(item -> item.getQueryCount()).sum();
        var planner = tasks.findAllByUserOrderByIdAsc(user);
        long codingQuestions = questions.findAll().stream()
                .filter(item -> "CODING".equalsIgnoreCase(item.getSection())).count();
        long technicalQuestions = questions.findAll().stream()
                .filter(item -> "TECHNICAL_INTERVIEW".equalsIgnoreCase(item.getSection())).count();
        long hrQuestions = questions.findAll().stream()
                .filter(item -> "HR".equalsIgnoreCase(item.getSection())).count();
        return new StatisticsResponse(dsaSolved, sqlQueries, revisions.findAllByUserOrderByIdAsc(user).size(),
                planner.size(), planner.stream().filter(com.preptrack.preptrack_backend.entity.Task::isDone).count(),
                codingQuestions, technicalQuestions, hrQuestions);
    }
}
