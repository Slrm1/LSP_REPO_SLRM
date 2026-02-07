package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.*;

public class ETLPipeline {
    
    private static final String INPUT_FILE = "data/products.csv";
    private static final String OUTPUT_FILE = "data/transformed_products.csv";
    private static final String HEADER = "ProductID,Name,Price,Category,PriceRange";
    
    private int rowsRead = 0;
    private int rowsTransformed = 0;
    private int rowsSkipped = 0;
    
    public static void main(String[] args) {
        ETLPipeline pipeline = new ETLPipeline();
        pipeline.run();
    }
    
    private void run() {
        // Check if input file exists
        if (!Files.exists(Paths.get(INPUT_FILE))) {
            System.err.println("Error: Input file '" + INPUT_FILE + "' not found.");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            
            // Write header
            writer.write(HEADER);
            writer.newLine();
            
            String line;
            boolean firstLine = true;
            
            while ((line = reader.readLine()) != null) {
                // Skip header line
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                
                // Count non-header lines
                rowsRead++;
                
                // Handle blank lines
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }
                
                // Parse and process row
                String[] fields = line.split(",", -1);
                
                // Check field count
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }
                
                // Trim all fields
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].trim();
                }
                
                // Parse ProductID
                int productID;
                try {
                    productID = Integer.parseInt(fields[0]);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }
                
                String name = fields[1];
                
                // Parse Price
                BigDecimal price;
                try {
                    price = new BigDecimal(fields[2]);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }
                
                String category = fields[3];
                
                // Transform the row
                String transformedRow = transformRow(productID, name, price, category);
                writer.write(transformedRow);
                writer.newLine();
                rowsTransformed++;
            }
            
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
            return;
        }
        
        // Print summary
        printSummary();
    }
    
    private String transformRow(int productID, String name, BigDecimal price, String category) {
        // Transform 1: Convert name to UPPERCASE
        String transformedName = name.toUpperCase();
        
        // Store original category for Premium Electronics check
        String originalCategory = category;
        
        // Transform 2: Apply 10% discount if Electronics
        BigDecimal transformedPrice = price;
        if ("Electronics".equals(category)) {
            transformedPrice = price.multiply(new BigDecimal("0.9"));
        }
        
        // Round to 2 decimal places (round-half-up)
        transformedPrice = transformedPrice.setScale(2, RoundingMode.HALF_UP);
        
        // Transform 3: Change category to Premium Electronics if conditions met
        String transformedCategory = category;
        if (transformedPrice.compareTo(new BigDecimal("500.00")) > 0 && "Electronics".equals(originalCategory)) {
            transformedCategory = "Premium Electronics";
        }
        
        // Transform 4: Determine PriceRange based on final rounded price
        String priceRange = determinePriceRange(transformedPrice);
        
        // Format price with exactly 2 decimal places
        String formattedPrice = String.format("%.2f", transformedPrice);
        
        return productID + "," + transformedName + "," + formattedPrice + "," + transformedCategory + "," + priceRange;
    }
    
    private String determinePriceRange(BigDecimal price) {
        BigDecimal low = new BigDecimal("10.00");
        BigDecimal medium = new BigDecimal("100.00");
        BigDecimal high = new BigDecimal("500.00");
        
        if (price.compareTo(low) <= 0) {
            return "Low";
        } else if (price.compareTo(medium) <= 0) {
            return "Medium";
        } else if (price.compareTo(high) <= 0) {
            return "High";
        } else {
            return "Premium";
        }
    }
    
    private void printSummary() {
        System.out.println("=== ETL Pipeline Summary ===");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file: " + OUTPUT_FILE);
    }
}