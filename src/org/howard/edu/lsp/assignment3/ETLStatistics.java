package org.howard.edu.lsp.assignment3;

/**
 * Tracks statistics for the ETL pipeline, including how many rows
 * were read, transformed, and skipped.
 */
public class ETLStatistics {
    private int rowsRead;
    private int rowsTransformed;
    private int rowsSkipped;

    /**
     * Increments the count of non-header rows read from the input file.
     */
    public void incrementRowsRead() {
        rowsRead++;
    }

    /**
     * Increments the count of successfully transformed rows written to output.
     */
    public void incrementRowsTransformed() {
        rowsTransformed++;
    }

    /**
     * Increments the count of rows that were skipped due to validation errors
     * or because they were blank.
     */
    public void incrementRowsSkipped() {
        rowsSkipped++;
    }

    /**
     * Returns the number of non-header rows that were read.
     * 
     * @return the number of rows read
     */
    public int getRowsRead() {
        return rowsRead;
    }

    /**
     * Returns the number of rows that were successfully transformed.
     * 
     * @return the number of transformed rows
     */
    public int getRowsTransformed() {
        return rowsTransformed;
    }

    /**
     * Returns the number of rows that were skipped.
     * 
     * @return the number of skipped rows
     */
    public int getRowsSkipped() {
        return rowsSkipped;
    }

    /**
     * Prints a summary of ETL processing statistics to standard output.
     * The format matches the Assignment 2 implementation.
     * 
     * @param outputFile the path to the output file that was written
     */
    public void printSummary(String outputFile) {
        System.out.println("=== ETL Pipeline Summary ===");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file: " + outputFile);
    }
}

