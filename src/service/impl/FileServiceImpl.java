package service.impl;

import data.GlobalStrings;
import model.Questions;
import service.FileServiceInter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileServiceInter, Serializable {
    @Override
    public void writeQuestionAndAnswersToFile(Questions questions) {
        File file = new File(GlobalStrings.questionFilePath);
        try {
            OutputStream outputStream = new FileOutputStream(file, true);
            outputStream.write(questions.toString().getBytes());
            outputStream.close();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public void writeLogToFile(String username, int examPoint) {
        File file = new File(GlobalStrings.logFilePath);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("\n" + "Person with username: " + username + "\n" + "Exam Point: " + examPoint);

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    @Override
    public List<Questions> readQuestionsAndAnswersFromFile() {
        File file = new File(GlobalStrings.questionFilePath);
        List<Questions> questionList = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = bufferedInputStream.readAllBytes();
            String questionFile = new String(bytes);

            questionFile = questionFile.replaceAll("[\r]", "");
            String[] questionAndAnswers = questionFile.split("\n");


            for (String questionAndAnswer : questionAndAnswers) {
                String[] questionAnswer = questionAndAnswer.split("-");
                if (questionAnswer.length == 2) {
                    String question = questionAnswer[0];
                    String answer = questionAnswer[1];
                    Questions questions = new Questions(question, answer);
                    questionList.add(questions);
                }
            }
            bufferedInputStream.close();
            inputStream.close();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        return questionList;
    }

}
