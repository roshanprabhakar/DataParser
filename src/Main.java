import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<ElectionResult> results = Utils.parseData();
        for (ElectionResult electionResult : results) {
            System.out.println(electionResult);
        }
    }
}
