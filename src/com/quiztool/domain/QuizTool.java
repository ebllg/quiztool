package com.quiztool.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class QuizTool {
    private final List<Topic> topicList;

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

    public void deleteTopic(int topicId) {
        topicList.remove(topicId);
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

    public void createShortAnswerQuestion(int topicId, String questionText, String name, String answer, int points) {
        ShortAnswerQuestion question = new ShortAnswerQuestion(name, questionText, points, answer);
        Topic topic = getTopicById(topicId);
        topic.addQuestion(question);
    }

    public void createMultipleChoiceQuestion(int topicId, String questionText, String name, List<QuestionChoice> choices, int points) {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion(name, questionText, points, choices);
        Topic topic = getTopicById(topicId);
        topic.addQuestion(question);
    }

    public HashMap<String, String> getTopicQuestionDetails(int topicId, int questionId) {
        Topic topic = getTopicById(topicId);
        Question question = topic.getQuestionList().get(questionId);
        return question.getDetails();
    }

    public void deleteQuestion(int topicId, int questionId) {
        Topic topic = getTopicById(topicId);
        topic.getQuestionList().remove(questionId);
    }

    public void updateQuestionDetails(int topicId, int questionId, String name, String text, int points) {
        Topic topic = getTopicById(topicId);
        Question question = topic.getQuestionList().get(questionId);
        question.setName(name);
        question.setQuestionText(text);
        question.setPoints(points);
    }
}
