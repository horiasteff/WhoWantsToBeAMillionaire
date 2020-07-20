package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private static final List<Level> LEVELS = Arrays.asList(
            new Level(1, 0, 100, 0),
            new Level(2, 0, 200, 0),
            new Level(3, 0, 500, 0),
            new Level(4, 0, 700, 0),
            new Level(5, 0, 1000, 0),
            new Level(6, 0, 2000, 1000),
            new Level(7, 0, 4000, 1000),
            new Level(8, 0, 8000, 1000),
            new Level(9, 0, 16000, 1000),
            new Level(10, 0, 32000, 10000),
            new Level(11, 0, 64000, 32000),
            new Level(12, 0, 125000, 32000),
            new Level(13, 0, 250000, 32000),
            new Level(14, 0, 500000, 32000),
            new Level(15, 0, 1000000, 500000)
    );

    // 15 question
    // 4 break points ->5, 10, 14, 15
    // level [1-5]    difficulty 0
    // level [6-10]   difficulty 1
    // level [11-14]  difficulty 2
    // level 15       difficulty 3

    private List<Question> difficultyZeroQuestionList = new ArrayList<Question>();
    private List<Question> difficultyOneQuestionList = new ArrayList<Question>();
    private List<Question> difficultyTwoQuestionList = new ArrayList<Question>();
    private List<Question> difficultyThreeQuestionList = new ArrayList<Question>();


    private Level currentLevel;

    private List<LifeLine> lifelines = new ArrayList<LifeLine>();
    private Level currentLevel = LEVELS.get(0);

    public Game(List<Question> difficultyZeroQuestionList, List<Question> difficultyOneQuestionList, List<Question> difficultyTwoQuestionList, List<Question> difficultyThreeQuestionList) {
        this.difficultyZeroQuestionList = difficultyZeroQuestionList;
        this.difficultyOneQuestionList = difficultyOneQuestionList;
        this.difficultyTwoQuestionList = difficultyTwoQuestionList;
        this.difficultyThreeQuestionList = difficultyThreeQuestionList;


    }
    lifelines.add(new LifeLine("50-50"));
    lifelines.add(new LifeLine("50-50"));
    lifelines.add(new LifeLine("50-50"));
}
