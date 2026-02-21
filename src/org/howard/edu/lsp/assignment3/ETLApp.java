package org.howard.edu.lsp.assignment3;

/**
 * Entry point for the Assignment 3 ETL application.
 */
public class ETLApp {
    /**
     * Runs the ETL pipeline using the object-oriented design for Assignment 3.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        ETLConfiguration configuration = new ETLConfiguration();
        ETLStatistics statistics = new ETLStatistics();
        RowParser parser = new RowParser();
        ProductTransformer transformer = new ProductTransformer();
        RowProcessor rowProcessor = new RowProcessor(parser, transformer);

        CsvETLRunner runner = new CsvETLRunner(configuration, rowProcessor, statistics);
        runner.run();
    }
}

