package com.quiztool.view;

import com.quiztool.model.QuizTool;

import java.util.Scanner;

public abstract class Menu {
    protected final QuizTool quizTool;

    public Menu(QuizTool quizTool) {
        this.quizTool = quizTool;
    }

    abstract public void displayMenu();
}
