package com.quiztool.view;

import com.quiztool.model.QuizTool;

import java.util.HashMap;
import java.util.Scanner;

public class QuestionDetailsMenu extends Menu {

    private final int topicId;
    private final int questionId;
    private final TopicQuestionsMenu topicQuestionsMenu;

    public QuestionDetailsMenu(QuizTool quizTool, int topicId, int questionId, TopicQuestionsMenu topicQuestionsMenu) {
        super(quizTool);
        this.topicId = topicId;
        this.questionId = questionId;
        this.topicQuestionsMenu = topicQuestionsMenu;
    }

    @Override
    public void displayMenu() {
        System.out.println("******************************");
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> questionDetails = quizTool.getTopicQuestionDetails(topicId, questionId);

        System.out.println("Question name: " + questionDetails.get("name"));
        System.out.println("Question text: " + questionDetails.get("text"));
        System.out.println("Question answer: " + questionDetails.get("answer"));
        System.out.println("Question points: " + questionDetails.get("points"));

        System.out.println("Enter 'm' for modifying the question...");
        System.out.println("Enter 'd' for deleting the question...");
        System.out.println("Enter '0' to go back to the topic's questions menu...");

        String input = scan.nextLine();

        switch (input) {
            case "0":
                topicQuestionsMenu.displayMenu();
                break;
            case "m":
                System.out.println();
                break;
            case "d":
                System.out.println();
                break;
            default:
                System.out.println();
                break;
        }

    }
}
