package com.quiztool.view;

import com.quiztool.domain.QuizTool;

public abstract class Menu {
    protected final QuizTool quizTool;

    public Menu(QuizTool quizTool) {
        this.quizTool = quizTool;
    }

    abstract public void displayMenu();
}
