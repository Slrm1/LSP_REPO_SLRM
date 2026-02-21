package org.howard.edu.lsp.assignment3;

/**
 * Configuration values for the ETL pipeline.
 * 
 * <p>This class encapsulates the file paths and header used by the
 * Assignment 3 ETL implementation so that configuration is kept
 * separate from processing logic.</p>
 */
public class ETLConfiguration {
    private final String inputFile;
    private final String outputFile;
    private final String header;

    /**
     * Constructs the default configuration for the ETL pipeline using the
     * relative file paths and header required by the assignment.
     */
    public ETLConfiguration() {
        this.inputFile = "data/products.csv";
        this.outputFile = "data/transformed_products.csv";
        this.header = "ProductID,Name,Price,Category,PriceRange";
    }

    /**
     * Returns the relative path to the input CSV file.
     * 
     * @return the input file path
     */
    public String getInputFile() {
        return inputFile;
    }

    /**
     * Returns the relative path to the transformed output CSV file.
     * 
     * @return the output file path
     */
    public String getOutputFile() {
        return outputFile;
    }

    /**
     * Returns the CSV header that must be written to the output file.
     * 
     * @return the header line
     */
    public String getHeader() {
        return header;
    }
}

