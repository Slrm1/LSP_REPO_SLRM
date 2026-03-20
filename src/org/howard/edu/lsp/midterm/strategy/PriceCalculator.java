package org.howard.edu.lsp.midterm.strategy;

/**
 * Calculates final price using Strategy Pattern.
 *
 * @author Selor
 */
public class PriceCalculator {
    private final DiscountStrategyFactory strategyFactory;

    /**
     * Constructs a price calculator with default strategy factory.
     */
    public PriceCalculator() {
        this.strategyFactory = new DiscountStrategyFactory();
    }

    /**
     * Calculates final price for a customer type and base price.
     *
     * @param customerType customer type (REGULAR, MEMBER, VIP, HOLIDAY)
     * @param price base purchase price
     * @return final discounted price
     */
    public double calculatePrice(String customerType, double price) {
        DiscountStrategy strategy = strategyFactory.getStrategy(customerType);
        return strategy.applyDiscount(price);
    }
}

