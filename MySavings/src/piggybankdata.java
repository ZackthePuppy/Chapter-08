public class piggybankdata {
    
    private float total;
    private float penny;
    private float nickel;
    private float dime;
    private float quarter;
    private float value;

    /**
     * @return float return the total
     */
    public void takeAll (float total, float penny, float nickel, float dime, float quarter) {
        this.total = total;
        this.penny = penny;
        this.nickel = nickel;
        this.dime = dime;
        this.quarter = quarter;

    }
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return float return the penny
     */
    public float getPenny() {
        return penny;
    }

    /**
     * @param penny the penny to set
     */
    public void setPenny(float penny) {
        this.penny += (penny/100);
        total += (penny/100);
    }

    public void subPenny(float penny) {
        this.penny -= (penny/100);
        total -= (penny/100);
    }

    /**
     * @return float return the nickel
     */
    public float getNickel() {
        return nickel;
    }

    /**
     * @param nickel the nickel to set
     */
    public void setNickel(float nickel, float value) {
        this.nickel += (nickel*value)/100;
        total += (nickel*5)/100;
    }

    public void subNickel(float nickel, float value) {
        this.nickel -= (nickel*value)/100;
        total -= (nickel*5)/100;
    }

    /**
     * @return float return the dime
     */
    public float getDime() {
        return dime;
    }

    /**
     * @param dime the dime to set
     */
    public void setDime(float dime, float value) {
        this.dime += (dime*value)/100;
        total += (dime*10)/100;
    }

    public void subDime(float dime, float value) {
        this.dime -= (dime*value)/100;
        total -= (dime*10)/100;
    }

    /**
     * @return float return the quarter
     */
    public float getQuarter() {
        return quarter;
    }

    /**
     * @param quarter the quarter to set
     */
    public void setQuarter(float quarter, float value) {
        this.quarter += (quarter*value)/100;
        total += (quarter*25)/100;
    }

    public void subQuarter(float quarter, float value) {
        this.quarter -= (quarter*value)/100;
        total -= (quarter*25)/100;
    }


    /**
     * @return float return the value
     */
    public float getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(float value) {
        this.value = value;
    }

}
