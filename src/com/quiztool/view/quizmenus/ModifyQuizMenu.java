package com.quiztool.view.quizmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;

import java.util.Scanner;

public class ModifyQuizMenu extends Menu {

    private final int quizId;
    private final QuizQuestionsMenu quizQuestionsMenu;

    public ModifyQuizMenu(QuizTool quizTool, QuizQuestionsMenu quizQuestionsMenu, int quizId) {
        super(quizTool);
        this.quizId = quizId;
        this.quizQuestionsMenu = quizQuestionsMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("Enter a new name for the quiz:");
        String name = scan.nextLine();
        System.out.println("Enter a new duration for the quiz:");
        int duration = Integer.parseInt(scan.nextLine());
        quizTool.updateQuizDetails(quizId, name, duration);
        System.out.println("Quiz details updated.");

        quizQuestionsMenu.displayMenu();
    }
}
