package ro.jademy.millionaire;

import ro.jademy.millionaire.data.QuestionProvider;
import ro.jademy.millionaire.model.Game;
import ro.jademy.millionaire.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        // 1.  define objects
        // define properties
        // define methods

        // 2. define interactions

        //start game

        //initialize question
        List<Question> difficultyZeroQuestions = getRandomQuestion(5,0);
        List<Question> difficultyOneQuestions = getRandomQuestion(5,1);
        List<Question> difficultyTwoQuestions = getRandomQuestion(4,2);
        List<Question> difficultyThreeQuestions = getRandomQuestion(1,3);

        //initialize game
        Game game = new Game(difficultyZeroQuestions,difficultyOneQuestions,difficultyTwoQuestions,difficultyThreeQuestions);

        //start the game
        //game.start();
    }
    private static List<Question> getRandomQuestion(int nrOfQuestion, int difficulty){
        //loop through all question
        // get all question of given difficulty
        //loop through sub-list until nrOfQuestion and select random items by index
        //return said list


        List<Question> questionOfDiff = new ArrayList<>();
        List<Question> questionRandom = new ArrayList<>();
        for(Question question : QuestionProvider.ALL_QUESTIONS){
            if(question.getDifficulty() == difficulty){
                questionOfDiff.add(question);
            }
        }

        Random random = new Random();
        for (int i = 0; i < nrOfQuestion; i++) {
            int randomIndex = random.nextInt(questionOfDiff.size());
            questionRandom.add(questionOfDiff.remove(randomIndex));
        }
        return questionRandom;
    }
}