package com.quiztool.domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<QuestionChoice> choices;

    public MultipleChoiceQuestion(String name, String questionText, int points, List<QuestionChoice> choices) {
        super(name, questionText, points);
        this.choices = choices;
    }

    public List<QuestionChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<QuestionChoice> choices) {
        this.choices = choices;
    }

    @Override
    public HashMap<String, String> getDetails() {
        HashMap<String, String> details = super.getDetails();
        StringBuilder allChoices = new StringBuilder();
        StringBuilder correctChoiceChars = new StringBuilder();

        for (QuestionChoice choice : choices) {
            allChoices.append(choice.getChoiceChar()).append(") ").append(choice.getChoiceText()).append("\n");
            if (choice.isCorrect()) {
                correctChoiceChars.append(choice.getChoiceChar()).append(" ");
            }
        }

        details.put("allChoices", allChoices.toString());
        details.put("correctChoiceChars", correctChoiceChars.toString());

        return details;
    }

    @Override
    public void printQuestion() {
        System.out.println(getQuestionText() + " Select all that apply:");
        for(QuestionChoice choice: getChoices()){
            System.out.println("(" + choice.getChoiceChar() + ") " + choice.getChoiceText());
        }
    }

    private int getCorrectMarkingPoints() {
        int numOfCorrectChoices = 0;
        for(QuestionChoice ch: choices) {
            if (ch.isCorrect()) {
                numOfCorrectChoices +=1;
            }
        }
        return getPoints()/numOfCorrectChoices;
    }

    private int getWrongMarkingPoints() {
        int numOfWrongChoices = 0;
        for(QuestionChoice ch: choices) {
            if (ch.isCorrect()) {
                numOfWrongChoices +=1;
            }
        }
        return getPoints()/numOfWrongChoices;
    }

    private List<String> getCorrectChoiceChars() {
        List<String> correctChoices = new ArrayList<>();
        for(QuestionChoice ch: choices) {
            if (ch.isCorrect()) {
                correctChoices.add(String.valueOf(ch.getChoiceChar()));
            }
        }
        return correctChoices;
    }

    @Override
    public int calculateGrade(String answer) {
        int totalGrade = 0;
        String[] givenChars = answer.split("\\s+");
        List<String> correctChoices = getCorrectChoiceChars();
        for (String ch: givenChars) {
            if (correctChoices.contains(ch)) {
                totalGrade += getCorrectMarkingPoints();
            } else {
                totalGrade -= getWrongMarkingPoints();
            }
        }
        return totalGrade;
    }
}
