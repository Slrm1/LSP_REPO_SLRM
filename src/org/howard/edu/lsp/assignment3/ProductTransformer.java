package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Applies the business rules that transform an input {@link ProductRecord}
 * into a {@link TransformedProductRecord}.
 */
public class ProductTransformer {
    /**
     * Transforms the given product record according to the rules from
     * Assignment 2.
     *
     * @param record the input product record
     * @return the transformed product record
     */
    public TransformedProductRecord transform(ProductRecord record) {
        String transformedName = record.getName().toUpperCase();

        String originalCategory = record.getCategory();

        BigDecimal transformedPrice = record.getPrice();
        if ("Electronics".equals(originalCategory)) {
            transformedPrice = transformedPrice.multiply(new BigDecimal("0.9"));
        }

        transformedPrice = transformedPrice.setScale(2, RoundingMode.HALF_UP);

        String transformedCategory = originalCategory;
        if (transformedPrice.compareTo(new BigDecimal("500.00")) > 0
                && "Electronics".equals(originalCategory)) {
            transformedCategory = "Premium Electronics";
        }

        String priceRange = determinePriceRange(transformedPrice);

        return new TransformedProductRecord(
                record.getProductID(),
                transformedName,
                transformedPrice,
                transformedCategory,
                priceRange);
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
}

