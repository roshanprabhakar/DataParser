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

    public static ArrayList<UnemploymentData> parseDataUnemployment(String file) {

        String[] results = readFileAsString("data" + File.separator + file).split("\n");
        ArrayList<UnemploymentData> dataList = new ArrayList<>();

        for (int j = 8; j < results.length; j++) {

            String line = "\"" + results[j].replaceAll("\\s+", "") + "\"";
            String[] finalToParse = parseCSVData(line);

            System.out.println(Arrays.toString(finalToParse));

        }

        return dataList;

    }

    public static ArrayList<EducationData> parseEducationData(String file) {

        String[] results = readFileAsString("data" + File.separator + file).split("\n");
        ArrayList<EducationData> dataList = new ArrayList<>();

        for (int j = 5; j < results.length; j++) {

            String line = "\"" + results[j].replaceAll("\\s+", "") + "\"";
            String[] finalToParse = parseCSVData(line);

            if (finalToParse[11].equals("") || finalToParse[12].equals("") || finalToParse[13].equals("") || finalToParse[14].equals("")) continue;
            dataList.add(new EducationData(
                    Double.parseDouble(finalToParse[11]),
                    Double.parseDouble(finalToParse[12]),
                    Double.parseDouble(finalToParse[13]),
                    Double.parseDouble(finalToParse[14])
            ));
        }

        return dataList;
    }

    //dealing with quotations
    private static String[] parseCSVData(String line) {

        ArrayList<Integer> quoteLocs = findQuotes(line); //always only pairs
        ArrayList<String> parts = new ArrayList<>();

        boolean middle = true; // if index is in middle of weird data
        for (int i = 0; i < quoteLocs.size() - 1; i++) {

            if (middle) {
                parts.add(line.substring(quoteLocs.get(i), quoteLocs.get(i + 1) + 1));
            } else {
                parts.add(line.substring(quoteLocs.get(i), quoteLocs.get(i + 1) + 1).replaceAll(",", ""));
            }
            middle = !middle;
        }

        String finalLine = "";
        for (int i = 0; i < parts.size(); i++) {
            if (parts.get(i).replaceAll(",","").equals("")) continue;
            finalLine += parts.get(i).replaceAll("\"", "");
        }

        String[] finalToParse = finalLine.split(","); //need 11, 12, 13, 14

        return finalToParse;
    }

    private static ArrayList<Integer> findQuotes(String line) {
        ArrayList<Integer> out = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '\"') out.add(i);
        }
        return out;
    }

    public static ArrayList<ElectionResult> parseElectionData(String file) {

        String[] results = readFileAsString("data" + File.separator + file).split("\n");
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
                    diff.replaceAll("\"", "").replaceAll(",", ""),
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