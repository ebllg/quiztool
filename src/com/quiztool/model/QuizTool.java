package com.quiztool.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class QuizTool {
    private List<Topic> topicList;

    public QuizTool() {
        this.topicList = new ArrayList<>() {
            {
                add(new Topic("default"));
            }
        };
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public void addTopic(Topic topic) {
        topicList.add(topic);
    }

    public void deleteTopic(Topic topic) {
        topicList.remove(topic);
    }

    public List<Question> getTopicQuestions(int topicIndex) {
        Topic topic = topicList.get(topicIndex);
        return topic.getQuestionList();
    }

    public Topic getTopicById(int topicId) {
        return topicList.get(topicId);
    }

    public void updateTopicName(int topicId, String topicName) {
        Topic topic = getTopicById(topicId);
        topic.setName(topicName);
    }

    public int createTopic(String topicName) {
        Topic newTopic = new Topic(topicName);
        topicList.add(newTopic);
        return topicList.size() - 1;
    }

    public void createTrueFalseQuestion(int topicId, String questionText, String name, boolean answer, int points) {
        TrueFalseQuestion question = new TrueFalseQuestion(name, questionText, points, answer);
        Topic topic = getTopicById(topicId);
        topic.addQuestion(question);
    }
}
