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
        System.out.println("Edit question details:");

        HashMap<String, String> questionDetails = quizTool.getTopicQuestionDetails(topicId, questionId);
        String input = scan.nextLine();

        System.out.println("Question updated successfully");
        questionDetailsMenu.displayMenu();
    }
}
