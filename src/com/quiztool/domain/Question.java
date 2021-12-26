package com.quiztool.domain;

import java.util.HashMap;

public abstract class Question {
    private String name;
    private String questionText;
    private int points;

    public Question(String name, String questionText, int points) {
        this.name = name;
        this.questionText = questionText;
        this.points = points;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public HashMap<String, String> getDetails() {
        HashMap<String, String> details = new HashMap<>();
        details.put("name", name);
        details.put("text", questionText);
        details.put("points", Integer.toString(points));
        details.put("type", this.getClass().getSimpleName());
        return details;
    }
}
