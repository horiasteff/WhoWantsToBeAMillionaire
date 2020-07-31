package ro.jademy.millionaire.model;

import java.util.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
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

    private List<Question> difficultyZeroQuestions;
    private List<Question> difficultyOneQuestions;
    private List<Question> difficultyTwoQuestions;
    private List<Question> difficultyThreeQuestions;

    private List<Lifeline> lifelines = new ArrayList<>();
    int indexLevel = 0;
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

        boolean gameContinue = false;
        showWelcome();
        showRules();

        do {
            currentLevel = LEVELS.get(indexLevel);
            if (currentLevel.getDifficultyLevel() == 0) {
                List<Answer> questionAnswers = askQuestion(difficultyZeroQuestions, currentLevel);
                gameContinue = answerQuestion(difficultyZeroQuestions, questionAnswers);

            } else if (currentLevel.getDifficultyLevel() == 1) {
                List<Answer> questionAnswers = askQuestion(difficultyOneQuestions, currentLevel);
                gameContinue = answerQuestion(difficultyOneQuestions, questionAnswers);

            } else if (currentLevel.getDifficultyLevel() == 2) {
                List<Answer> questionAnswers = askQuestion(difficultyTwoQuestions, currentLevel);
                gameContinue = answerQuestion(difficultyTwoQuestions, questionAnswers);
            } else if (currentLevel.getDifficultyLevel() == 3) {
                List<Answer> questionAnswers = askQuestion(difficultyThreeQuestions, currentLevel);
                gameContinue = answerQuestion(difficultyThreeQuestions, questionAnswers);
                if (gameContinue) {
                    System.out.println("Congrats, you've WON : " + currentLevel.getReward() + " !!");
                    gameContinue = false;
                    break;
                }
            } else {
                System.out.println("No difficulty found for currentLevel");
            }

            if (gameContinue) {
                indexLevel++;
                System.out.println("Proceeding to next level: " + (currentLevel.getNumber()+1));
            }
        } while (gameContinue);
    }

    private List<Answer> askQuestion(List<Question> questionList, Level currentLevel) {
        System.out.println("Prize: " + currentLevel.getReward() + " \nCheckpoint reward: "
                + currentLevel.getRewardBreakout() + "\n");
        System.out.println(questionList.get(0).getText());

        List<Answer> allAnswers = new ArrayList<>(questionList.get(0).getWrongAnswers());
        allAnswers.add(random.nextInt(allAnswers.size()), questionList.get(0).getCorrectAnswer());
        printAnswers(allAnswers);

        return allAnswers;
    }

    private void printAnswers(List<Answer> answerList) {
        String middleEmptySpace = " ";
        int maxLength = 0;
        for (Answer answer : answerList) {
            if (answer.getText().length() > maxLength) {
                maxLength = answer.getText().length();
            }
        }
        for (int i = 0; i < answerList.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.printf("%-" + maxLength + "s", answerList.get(i).getText());
            if (i % 2 == 0) {
                System.out.print(middleEmptySpace);
            } else {
                System.out.println();
            }
        }
    }

    private boolean inputCase(int position, List<Answer> allAnswers, List<Question> questionList) {
        boolean isCorrectAnswer;
        if (allAnswers.get(position).getText().equals
                (questionList.get(0).getCorrectAnswer().getText())) {
            isCorrectAnswer = true;
            System.out.println("\nThat was CORRECT! \n");
            questionList.remove(0);
        } else {
            System.out.println("\nWRONG answer! \n");
            System.out.println("Your checkpoint reward is: " + currentLevel.getRewardBreakout());
            isCorrectAnswer = false;
        }
        return isCorrectAnswer;
    }

    private boolean inputSwitchCase(String choice, boolean helpUsed, List<Answer> allAnswers, List<Question> questionList) {
        boolean isCorrectAnswer = false;
        switch (choice) {
            case "1":
                isCorrectAnswer = inputCase(0, allAnswers, questionList);
                break;
            case "2":
                isCorrectAnswer = inputCase(1, allAnswers, questionList);
                break;
            case "3":
                isCorrectAnswer = inputCase(2, allAnswers, questionList);
                break;
            case "4":
                isCorrectAnswer = inputCase(3, allAnswers, questionList);
                break;
            case "H":
                if (!helpUsed && lifelines.size() > 0) {
                    lifelines.remove(0);
                    int wrongAnswerSize = questionList.get(0).getWrongAnswers().size();
                    String wrongAnswerString = questionList.get(0).getWrongAnswers().get(random.nextInt(wrongAnswerSize)).getText();

                    int indexCorrectAnswer = -1;
                    for (int i = 0; i < allAnswers.size(); i++) {
                        if (questionList.get(0).getCorrectAnswer().getText().equals(allAnswers.get(i).getText())) {
                            indexCorrectAnswer = i;
                        }
                    }
                    for (int i = 0; i < allAnswers.size(); i++) {
                        if (!allAnswers.get(i).getText().equals(wrongAnswerString) && i != indexCorrectAnswer) {
                            allAnswers.set(i, new Answer(""));
                        }
                    }
                    System.out.println(questionList.get(0).getText());
                    printAnswers(allAnswers);

                    choice = validInputAnswer(true);
                    isCorrectAnswer = inputSwitchCase(choice, true, allAnswers, questionList);
                }
                break;

            case "Q":
                currentLevel = LEVELS.get(indexLevel-1);
                System.out.println("Reward: " + currentLevel.getReward());
                isCorrectAnswer = false;
                break;
        }
        return isCorrectAnswer;
    }

    private void showWelcome() {
        System.out.println("***********************************************");
        System.out.println("** Welcome to Who Wants to be a Millionaire! **");
        System.out.println("***********************************************");
    }

    private boolean answerQuestion(List<Question> questionList, List<Answer> allAnswers) {
        boolean isCorrectAnswer;
        String choice = validInputAnswer(false);
        isCorrectAnswer = inputSwitchCase(choice, false, allAnswers, questionList);

        return isCorrectAnswer;
    }

    private String validInputAnswer(boolean helpUsed) {
        String input;
        boolean isValid = false;
        do {
            if (helpUsed) {
                System.out.println("[To answer questions, type 1, 2, 3 or 4] [H for Help Lifeline] [Q to Quit]");
            } else {
                System.out.println("[Choose an option by typing 1, 2, 3, 4 ] [H for Help Lifeline: "
                        + lifelines.size() + "] [Q to Quit] ");
            }

            input = scanner.nextLine();
            switch (input) {
                case "1":
                    input = "1";
                    isValid = true;
                    break;
                case "2":
                    input = "2";
                    isValid = true;
                    break;
                case "3":
                    input = "3";
                    isValid = true;
                    break;
                case "4":
                    input = "4";
                    isValid = true;
                    break;
                default:
                    if ((!input.equalsIgnoreCase("Q")) && (!input.equalsIgnoreCase("H"))) {
                        System.out.println("Invalid input! Please, try again with the valid ones explained below.");
                    }
                    break;
            }
            if (input.equalsIgnoreCase("H")) {
                if (helpUsed || lifelines.size() == 0) {
                    System.out.println("There are no more lifelines left to use!");
                } else {
                    input = "H";
                    isValid = true;
                }
            } else if (input.equalsIgnoreCase("Q")) {
                input = "Q";
                isValid = true;
            }
        } while (!isValid);
        return input;
    }

    private void showRules() {
        System.out.println("Rules: answer questions, win Money!");
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