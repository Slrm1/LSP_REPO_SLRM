package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for HOLIDAY customers.
 *
 * @author Selor
 */
public class HolidayDiscountStrategy implements DiscountStrategy {
    /**
     * Applies a 15% discount.
     *
     * @param price base purchase price
     * @return discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}

