import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
            System.out.println(data[i].replaceAll("\\s+","").length());
            String[] scores = split(data[i].replaceAll("\\s+", ""));
            System.out.println(scores.length);
            dataList.add(new ElectionResult(
                    (int) Double.parseDouble(scores[1]),
                    (int) Double.parseDouble(scores[2]),
                    (int) Double.parseDouble(scores[3]),
                    Double.parseDouble(scores[4]),
                    Double.parseDouble(scores[5]),
                    scores[6],
                    Double.parseDouble(scores[7].replaceAll("%","")) / 100,
                    scores[8],
                    scores[9],
                    Integer.parseInt(scores[10])
            ));
        }
        return null;
    }

    public static String[] split(String string) {
        String[] out = string.split(",");
        String[] toReturn = new String[11];
        String replacement = out[6] + out[7];
        for (int i = 0; i < toReturn.length; i++) {
            if (i < 6) {
                toReturn[i] = out[i];
            } else {
                toReturn[i] = out[i + 1];
            }
        }
        return toReturn;
    }
}

/**
 * 1, 2,  3, 4
 * 0, 1,  2, 3
 *
 * 1, 23, 4
 * 0, 1,  2
 */
