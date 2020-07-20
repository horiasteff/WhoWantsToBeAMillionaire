package ro.jademy.millionaire;

public class Level {
    private int number;
    private int reward;
    private int difficultyLevel;
    private int rewardBreakout;
    private int levelReward;

    public Level(int number, int reward, int difficultyLevel) {
        this.number = number;
        this.reward = reward;
        this.difficultyLevel = difficultyLevel;
    }

    public Level(int number, int difficultyLevel, int reward, int rewardBreakout) {
        this.number = number;
        this.reward = reward;
        this.difficultyLevel = difficultyLevel;
        this.rewardBreakout = rewardBreakout;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLevelReward() {
        return levelReward;
    }

    public void setLevelReward(int levelReward) {
        this.levelReward = levelReward;
    }

    public void setRewardBreakout(int rewardBreakout) {
        this.rewardBreakout = rewardBreakout;
    }

    public int getRewardBreakout() {
        return rewardBreakout;
    }
}
