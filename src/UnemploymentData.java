public class UnemploymentData {

    int civilian_labour_force;
    int employed_2016;
    int unemployed_2016;
    double unemployment_rate2016;

    public UnemploymentData(int civilian_labour_force, int employed_2016, int unemployed_2016, double unemployment_rate2016) {
        this.civilian_labour_force = civilian_labour_force;
        this.employed_2016 = employed_2016;
        this.unemployed_2016 = unemployed_2016;
        this.unemployment_rate2016 = unemployment_rate2016;
    }

    public int getCivilian_labour_force() {
        return civilian_labour_force;
    }

    public void setCivilian_labour_force(int civilian_labour_force) {
        this.civilian_labour_force = civilian_labour_force;
    }

    public int getEmployed_2016() {
        return employed_2016;
    }

    public void setEmployed_2016(int employed_2016) {
        this.employed_2016 = employed_2016;
    }

    public int getUnemployed_2016() {
        return unemployed_2016;
    }

    public void setUnemployed_2016(int unemployed_2016) {
        this.unemployed_2016 = unemployed_2016;
    }

    public double getUnemployment_rate2016() {
        return unemployment_rate2016;
    }

    public void setUnemployment_rate2016(double unemployment_rate2016) {
        this.unemployment_rate2016 = unemployment_rate2016;
    }
}
