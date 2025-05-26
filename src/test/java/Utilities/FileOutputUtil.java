package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputUtil {

    /**
     * Save result from search in output file and return path to the file
     *
     * @param vipCount       count VIP ads
     * @param topCount       count TOP ads
     * @param noLabelCount   count no label ads
     * @return absolut path to saved output file
     * @throws IOException in case error occur
     */
    public static String saveSearchResultsToFile(int vipCount, int topCount, int noLabelCount) throws IOException {
        // Define base output directory
        String baseOutputDirPath = "output";
        File baseDir = new File(baseOutputDirPath);

        if (!baseDir.exists()) {
            baseDir.mkdirs();
        }

        // Find next output directory: output_1, output_2, etc.
        int dirIndex = 1;
        File newDir;
        while (true) {
            newDir = new File(baseDir, "output_" + dirIndex);
            if (!newDir.exists()) {
                newDir.mkdirs();
                break;
            }
            dirIndex++;
        }

        // Create log file
        File logFile = new File(newDir, "full_search_result_analysis.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile))) {
            writer.write("== Results from ad`s ==\n");
            writer.write("VIP ads: " + vipCount + "\n");
            writer.write("TOP ads: " + topCount + "\n");
            writer.write("Ads without label: " + noLabelCount + "\n");
            writer.write("Total ads: " + (vipCount + topCount + noLabelCount) + "\n");
        }

        return logFile.getAbsolutePath();
    }
}

