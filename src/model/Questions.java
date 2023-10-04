package model;

import java.io.Serializable;

public class Questions implements Serializable {
    private String question;
    private String answer;
    private boolean isAsked;

    public Questions() {
    }

    public Questions(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isAsked() {
        return isAsked;
    }

    public void setAsked(boolean asked) {
        isAsked = asked;
    }

    @Override
    public String toString() {
        return "\n" + "Question: " + question + "\n" +
                "Answer: " + answer;
    }
}
