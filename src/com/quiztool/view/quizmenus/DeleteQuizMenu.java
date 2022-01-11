package com.quiztool.view.quizmenus;

import com.quiztool.domain.Quiz;
import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;

import java.util.Scanner;

public class DeleteQuizMenu extends Menu {
    private final int quizId;
    private final QuizListMenu quizListMenu;

    public DeleteQuizMenu(QuizTool quizTool, QuizListMenu quizListMenu, int quizId) {
        super(quizTool);
        this.quizId = quizId;
        this.quizListMenu = quizListMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        Quiz quiz = quizTool.getQuizById(quizId);
        String quizName = quiz.getName();
        System.out.println("Are you sure you want to delete quiz '" + quizName + "' ? (y/n)");
        String input = scan.nextLine();
        if (input.equals("y")) {
            quizTool.deleteQuiz(quizId);
            System.out.println("Quiz '" + quizName + "' deleted successfully.");
            quizListMenu.displayMenu();
        } else if (input.equals("n")) {
            quizListMenu.displayMenu();
        }
    }
}
