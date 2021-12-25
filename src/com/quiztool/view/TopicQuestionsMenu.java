package com.quiztool.view;

import com.quiztool.model.Question;
import com.quiztool.model.QuizTool;
import com.quiztool.model.Topic;

import java.util.List;
import java.util.Scanner;

public class TopicQuestionsMenu extends Menu {

    private final int topicId;
    private final TopicListMenu topicListMenu;

    public TopicQuestionsMenu(QuizTool quizTool, TopicListMenu topicListMenu, int topicId) {
        super(quizTool);
        this.topicId = topicId;
        this.topicListMenu = topicListMenu;
    }

    @Override
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        Topic topic = quizTool.getTopicById(topicId);
        System.out.println("Topic '" + topic.getName() + "'");
        List<Question> topicQuestions = topic.getQuestionList();
        if (topicQuestions.size() == 0) {
            System.out.println("=> This topic has no questions yet...");
        } else {
            System.out.println("Select a question:");
            for (int i = 0; i < topicQuestions.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + topicQuestions.get(i).getName());
            }
        }
        System.out.println();
        System.out.println("Enter 'a' for adding a question to the topic...");
        System.out.println("Enter 'm' for modifying the topic...");
        System.out.println("Enter 'd' for deleting the topic...");
        System.out.println("Enter '0' for topic list menu...");

        String input = scan.nextLine();

        switch (input) {
            case "0":
                topicListMenu.displayMenu();
                break;
            case "a":
                AddQuestionMenu addQuestionMenu = new AddQuestionMenu(quizTool, this, topicId);
                addQuestionMenu.displayMenu();
                break;
            case "m":
                ModifyTopicMenu modifyTopicMenu = new ModifyTopicMenu(quizTool, this, topicId);
                modifyTopicMenu.displayMenu();
                break;
            case "d":
                DeleteTopicMenu deleteTopicMenu = new DeleteTopicMenu(quizTool, topicListMenu, topicId);
                deleteTopicMenu.displayMenu();
                break;
            default:
                System.out.println();
                break;
        }
    }
}
