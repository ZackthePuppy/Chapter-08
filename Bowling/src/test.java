public class test {
    private int pins = 10;

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
        this.pins -= pins;
    }

}