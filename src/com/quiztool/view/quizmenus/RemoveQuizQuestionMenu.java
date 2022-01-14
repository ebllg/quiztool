package com.quiztool.view.quizmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;

import java.util.Scanner;

public class RemoveQuizQuestionMenu extends Menu {

    private final QuizQuestionsMenu quizQuestionsMenu;

    public RemoveQuizQuestionMenu(QuizTool quizTool, QuizQuestionsMenu quizQuestionsMenu){
        super(quizTool);
        this.quizQuestionsMenu = quizQuestionsMenu;
    }

    @Override
    public void displayMenu() {
        quizQuestionsMenu.printQuizQuestions();
        int quizId = quizQuestionsMenu.getQuizId();
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter question number to remove question from the quiz, enter '0' for finishing:");
        int input;
        input = Integer.parseInt(scan.nextLine());
        while (input != 0) {
            quizTool.removeQuestionFromQuiz(input - 1, quizId);
            System.out.println("Question (" + input + ") removed from the quiz.");
            System.out.println();
            quizQuestionsMenu.printQuizQuestions();
            System.out.println("\nEnter question number to remove question from the quiz, enter '0' for finishing:");
            input = Integer.parseInt(scan.nextLine());
        }
        quizQuestionsMenu.displayMenu();
    }
}
