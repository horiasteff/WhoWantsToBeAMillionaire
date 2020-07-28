package ro.jademy.millionaire;

import ro.jademy.millionaire.data.QuestionProvider;
import ro.jademy.millionaire.model.Game;
import ro.jademy.millionaire.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


        // 1. define objects
        // define properties
        // define methods

        // 2. define interactions


        // initialize questions
        List<Question> difficultyZeroQuestions = getRandomQuestions(5, 0);
        List<Question> difficultyOneQuestions = getRandomQuestions(5, 1);
        List<Question> difficultyTwoQuestions = getRandomQuestions(4, 2);
        List<Question> difficultyThreeQuestions = getRandomQuestions(1, 3);

        // initialize game
        Game game = new Game(difficultyZeroQuestions, difficultyOneQuestions, difficultyTwoQuestions, difficultyThreeQuestions);

        // start the game
        game.start();
    }

    private static List<Question> getRandomQuestions(int nrOfQuestions, int difficulty) {
        // loop through all questions
        // get all questions of given difficulty
        // loop through sub-list until nrOfQuestions and select random items by index
        // return said list
        List<Question> questionsOfDiff = new ArrayList<>();
        List<Question> questionsRandom = new ArrayList<>();
        for (Question question : QuestionProvider.ALL_QUESTIONS) {
            if (question.getDifficulty() == difficulty) {
                questionsOfDiff.add(question);
            }
        }
        Random random = new Random();
        for (int i = 0; i < nrOfQuestions; i++) {
            int randomIndex = random.nextInt(questionsOfDiff.size());
            questionsRandom.add(questionsOfDiff.remove(randomIndex));
        }
        return questionsRandom;
    }

}