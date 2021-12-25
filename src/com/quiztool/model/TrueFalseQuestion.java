package com.quiztool.model;

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

}
