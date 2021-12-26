package com.quiztool.view.questionmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;

import java.util.HashMap;
import java.util.Scanner;

public class ModifyQuestionMenu extends Menu {

    private final int topicId;
    private final int questionId;
    private final QuestionDetailsMenu questionDetailsMenu;

    public ModifyQuestionMenu(QuizTool quizTool, QuestionDetailsMenu questionDetailsMenu, int topicId, int questionId) {
        super(quizTool);
        this.topicId = topicId;
        this.questionId = questionId;
        this.questionDetailsMenu = questionDetailsMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("Edit question details. Editable fields are: name, text, points.\n");

        System.out.println("Enter a new question name:");
        String name = scan.nextLine();

        System.out.println("Enter a new question text:");
        String text = scan.nextLine();

        System.out.println("Enter a new question point:");
        String points = scan.nextLine();

        quizTool.updateQuestionDetails(topicId, questionId, name, text, Integer.parseInt(points));

        System.out.println("Question updated successfully");
        questionDetailsMenu.displayMenu();
    }
}
