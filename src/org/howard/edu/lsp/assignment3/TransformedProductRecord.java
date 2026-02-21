package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a transformed product row that will be written to the
 * output CSV file.
 */
public class TransformedProductRecord {
    private final int productID;
    private final String name;
    private final BigDecimal price;
    private final String category;
    private final String priceRange;

    /**
     * Constructs a transformed product record.
     *
     * @param productID the product identifier
     * @param name the transformed product name
     * @param price the transformed price
     * @param category the transformed category
     * @param priceRange the calculated price range
     */
    public TransformedProductRecord(int productID, String name, BigDecimal price,
            String category, String priceRange) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = priceRange;
    }

    /**
     * Returns the product identifier.
     *
     * @return the product identifier
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Returns the transformed product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the transformed price.
     *
     * @return the transformed price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Returns the transformed category.
     *
     * @return the transformed category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the price range label.
     *
     * @return the price range label
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Formats this record as a CSV line compatible with the expected
     * output of the ETL pipeline.
     *
     * @return a CSV representation of this record
     */
    public String toCsvLine() {
        String formattedPrice = String.format("%.2f", price);
        return productID + "," + name + "," + formattedPrice + "," + category + "," + priceRange;
    }
}

