package com.quiztool.domain;

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
}
