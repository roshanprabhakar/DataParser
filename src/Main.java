import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<EducationData> results = Utils.parseEducationData("Education.csv");
        for (EducationData data : results) {
            System.out.println(data);
        }
    }
}
