package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for VIP customers.
 *
 * @author Selor
 */
public class VipDiscountStrategy implements DiscountStrategy {
    /**
     * Applies a 20% discount.
     *
     * @param price base purchase price
     * @return discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}

