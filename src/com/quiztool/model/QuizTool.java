package com.quiztool.model;

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

    public HashMap<String, String> getTopicQuestionDetails(int topicId, int questionId) {
        Topic topic = getTopicById(topicId);
        Question question = topic.getQuestionList().get(questionId);
        HashMap<String, String> questionDetails = new HashMap<>();
        questionDetails.put("name", question.getName());
        questionDetails.put("text", question.getName());
        questionDetails.put("points", Integer.toString(question.getPoints()));
        return questionDetails;
    }
}
