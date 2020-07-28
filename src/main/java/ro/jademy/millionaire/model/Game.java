package ro.jademy.millionaire.model;

import java.util.*;

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

    private List<Question> difficultyZeroQuestions = new ArrayList<>();
    private List<Question> difficultyOneQuestions = new ArrayList<>();
    private List<Question> difficultyTwoQuestions = new ArrayList<>();
    private List<Question> difficultyThreeQuestions = new ArrayList<>();

    private List<Lifeline> lifelines = new ArrayList<>();
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

        // TODO
        // show welcome screen
        // optionally: show rules (rounds, lifelines, etc) & commands

        // show current level question
        // read command from player
        //     - if lifeline -> apply lifeline
        //     - if end game -> end game
        //     - read answer -> check answer
        //               - if answer correct -> go to next level (set next level as current, etc.)
        //               - if answer incorrect -> end game (calculate end sum, show bye bye message etc.)


        showWelcome();
        showRules();

        showQuestion();
    }

    private void showWelcome() {
        System.out.println("Welcome to Who Wants to be a Millionaire");
    }

    private void showRules() {
        System.out.println("Rules: answer questions, win money!");
    }

    private void showQuestion() {
        Question question;
        List<Answer> allAnswers;

        switch (currentLevel.getDifficultyLevel()) {
            case 0:
                question = difficultyZeroQuestions.get(0);
                allAnswers = printQuestion(question);
                System.out.println();
                System.out.println("Applying lifeline:");
                applyLifeline(lifelines.get(0), allAnswers, question.getCorrectAnswer());

                // TODO
                // let's assume user responded with apply lifeline
                // do all validation beforehand

                break;
            case 1:
                question = difficultyOneQuestions.get(0);
                allAnswers = printQuestion(question);
                applyLifeline(lifelines.get(0), allAnswers, question.getCorrectAnswer());
                break;
            case 2:
                question = difficultyTwoQuestions.get(0);
                allAnswers = printQuestion(question);
                applyLifeline(lifelines.get(0), allAnswers, question.getCorrectAnswer());
                break;
            case 3:
                question = difficultyThreeQuestions.get(0);
                allAnswers = printQuestion(question);
                applyLifeline(lifelines.get(0), allAnswers, question.getCorrectAnswer());
                break;
            default:
                System.out.println("Unknown difficulty level");
                break;
        }
    }

    private List<Answer> printQuestion(Question question) {
        System.out.println(question.getText());
        System.out.println();

        List<Answer> allAnswers = new ArrayList<>(question.getWrongAnswers());
        allAnswers.add(question.getCorrectAnswer());
        // randomize list
        Collections.shuffle(allAnswers);

        for (int i = 0; i < allAnswers.size(); i++) {
            System.out.println(((char) (65 + i)) + ". " + allAnswers.get(i).getText());
        }

        return allAnswers;
    }

    private void applyLifeline(Lifeline lifeline, List<Answer> allAnswers, Answer correctAnswer) {

        if (lifeline.getName().equals("50-50")) {
            // print all answers except two random WRONG answers
            Random rnd = new Random();
            List<Answer> answerListCopy = new ArrayList<>(allAnswers);
            answerListCopy.remove(correctAnswer);
            answerListCopy.remove(rnd.nextInt(answerListCopy.size()));
            answerListCopy.remove(rnd.nextInt(answerListCopy.size()));

            for (int i = 0; i < allAnswers.size(); i++) {
                Answer answer = allAnswers.get(i);
                if (answer.equals(correctAnswer) || answerListCopy.contains(answer)) {
                    System.out.println(((char) (65 + i)) + ". " + allAnswers.get(i).getText());
                } else {
                    System.out.println(((char) (65 + i)) + ". ");
                }
            }
        }

        lifeline.setUsed(true);
    }
}