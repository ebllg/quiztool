package com.quiztool.domain;

import java.util.HashMap;

public class ShortAnswerQuestion extends Question {
    private String answer;

    public ShortAnswerQuestion(String name, String questionText, int points, String answer) {
        super(name, questionText, points);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public HashMap<String, String> getDetails() {
        HashMap<String, String> details = super.getDetails();
        details.put("answer", answer);
        return details;
    }
}
