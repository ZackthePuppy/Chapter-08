public class bowlingdata {
    private int player;
    private String score = "";
    private String frameScore = "";
    private int totalScore;
    private int pins = 10;
    private int failScore = 0;

    /**
     * @return int return the player
     */
    public int getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(int player) {
        this.player = player;
    }

    /**
     * @return String return the score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(String score) {
        this.score += "\t" + score;
    }

    /**
     * @return int return the pins
     */

    /**
     * @param pins the pins to set
     */

    /**
     * @return int return the totalScore
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * @return int return the failScore
     */

    /**
     * @param failScore the failScore to set
     */

    /**
     * @return String return the frameScore
     */
    public String getFrameScore() {
        return frameScore;
    }

    /**
     * @param frameScore the frameScore to set
     */
    public void setFrameScore(String frameScore) {
        this.frameScore = frameScore;
    }

    /**
     * @return int return the pins
     */
    public int getPins() {
        return pins;
    }

    /**
     * @param pins the pins to set
     */
    public void setPins(int pins) {
        this.pins = pins;
    }

    /**
     * @return int return the failScore
     */
    public int getFailScore() {
        return failScore;
    }

    /**
     * @param failScore the failScore to set
     */
    public void setFailScore(int failScore) {
        this.failScore = failScore;
    }

}
