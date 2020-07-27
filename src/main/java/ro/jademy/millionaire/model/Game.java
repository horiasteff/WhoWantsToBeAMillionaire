package ro.jademy.millionaire.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ro.jademy.millionaire.Main.getRandomQuestions;

public class Game {

    // 15 levels
    // 4 break points
    //      -> level [1, 5]    -> difficulty 0
    //      -> level [6, 10]   -> difficulty 1
    //      -> level [11, 14]  -> difficulty 2
    //      -> level 15        -> difficulty 3

    private static final List<Level> LEVELS = Arrays.asList(
            new Level(1, 0, 100, 0),
            new Level(2, 0, 200, 0),
            new Level(3, 0, 500, 0),
            new Level(4, 0, 700, 0),
            new Level(5, 0, 1000, 0),
            new Level(6, 1, 2000, 1000),
            new Level(7, 1, 4000, 1000),
            new Level(8, 1, 8000, 1000),
            new Level(9, 1, 16000, 1000),
            new Level(10, 1, 32000, 1000),
            new Level(11, 2, 64000, 32000),
            new Level(12, 2, 125000, 32000),
            new Level(13, 2, 250000, 32000),
            new Level(14, 2, 500000, 32000),
            new Level(15, 3, 1000000, 500000)
    );

    private List<Question> difficultyZeroQuestions = new ArrayList<Question>();
    private List<Question> difficultyOneQuestions = new ArrayList<Question>();
    private List<Question> difficultyTwoQuestions = new ArrayList<Question>();
    private List<Question> difficultyThreeQuestions = new ArrayList<Question>();

    private List<Lifeline> lifelines = new ArrayList<Lifeline>();
    private Level currentLevel = LEVELS.get(0);

    public Game(List<Question> difficultyZeroQuestions, List<Question> difficultyOneQuestions, List<Question> difficultyTwoQuestions, List<Question> difficultyThreeQuestions) {
        this.difficultyZeroQuestions = difficultyZeroQuestions;
        this.difficultyOneQuestions = difficultyOneQuestions;
        this.difficultyTwoQuestions = difficultyTwoQuestions;
        this.difficultyThreeQuestions = difficultyThreeQuestions;

        lifelines.add(new Lifeline("50-50"));
        lifelines.add(new Lifeline("50-50"));
        lifelines.add(new Lifeline("50-50"));
    }

    public void start() {

        //TODO
        //show welcome screen
        //optionally : show rules (rounds, lifelines, etc) &commands


        // show current level question
        // read command from player
        //   - if lifeline -> apply lifeline
        //   - if end game -> end game
        //   - read answer -> check answer
        //              - if answer correct -> go to next level (set next level as current, etc...)
        //              - if answer incorrect -> end game (calculate end sum, show bye bye message, play again, etc...)


        showWelcome();
        showRules();
        playGame();

    }

    private void playGame() {
        List<Question> questionForZero = getRandomQuestions(5, 0);
        List<Question> questionForOne = getRandomQuestions(5, 1);
        List<Question> questionForTwo = getRandomQuestions(4, 2);
        List<Question> questionForThree = getRandomQuestions(1, 3);

// get all the random question
        //TODO
        //TO SHOW THE QUESTION ONE BY ONE

        for (Question question : questionForZero) {
            System.out.println(question.getText());
        }
        System.out.println();

        for (Question question : questionForOne) {
            System.out.println(question.getText());
        }
       System.out.println();
        for (Question question : questionForTwo) {
            System.out.println(question.getText());
        }
        System.out.println();

        for (Question question : questionForThree) {
            System.out.println(question.getText());
        }
    }

    private void showWelcome() {
        System.out.println("Welcome to <<Who wants to be  millionaire?>>");
        System.out.println("Wanna play?");
    }

    private void showRules() {
        System.out.println("First, let's see what are the rules");
        System.out.println("You have 3 chances of 50-50");
        System.out.println("You can quit the game with the money you have at that moment");
        System.out.println("If you pass a level, you get for sure those money even if you lose");

    }
}