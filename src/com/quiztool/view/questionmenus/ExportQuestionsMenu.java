package com.quiztool.view.questionmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;
import com.quiztool.view.topicmenus.TopicQuestionsMenu;

import java.util.Scanner;

public class ExportQuestionsMenu extends Menu {

    private final int topicId;
    private final TopicQuestionsMenu topicQuestionsMenu;

    public ExportQuestionsMenu(QuizTool quizTool, TopicQuestionsMenu topicQuestionsMenu, int topicId) {
        super(quizTool);
        this.topicQuestionsMenu = topicQuestionsMenu;
        this.topicId = topicId;
    }

    @Override
    public void displayMenu() {
        System.out.println("******************************");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a filename with its type extension to export questions (e.g. myfile.txt)");
        String fileName = scan.nextLine();
        quizTool.exportQuestions(topicId, fileName);
        topicQuestionsMenu.displayMenu();
    }
}
