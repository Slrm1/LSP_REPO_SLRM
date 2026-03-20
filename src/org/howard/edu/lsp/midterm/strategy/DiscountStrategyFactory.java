package org.howard.edu.lsp.midterm.strategy;

/**
 * Factory for resolving a discount strategy by customer type.
 *
 * @author Selor
 */
public class DiscountStrategyFactory {
    /**
     * Returns the discount strategy for a customer type.
     *
     * @param customerType customer type string
     * @return matching strategy
     * @throws IllegalArgumentException when customer type is unsupported
     */
    public DiscountStrategy getStrategy(String customerType) {
        if ("REGULAR".equals(customerType)) {
            return new RegularDiscountStrategy();
        }
        if ("MEMBER".equals(customerType)) {
            return new MemberDiscountStrategy();
        }
        if ("VIP".equals(customerType)) {
            return new VipDiscountStrategy();
        }
        if ("HOLIDAY".equals(customerType)) {
            return new HolidayDiscountStrategy();
        }
        throw new IllegalArgumentException("Unsupported customer type: " + customerType);
    }
}

