package util;
import static util.InputUtil.*;

public class MenuUtil {
    public static int entryMenu() {
        System.out.println("""
                           <0> -->> [Finish Program!]
                           <1> -->> [Start Exam!]
                           <2> -->> [Add Questions!]
                           """
        );
        return inputRequiredInt("Choose an option: ");
    }
}
