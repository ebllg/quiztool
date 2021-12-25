package com.quiztool;

import com.quiztool.model.QuizTool;
import com.quiztool.view.MenuFacade;

public class Main {


    public static void main(String[] args) {
        QuizTool quizTool = new QuizTool();
        MenuFacade.getInstance().startQuizTool(quizTool);
    }
}
