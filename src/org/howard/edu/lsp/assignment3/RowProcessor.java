package org.howard.edu.lsp.assignment3;

import java.util.Optional;

/**
 * Coordinates parsing and transformation of a single input line and updates
 * ETL statistics.
 */
public class RowProcessor {
    private final RowParser parser;
    private final ProductTransformer transformer;

    /**
     * Constructs a row processor that uses the given parser and transformer.
     *
     * @param parser the parser used to convert lines into product records
     * @param transformer the transformer that applies business rules
     */
    public RowProcessor(RowParser parser, ProductTransformer transformer) {
        this.parser = parser;
        this.transformer = transformer;
    }

    /**
     * Processes a single input line. When the line is valid, a transformed CSV
     * line is returned; otherwise, ETL statistics are updated and {@code null}
     * is returned.
     *
     * @param line the raw input line
     * @param statistics the statistics object to update
     * @return the transformed CSV line, or {@code null} when the row is skipped
     */
    public String processLine(String line, ETLStatistics statistics) {
        if (line.trim().isEmpty()) {
            statistics.incrementRowsSkipped();
            return null;
        }

        Optional<ProductRecord> parsed = parser.parse(line);
        if (!parsed.isPresent()) {
            statistics.incrementRowsSkipped();
            return null;
        }

        TransformedProductRecord transformed = transformer.transform(parsed.get());
        statistics.incrementRowsTransformed();
        return transformed.toCsvLine();
    }
}

