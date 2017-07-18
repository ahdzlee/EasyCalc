package tech.hyperdev.easycalc.controllers;

/**
 * A class that manages basic arithmetic operations.
 */
public class CalculatorController {

    /**
     * Checks if the input is valid or not.
     */
    public boolean isValid(String input) {
        return input != null && input.length() > 0;
    }

    /**
     * Adds two numbers and returns sum.
     */
    public double add(double n1, double n2) {
        return n1 + n2;
    }

    /**
     * Subtracts two numbers and returns difference.
     */
    public double subtract(double n1, double n2) {
        return n1 + n2;
    }

    /**
     * Multiplies two numbers and returns product.
     */
    public double multiply(double n1, double n2) {
        return n1 * n2;
    }

    /**
     * Divides two numbers and returns quotient.
     */
    public double divide(double n1, double n2) {
        return n1 / n2;
    }

    /**
     * Format the result into 3-comma separated digits and to 2-decimal digits and returns the
     * formatted string.
     */
    public String format(double result) {
        return String.format("%,.2f", result);
    }
}
