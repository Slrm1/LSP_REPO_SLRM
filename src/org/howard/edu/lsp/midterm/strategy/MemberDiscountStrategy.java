package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for MEMBER customers.
 *
 * @author Selor
 */
public class MemberDiscountStrategy implements DiscountStrategy {
    /**
     * Applies a 10% discount.
     *
     * @param price base purchase price
     * @return discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}

