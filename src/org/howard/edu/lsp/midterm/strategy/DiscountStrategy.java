package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for discount behavior.
 *
 * @author Selor
 */
public interface DiscountStrategy {
    /**
     * Applies a discount strategy to a base price.
     *
     * @param price base purchase price
     * @return final price after discount logic
     */
    double applyDiscount(double price);
}

