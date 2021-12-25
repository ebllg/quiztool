package com.quiztool.model;

public class ShortAnswerQuestion extends Question{
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
}
