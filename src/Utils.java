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

    public static ArrayList<ElectionResult> parseData() {

        String[] results = readFileAsString("data" + File.separator + "2016_Presidential_Results.csv").split("\n");
        ArrayList<ElectionResult> dataList = new ArrayList<>();

        String diff = "";
        String finalToParse = "";

        for (int i = 1; i < results.length; i++) {
            String line = results[i];

            if (quoteIndex(line, 1) != -1 && quoteIndex(line, 2) != -1) {
                diff = line.substring(quoteIndex(line, 1), quoteIndex(line, 2) + 1);
                finalToParse = removeDuplicates(line.substring(0, quoteIndex(line, 1)) +
                        line.substring(quoteIndex(line, 2) + 1).replaceAll("\\s+", ""), ',');
            }

            String[] scores = finalToParse.split(",");
            dataList.add(new ElectionResult(
                    (int) Double.parseDouble(scores[1]),
                    (int) Double.parseDouble(scores[2]),
                    (int) Double.parseDouble(scores[3]),
                    Double.parseDouble(scores[4]),
                    Double.parseDouble(scores[5]),
                    diff.replaceAll("\"", "").replaceAll(",",""),
                    Double.parseDouble(scores[6].replaceAll("%", "")) / 100,
                    scores[7],
                    scores[8],
                    Integer.parseInt(scores[9])
            ));

        }
        return dataList;
    }

    private static String removeDuplicates(String line, char regex) {
        String out = "";
        for (int i = 0; i < line.length() - 1; i++) {
            if (line.charAt(i) == regex && line.charAt(i + 1) == regex) {
                i++;
            }
            out += line.charAt(i);
        }
        return out;
    }

    private static int quoteIndex(String line, int count) {
        int quoteCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '"') {
                quoteCount++;
                if (quoteCount == count) {
                    return i;
                }
            }
        }
        return -1;
    }
}