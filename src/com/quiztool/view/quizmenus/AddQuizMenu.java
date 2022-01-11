package com.quiztool.view.quizmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;

import java.util.Scanner;

public class AddQuizMenu extends Menu {

    private final QuizListMenu quizListMenu;

    public AddQuizMenu(QuizTool quizTool, QuizListMenu quizListMenu) {
        super(quizTool);
        this.quizListMenu = quizListMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("Enter a name:");
        String name = scan.nextLine();
        System.out.println("Enter duration:");
        int duration = Integer.parseInt(scan.nextLine());
        int topicId = quizTool.createQuiz(name, duration);
        System.out.println("New quiz created.");

        QuizQuestionsMenu quizQuestionsMenu = new QuizQuestionsMenu(quizTool, quizListMenu, topicId);
        quizQuestionsMenu.displayMenu();
    }
}
