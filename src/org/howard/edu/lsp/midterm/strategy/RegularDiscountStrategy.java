package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for REGULAR customers.
 *
 * @author Selor
 */
public class RegularDiscountStrategy implements DiscountStrategy {
    /**
     * Returns the unchanged price.
     *
     * @param price base purchase price
     * @return unchanged price
     */
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}

