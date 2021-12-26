package com.quiztool;

import com.quiztool.domain.QuizTool;
import com.quiztool.view.MenuFacade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static final String storageFileName = "objects.dat";
    public static QuizTool quizTool;

    public static void loadQuizTool() {
        try {
            FileInputStream file = new FileInputStream(storageFileName);
            ObjectInputStream stream = new ObjectInputStream(file);
            try {
                quizTool = (QuizTool) stream.readObject();
            } finally {
                stream.close();
            }
        } catch (Exception e) {
            System.out.println("Data cannot be loaded. Program will start with empty data.");
            quizTool = new QuizTool();
        }
    }

    public static void saveQuizTool() throws Exception {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(storageFileName));
        try {
            stream.writeObject(quizTool);
        } finally {
            stream.close();
        }
    }

    public static void main(String[] args) {
        loadQuizTool();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                saveQuizTool();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
        MenuFacade.getInstance().startQuizTool(quizTool);
    }
}
