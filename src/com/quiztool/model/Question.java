package com.quiztool.model;

public abstract class Question {
    private String name;
    private String questionText;
    private int points;

    public Question(String name, String questionText, int points) {
        this.name = name;
        this.questionText = questionText;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void printDetails() {
        System.out.println();
    }

}
