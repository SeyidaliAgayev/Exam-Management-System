package exam.impl;

import exam.ExamServiceInter;
import model.Questions;
import service.impl.FileServiceImpl;

import java.util.List;
import java.util.Random;

import static util.InputUtil.*;

public class ExamServiceImpl implements ExamServiceInter {
    FileServiceImpl fileService = new FileServiceImpl();
    @Override
    public void startExam() {
        List<Questions> questionsList = fileService.readQuestionsAndAnswersFromFile();
        int point = 0;
        for (int i = 0; i < questionsList.size(); i++) {
            Questions questions = questionsList.get(i);

            if (!questions.isAsked()) {
                String answer = inputRequiredString(questions.getQuestion() + " -->> ");

                if (questions.getAnswer().equals(answer)) {
                    point++;
                }
                questions.setAsked(true);
            } else {
                i--;
            }
        }
        fileService.writeLogToFile("Student", point);
    }

    @Override
    public void addQuestions() {
        String question = inputRequiredString("Please insert question: ");
        String answer = inputRequiredString("Please insert answer: ");
        fileService.writeQuestionAndAnswersToFile(new Questions(question, answer));
    }
}
