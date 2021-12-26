package com.quiztool.view.questionmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;
import com.quiztool.view.topicmenus.TopicQuestionsMenu;

import java.util.HashMap;
import java.util.Scanner;

public class DeleteQuestionMenu extends Menu {

    private final int topicId;
    private final int questionId;
    private final TopicQuestionsMenu topicQuestionsMenu;

    public DeleteQuestionMenu(QuizTool quizTool, TopicQuestionsMenu topicQuestionsMenu, int topicId, int questionId) {
        super(quizTool);
        this.topicId = topicId;
        this.questionId = questionId;
        this.topicQuestionsMenu = topicQuestionsMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");

        HashMap<String, String> questionDetails = quizTool.getTopicQuestionDetails(topicId, questionId);
        String questionName = questionDetails.get("name");
        System.out.println("Are you sure you want to delete question '" + questionName + "' ? (y/n)");

        String input = scan.nextLine();

        if (input.equals("y")) {
            quizTool.deleteQuestion(topicId, questionId);
            System.out.println("Question '" + questionName + "' deleted successfully.");
            topicQuestionsMenu.displayMenu();
        } else if (input.equals("n")) {
            topicQuestionsMenu.displayMenu();
        }
    }
}
