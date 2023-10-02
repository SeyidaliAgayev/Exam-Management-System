package service;

import java.util.List;

public interface FileServiceInter {
    void writeQuestionAndAnswersToFile(String questionAndAnswer);
    List<String> readQuestionsAndAnswersFromFile();
}
