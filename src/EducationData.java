public class EducationData {
    int noHSDiploma;
    int onlyHSDiploma;
    int someCollege;
    int bachellorsOrHigher;

    public EducationData(int noHSDiploma, int onlyHSDiploma, int someCollege, int bachellorsOrHigher) {
        this.noHSDiploma = noHSDiploma;
        this.onlyHSDiploma = onlyHSDiploma;
        this.someCollege = someCollege;
        this.bachellorsOrHigher = bachellorsOrHigher;
    }

    public int getNoHSDiploma() {
        return noHSDiploma;
    }

    public void setNoHSDiploma(int noHSDiploma) {
        this.noHSDiploma = noHSDiploma;
    }

    public int getOnlyHSDiploma() {
        return onlyHSDiploma;
    }

    public void setOnlyHSDiploma(int onlyHSDiploma) {
        this.onlyHSDiploma = onlyHSDiploma;
    }

    public int getSomeCollege() {
        return someCollege;
    }

    public void setSomeCollege(int someCollege) {
        this.someCollege = someCollege;
    }

    public int getBachellorsOrHigher() {
        return bachellorsOrHigher;
    }

    public void setBachellorsOrHigher(int bachellorsOrHigher) {
        this.bachellorsOrHigher = bachellorsOrHigher;
    }
}
