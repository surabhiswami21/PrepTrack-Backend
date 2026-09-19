package com.preptrack.preptrack_backend.dto;

public record StatisticsResponse(
        long dsaSolved,
        long sqlQueries,
        long revisions,
        long plannerTotal,
        long plannerCompleted,
        long codingQuestions,
        long technicalQuestions,
        long hrQuestions
) {
}
