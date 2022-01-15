package com.quiztool.domain;

import java.util.HashMap;

public class TrueFalseQuestion extends Question {
    private boolean answer;

    public TrueFalseQuestion(String name, String questionText, int points, boolean answer) {
        super(name, questionText, points);
        this.answer = answer;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public HashMap<String, String> getDetails() {
        HashMap<String, String> details = super.getDetails();
        details.put("answer", String.valueOf(answer));
        return details;
    }

    @Override
    public void printQuestion() {
        System.out.println(getQuestionText() + "(T/F)");
    }
}
