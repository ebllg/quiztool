package com.quiztool.domain;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private List<Question> questionList;
    private String name;

    public Topic(String name) {
        this.name = name;
        this.questionList = new ArrayList<>();
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addQuestion(Question question) {
        questionList.add(question);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

}
