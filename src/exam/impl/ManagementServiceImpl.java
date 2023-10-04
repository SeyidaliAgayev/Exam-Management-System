package exam.impl;

import exam.ManagementServiceInter;
import static util.MenuUtil.*;

public class ManagementServiceImpl implements ManagementServiceInter {
    ExamServiceImpl examService = new ExamServiceImpl();
    @Override
    public void examManagement() {
        while (true) {
            int option = entryMenu();
            switch (option) {
                case 0:
                    System.exit(-1);
                case 1:
                    examService.startExam();
                    break;
                case 2:
                    examService.addQuestions();
                    break;
                default:
                    System.err.println("Wrong input!");
            }
        }
    }
}
