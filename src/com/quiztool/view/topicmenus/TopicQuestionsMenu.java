package com.quiztool.view.topicmenus;

import com.quiztool.domain.Question;
import com.quiztool.domain.QuizTool;
import com.quiztool.domain.Topic;
import com.quiztool.view.Menu;
import com.quiztool.view.questionmenus.AddQuestionMenu;
import com.quiztool.view.questionmenus.ExportQuestionsMenu;
import com.quiztool.view.questionmenus.ImportQuestionsMenu;
import com.quiztool.view.questionmenus.QuestionDetailsMenu;
import com.quiztool.view.quizmenus.QuizQuestionsMenu;

import java.util.List;
import java.util.Scanner;

public class TopicQuestionsMenu extends Menu {

    private final int topicId;
    private final TopicListMenu topicListMenu;
    private final QuizQuestionsMenu quizQuestionsMenu;

    public TopicQuestionsMenu(QuizTool quizTool, TopicListMenu topicListMenu, int topicId) {
        super(quizTool);
        this.topicId = topicId;
        this.topicListMenu = topicListMenu;
        this.quizQuestionsMenu = null;
    }

    public TopicQuestionsMenu(QuizTool quizTool, TopicListMenu topicListMenu, int topicId, QuizQuestionsMenu quizQuestionsMenu) {
        super(quizTool);
        this.topicId = topicId;
        this.topicListMenu = topicListMenu;
        this.quizQuestionsMenu = quizQuestionsMenu;
    }

    private void printTopicQuestions() {

    }

    private void displayTopicQuestions() {
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        Topic topic = quizTool.getTopicById(topicId);
        System.out.println("Topic '" + topic.getName() + "'");
        List<Question> topicQuestions = topic.getQuestionList();
        if (topicQuestions.size() == 0) {
            System.out.println("=> This topic has no questions yet...");
        } else {
            System.out.println("Enter question number to select a question:");
            for (int i = 0; i < topicQuestions.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + topicQuestions.get(i).getName());
            }
        }
        System.out.println();
        System.out.println("Enter 'a' for adding a question to the topic...");
        System.out.println("Enter 'm' for modifying the topic...");
        System.out.println("Enter 'd' for deleting the topic...");
        System.out.println("Enter 'e' for exporting questions from the topic...");
        System.out.println("Enter 'i' for importing questions to the topic...");
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
            case "e":
                ExportQuestionsMenu exportQuestionsMenu = new ExportQuestionsMenu(quizTool, this, topicId);
                exportQuestionsMenu.displayMenu();
                break;
            case "i":
                ImportQuestionsMenu importQuestionsMenu = new ImportQuestionsMenu(quizTool, this, topicId);
                importQuestionsMenu.displayMenu();
                break;
            default:
                QuestionDetailsMenu questionDetailsMenu = new QuestionDetailsMenu(quizTool, topicId, Integer.parseInt(input) - 1, this);
                questionDetailsMenu.displayMenu();
                break;
        }
    }

    private void displayTopicQuestionsForAddQuizQuestion() {
        assert quizQuestionsMenu != null;
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************");
        Topic topic = quizTool.getTopicById(topicId);
        System.out.println("Topic '" + topic.getName() + "'");
        List<Question> topicQuestions = topic.getQuestionList();
        if (topicQuestions.size() == 0) {
            System.out.println("=> This topic has no questions yet...");
        } else {
            System.out.println("Enter question number to select a question:");
            for (int i = 0; i < topicQuestions.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + topicQuestions.get(i).getName());
            }
            int input;

            input = Integer.parseInt(scan.nextLine());

            if (input == 0) {
                quizQuestionsMenu.displayMenu();
            } else {
                quizTool.addQuestionToQuiz(topicId, input - 1, quizQuestionsMenu.getQuizId());
                System.out.println("Question (" + input + ") added to the quiz.");
            }


        }
        System.out.println();
    }

    @Override
    public void displayMenu() {
        if (quizQuestionsMenu != null) {
            displayTopicQuestionsForAddQuizQuestion();
        } else {
            displayTopicQuestions();
        }
    }
}
