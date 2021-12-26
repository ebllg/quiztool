package com.quiztool.domain;

public class QuestionChoice {
    private String choiceText;
    private boolean isCorrect;
    private char choiceChar;

    public QuestionChoice(String choiceText, char choiceChar, boolean isCorrect) {
        this.choiceText = choiceText;
        this.choiceChar = choiceChar;
        this.isCorrect = isCorrect;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setTrue(boolean aTrue) {
        isCorrect = aTrue;
    }

    public char getChoiceChar() {
        return choiceChar;
    }

    public void setChoiceChar(char choiceChar) {
        this.choiceChar = choiceChar;
    }
}
