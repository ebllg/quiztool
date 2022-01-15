package com.quiztool.view;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.quizmenus.QuizListMenu;
import com.quiztool.view.topicmenus.TopicListMenu;

import java.util.Scanner;


public class MainMenu extends Menu {

    private final TopicListMenu topicListMenu;

    public MainMenu(QuizTool quizTool) {
        super(quizTool);
        topicListMenu = new TopicListMenu(quizTool, this);
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("***** QUIZ TOOL *****\n");

        String[] operations = {
                "(1) Manage question bank",
                "(2) Manage quizzes",
                "(3) Preview quiz",
        };

        System.out.println("Enter operation number to select an operation:");
        for (String op : operations) {
            System.out.println(op);
        }
        System.out.println("\nEnter '0' for exiting...");
        String operation = scan.nextLine();

        QuizListMenu quizListMenu;

        switch (operation) {
            case "1":
                topicListMenu.displayMenu();
                break;
            case "2":
                quizListMenu = new QuizListMenu(quizTool, this, false);
                quizListMenu.displayMenu();
                break;
            case "3":
                quizListMenu = new QuizListMenu(quizTool, this, true);
                quizListMenu.displayMenu();
                break;
            case "0":
                System.exit(0);
            default:
                System.out.println("Invalid operation number.");
                System.out.println();
                displayMenu();
                break;
        }
    }
}
