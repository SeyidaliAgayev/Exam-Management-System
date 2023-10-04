package service;

import model.Questions;

import java.util.List;

public interface FileServiceInter {
    void writeQuestionAndAnswersToFile(Questions questions);
    List<Questions> readQuestionsAndAnswersFromFile();
    void writeLogToFile(String username, int examPoint);
}
