import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResult> parse2016PresidentialResults() {
        String resultsFile = readFileAsString("data" + File.separator + "2016_Presidential_Results.csv");
        String[] data = resultsFile.split("\n");
        ArrayList<ElectionResult> dataList = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            String[] scores = data[i].split(",");
            dataList.add(new ElectionResult(
               Integer.parseInt(scores[1]), Integer.parseInt(scores[2]), Integer.parseInt(scores[3]), Double.parseDouble(scores[4]), Double.parseDouble(scores[5]), scores[6], Double.parseDouble(scores[7]), scores[8], scores[9], Integer.parseInt(scores[10])
            ));
        }
        return null;
    }

}
