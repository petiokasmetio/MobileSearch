package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputUtil {

    private static File currentOutputDir = null;
    private static File logFile = null;

    /**
     * Save VIP, TOP, and unlabeled ad counts in new output_N directory
     *
     * @param vipCount     VIP ads
     * @param topCount     TOP ads
     * @param noLabelCount Ads without label
     * @return Absolute path to log file
     * @throws IOException if writing fails
     */
    public static String saveSearchResultsToFile(int vipCount, int topCount, int noLabelCount) throws IOException {
        initializeOutputDirectory();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, false))) { // overwrite
            writer.write("== Results from ad`s ==\n");
            writer.write("VIP ads: " + vipCount + "\n");
            writer.write("TOP ads: " + topCount + "\n");
            writer.write("Ads without label: " + noLabelCount + "\n");
            writer.write("Total ads: " + (vipCount + topCount + noLabelCount) + "\n");
        }

        return logFile.getAbsolutePath();
    }

    /**
     * Appends total search result count (e.g., 1883 from 'Обяви за VW') to current log
     *
     * @param totalResults total VW listings
     * @throws IOException if write fails
     */
    public static void appendTotalSearchResults(int totalResults) throws IOException {
        if (logFile == null) {
            initializeOutputDirectory(); // fallback if not set
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write("\n== Total VW search result ==\n");
            writer.write("Listings found: " + totalResults + "\n");
        }
    }

    /**
     * Creates new output_N directory and initializes log file
     */
    private static void initializeOutputDirectory() throws IOException {
        if (currentOutputDir != null) return;

        File baseDir = new File("output");
        if (!baseDir.exists()) {
            baseDir.mkdirs();
        }

        int dirIndex = 1;
        while (true) {
            File candidate = new File(baseDir, "output_" + dirIndex);
            if (!candidate.exists()) {
                candidate.mkdirs();
                currentOutputDir = candidate;
                break;
            }
            dirIndex++;
        }

        logFile = new File(currentOutputDir, "full_search_result_analysis.txt");
    }

    /**
     * Optional: For tests needing access to the directory
     */
    public static File getCurrentOutputDir() {
        return currentOutputDir;
    }
}
