package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a single product row read from the input CSV file
 * before any transformations are applied.
 */
public class ProductRecord {
    private final int productID;
    private final String name;
    private final BigDecimal price;
    private final String category;

    /**
     * Constructs a new product record.
     *
     * @param productID the product identifier
     * @param name the product name
     * @param price the original price
     * @param category the original category
     */
    public ProductRecord(int productID, String name, BigDecimal price, String category) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.category = category;
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
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product price.
     *
     * @return the product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Returns the product category.
     *
     * @return the product category
     */
    public String getCategory() {
        return category;
    }
}

