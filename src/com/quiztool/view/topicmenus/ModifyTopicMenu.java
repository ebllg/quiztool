package com.quiztool.view.topicmenus;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.Menu;

import java.util.Scanner;

public class ModifyTopicMenu extends Menu {

    private final int topicId;
    private final TopicQuestionsMenu topicQuestionsMenu;

    public ModifyTopicMenu(QuizTool quizTool, TopicQuestionsMenu topicQuestionsMenu, int topicId){
        super(quizTool);
        this.topicId = topicId;
        this.topicQuestionsMenu = topicQuestionsMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("Enter a new name for the topic:");
        String input = scan.nextLine();
        quizTool.updateTopicName(topicId, input);
        System.out.println("Topic name updated.");

        topicQuestionsMenu.displayMenu();
    }
}
