import exam.impl.ExamServiceImpl;
import exam.impl.ManagementServiceImpl;
import model.Questions;
import service.impl.FileServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*
        School-Managament proyektine integrasiya etmek üçün Exam managament proyekti yazılacaq. (Libary kimi daha sonra School-Managament proyektine elave olunacaq)
Tələblər :

1.Sual Əlav etmək imkanı - istifadəçi sual əlavə edib daha sonra cavabları əlavə edəcək (4 variant olacaq sadecə A B C D variantları) daha sonra isə düzgün variant hansıdır onu seçəcək (Qeyd : bunu sadecə admin edə bilər və login falan yazmağa ehtiyac yoxdur School managament proyektinde login hissəsi onsuzda mövcuddur)

2. Suallar və cavabları faylda save olunmalıdır hemçinin daha sonra fileadan oxunacaq ve Listlərə yazılacaq

3. StartExam() methodu bu method vasitəsilə 3 dəqiqəlik bir imtahan başlanılacaq və 10 sualdan ibarət olacaqdır (suallar random olaraq seçiləcək)

4.İmtahan bitdikdə istifadəçinin(yəni studentin) neçe suala düzgün cavab verdiyi , imtahanı neçe dq-də bitirdiyi və s ətraflı məlumatları fayla yazan method

əlavə hissələrə dərsdə yazdıqca baxacağıq əlavə methodlarda lazım olacaqdır
         */
        ManagementServiceImpl managementService = new ManagementServiceImpl();
        managementService.examManagement();
//        FileServiceImpl fileService = new FileServiceImpl();
//        List<Questions> questions = fileService.readQuestionsAndAnswersFromFile();
//        for (Questions question : questions) {
//            System.out.println(question);
//        }
    }
}