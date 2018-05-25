package com.github.rstockbridge.flashcards;

public class Question {
    private String question;
    private String answer;

    Question(final String inputQuestion, final String inputAnswer) {
        question = inputQuestion;
        answer = inputAnswer;
    }

    public String getQuestionText() {
        return question;
    }

    public String getAnswerText() {
        return answer;
    }
}
