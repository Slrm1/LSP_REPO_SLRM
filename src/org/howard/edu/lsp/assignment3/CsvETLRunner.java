package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Executes the ETL process for the products CSV file by coordinating file I/O
 * and delegating line processing to a {@link RowProcessor}.
 */
public class CsvETLRunner {
    private final ETLConfiguration configuration;
    private final RowProcessor rowProcessor;
    private final ETLStatistics statistics;

    /**
     * Constructs a runner with the given configuration, row processor and
     * statistics tracker.
     *
     * @param configuration the configuration for file paths and header
     * @param rowProcessor the component responsible for processing each line
     * @param statistics the statistics object used to track processing counts
     */
    public CsvETLRunner(ETLConfiguration configuration,
            RowProcessor rowProcessor,
            ETLStatistics statistics) {
        this.configuration = configuration;
        this.rowProcessor = rowProcessor;
        this.statistics = statistics;
    }

    /**
     * Runs the ETL pipeline. The behavior, output, and error handling are
     * consistent with the Assignment 2 implementation.
     */
    public void run() {
        String inputFile = configuration.getInputFile();
        String outputFile = configuration.getOutputFile();

        if (!Files.exists(Paths.get(inputFile))) {
            System.err.println("Error: Input file '" + inputFile + "' not found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            writer.write(configuration.getHeader());
            writer.newLine();

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                statistics.incrementRowsRead();

                String transformedLine = rowProcessor.processLine(line, statistics);
                if (transformedLine != null) {
                    writer.write(transformedLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
            return;
        }

        statistics.printSummary(outputFile);
    }
}

