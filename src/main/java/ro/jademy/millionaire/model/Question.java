package ro.jademy.millionaire.model;

import ro.jademy.millionaire.model.Answer;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String text;
    private List<Answer> wrongAnswers = new ArrayList<Answer>();
    private Answer correctAnswer;
    private int difficulty;

    public Question(String text, List<Answer> wrongAnswers, Answer correctAnswer, int difficulty) {
        this.text = text;
        this.wrongAnswers = wrongAnswers;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(List<Answer> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
