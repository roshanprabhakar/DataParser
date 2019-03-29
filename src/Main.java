import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<UnemploymentData> results = Utils.parseUnemploymentDataVirginia("Unemployment.csv");
        for (UnemploymentData data : results) {
            System.out.println(data);
        }
    }
}
