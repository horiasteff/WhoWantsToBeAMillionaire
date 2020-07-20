package ro.jademy.millionaire;
import java.util.ArrayList;
import java.util.List;

public class Question {

    private String text;
    private List<Answer> answers = new ArrayList<Answer>();
    private Answer correctAnswer;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
