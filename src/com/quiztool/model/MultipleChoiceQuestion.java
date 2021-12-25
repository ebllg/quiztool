package com.quiztool.model;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<String> answer;
    private List<String> choices;

    public MultipleChoiceQuestion(String name, String questionText, int points, List<String> answer, List<String> choices) {
        super(name, questionText, points);
        this.answer = answer;
        this.choices = choices;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

}
