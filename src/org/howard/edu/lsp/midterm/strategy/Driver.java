package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver for Strategy Pattern pricing demonstration.
 *
 * @author Selor
 */
public class Driver {
    /**
     * Runs required pricing scenarios with purchase price of 100.0.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        double price = 100.0;

        System.out.println("REGULAR: " + calculator.calculatePrice("REGULAR", price));
        System.out.println("MEMBER: " + calculator.calculatePrice("MEMBER", price));
        System.out.println("VIP: " + calculator.calculatePrice("VIP", price));
        System.out.println("HOLIDAY: " + calculator.calculatePrice("HOLIDAY", price));
    }
}

