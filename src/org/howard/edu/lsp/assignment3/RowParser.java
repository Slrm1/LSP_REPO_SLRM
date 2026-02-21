package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Parses a CSV line into a {@link ProductRecord} instance.
 */
public class RowParser {
    /**
     * Parses the given line into a {@link ProductRecord}.
     * <p>
     * The line is expected to contain exactly four comma-separated fields:
     * ProductID, Name, Price, Category. If the line is invalid, an empty
     * {@code Optional} is returned.
     * </p>
     *
     * @param line the CSV line to parse
     * @return an {@code Optional} containing a {@link ProductRecord} when parsing
     *         succeeds, or empty when the line is invalid
     */
    public Optional<ProductRecord> parse(String line) {
        String[] fields = line.split(",", -1);
        if (fields.length != 4) {
            return Optional.empty();
        }

        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i].trim();
        }

        int productID;
        try {
            productID = Integer.parseInt(fields[0]);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }

        String name = fields[1];

        BigDecimal price;
        try {
            price = new BigDecimal(fields[2]);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }

        String category = fields[3];
        ProductRecord record = new ProductRecord(productID, name, price, category);
        return Optional.of(record);
    }
}

