package com.quiztool.view;

import com.quiztool.domain.QuizTool;
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
        };

        System.out.println("Select an operation:");
        for (String op : operations) {
            System.out.println(op);
        }
        System.out.println("\nEnter '0' for exiting...");
        String operation = scan.nextLine();

        if (operation.equals("1")) {
            topicListMenu.displayMenu();
        } else if (operation.equals("0")) {
            System.exit(0);
        } else {
            System.out.println("Invalid operation number.");
            System.out.println();
            displayMenu();
        }
    }
}
