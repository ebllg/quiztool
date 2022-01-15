package com.quiztool.view.quizmenus;


import com.quiztool.domain.Quiz;
import com.quiztool.domain.QuizTool;
import com.quiztool.view.MainMenu;
import com.quiztool.view.Menu;

import java.util.List;
import java.util.Scanner;

public class QuizListMenu extends Menu {

    private final MainMenu mainMenu;
    private final boolean isPreviewFlow;

    public QuizListMenu(QuizTool quizTool, MainMenu mainMenu, boolean isPreviewFlow) {
        super(quizTool);
        this.mainMenu = mainMenu;
        this.isPreviewFlow = isPreviewFlow;
    }

    private void printQuizList() {
        System.out.println("******************************");
        List<Quiz> quizList = quizTool.getQuizList();
        if (quizList.size() == 0) {
            System.out.println("=> There is no quizzes yet...");
        } else {
            System.out.println("Enter quiz number to select a quiz:");
            for (int i = 0; i < quizList.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + quizList.get(i).getName());
            }
        }
    }

    private void displayMenuForManageQuizzes() {
        Scanner scan = new Scanner(System.in);
        printQuizList();
        System.out.println("\nEnter 'a' for adding a new quiz...");
        System.out.println("Enter '0' for main menu...");

        String input = scan.nextLine();

        if (input.equals("0")) {
            mainMenu.displayMenu();
        } else if (input.equals("a")) {
            AddQuizMenu addQuizMenu = new AddQuizMenu(quizTool, this);
            addQuizMenu.displayMenu();
        } else {
            QuizQuestionsMenu quizQuestionsMenu = new QuizQuestionsMenu(quizTool, this, Integer.parseInt(input) - 1);
            quizQuestionsMenu.displayMenu();
        }
    }

    private void displayMenuForPreviewQuiz() {
        Scanner scan = new Scanner(System.in);
        printQuizList();
        System.out.println("Enter '0' for main menu...");

        String input = scan.nextLine();

        if (input.equals("0")) {
            mainMenu.displayMenu();
        } else {
            QuizQuestionsMenu quizQuestionsMenu = new QuizQuestionsMenu(quizTool, this, Integer.parseInt(input) - 1);
            quizQuestionsMenu.displayMenu();
        }
    }

    @Override
    public void displayMenu() {
        if (isPreviewFlow) {
            displayMenuForPreviewQuiz();
        } else {
            displayMenuForManageQuizzes();
        }
    }
}
