package com.quiztool.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class QuizTool implements Serializable {
    private List<Topic> topicList;
    private List<Quiz> quizList;

    public QuizTool() {
        this.topicList = new ArrayList<>() {
            {
                add(new Topic("default"));
            }
        };
        this.quizList = new ArrayList<>();
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public void deleteTopic(int topicId) {
        topicList.remove(topicId);
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

    public void exportQuestions(int topicId, String filename) {
        // TODO
        System.out.println("Export questions functionality is not implemented yet.");
    }

    public void importQuestions(int topicId, String filename) {
        // TODO
        System.out.println("Import questions functionality is not implemented yet.");
    }

    public int createQuiz(String quizName, int duration) {
        Quiz newQuiz = new Quiz(quizName, duration);
        quizList.add(newQuiz);
        return quizList.size() - 1;
    }

    public Quiz getQuizById(int quizId) {
        return quizList.get(quizId);
    }

    public void updateQuizDetails(int quizId, String quizName, int duration) {
        Quiz quiz = getQuizById(quizId);
        quiz.setName(quizName);
        quiz.setDuration(duration);
    }

    public void deleteQuiz(int quizId) {
        quizList.remove(quizId);
    }

    public void addQuestionToQuiz(int topicId, int questionId, int quizId) {
        Topic topic = getTopicById(topicId);
        Question question = topic.getQuestionList().get(questionId);
        Quiz quiz = quizList.get(quizId);
        quiz.getQuestionList().add(question);
    }

    public void removeQuestionFromQuiz(int questionId, int quizId) {
        Quiz quiz = quizList.get(quizId);
        quiz.getQuestionList().remove(questionId);
    }
}
