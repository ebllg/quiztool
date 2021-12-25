package com.quiztool.view;

import com.quiztool.model.QuizTool;

import java.util.Scanner;

public class AddQuestionMenu extends Menu {

    private final TopicQuestionsMenu topicQuestionsMenu;

    public AddQuestionMenu(QuizTool quizTool, TopicQuestionsMenu topicQuestionsMenu){
        super(quizTool);
        this.topicQuestionsMenu = topicQuestionsMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("Select a question type:");
        String[] questionTypes = {
                "(1) True/False",
                "(2) Short answer",
                "(3) Multiple choice",
        };
        for (String questionType : questionTypes) {
            System.out.println(questionType);
        }
        System.out.println("\nEnter '0' to go back to the topic's questions menu...");
        String input = scan.next();
        switch (input) {
            case "0":
                topicQuestionsMenu.displayMenu();
                break;
            case "1":
                System.out.println();
                break;
            case "2":
                System.out.println();
                break;
            case "3":
                System.out.println();
                break;
        }
        scan.close();
    }
}
