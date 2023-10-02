package service.impl;

import data.GlobalStrings;
import service.FileServiceInter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileServiceInter {
    @Override
    public void writeQuestionAndAnswersToFile(String questionAndAnswer) {
        File file = new File(GlobalStrings.filePath);
        try {
            OutputStream outputStream = new FileOutputStream(file, true);
            outputStream.write(questionAndAnswer.getBytes());
            outputStream.close();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    @Override
    public List<String> readQuestionsAndAnswersFromFile() {
        File file = new File(GlobalStrings.filePath);
        List<String> questionList = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = bufferedInputStream.readAllBytes();
            String questionFile = new String(bytes);

            String[] questionAndAnswers = questionFile.split("\n");
            for (int i = 0; i < questionAndAnswers.length; i++) {
                String[] questionAndAnswer = questionAndAnswers[i].split("-");
                if (questionAndAnswer.length == 2) {
                    String question = questionAndAnswer[0].trim();
                    String answer = questionAndAnswer[1].trim();

                    System.out.println("Question: " + question);
                    System.out.println("Answer: " + answer);

                    questionList.add(question);
                    questionList.add(answer);
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
