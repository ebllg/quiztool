package com.quiztool.view.questionmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;
import com.quiztool.view.topicmenus.TopicQuestionsMenu;

import java.util.Scanner;

public class ImportQuestionsMenu extends Menu {

    private final int topicId;
    private final TopicQuestionsMenu topicQuestionsMenu;

    public ImportQuestionsMenu(QuizTool quizTool, TopicQuestionsMenu topicQuestionsMenu, int topicId) {
        super(quizTool);
        this.topicQuestionsMenu = topicQuestionsMenu;
        this.topicId = topicId;
    }

    @Override
    public void displayMenu() {
        System.out.println("******************************");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a filename with its type extension to import questions from (e.g. myfile.txt)");
        String fileName = scan.nextLine();
        quizTool.importQuestions(topicId, fileName);
        topicQuestionsMenu.displayMenu();
    }
}
