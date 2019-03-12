public class EducationData {
    double noHSDiploma;
    double onlyHSDiploma;
    double someCollege;
    double bachellorsOrHigher;

    public EducationData(double noHSDiploma, double onlyHSDiploma, double someCollege, double bachellorsOrHigher) {
        this.noHSDiploma = noHSDiploma;
        this.onlyHSDiploma = onlyHSDiploma;
        this.someCollege = someCollege;
        this.bachellorsOrHigher = bachellorsOrHigher;
    }

    public double getNoHSDiploma() {
        return noHSDiploma;
    }

    public void setNoHSDiploma(double noHSDiploma) {
        this.noHSDiploma = noHSDiploma;
    }

    public double getOnlyHSDiploma() {
        return onlyHSDiploma;
    }

    public void setOnlyHSDiploma(double onlyHSDiploma) {
        this.onlyHSDiploma = onlyHSDiploma;
    }

    public double getSomeCollege() {
        return someCollege;
    }

    public void setSomeCollege(double someCollege) {
        this.someCollege = someCollege;
    }

    public double getBachellorsOrHigher() {
        return bachellorsOrHigher;
    }

    public void setBachellorsOrHigher(double bachellorsOrHigher) {
        this.bachellorsOrHigher = bachellorsOrHigher;
    }

    public String toString() {
        return "noHSDiploma: " + noHSDiploma + " onlyHSDiploma: " + onlyHSDiploma + " someCollege: " + someCollege + " bachellorsOrHigher: " + bachellorsOrHigher;
    }
}
