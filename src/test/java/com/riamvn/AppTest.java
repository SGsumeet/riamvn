package com.riamvn;

import junit.framework.Test;
import junit.framework.TestCase;

public class AppTest extends TestCase {

    public void test1() {
        String fileName = "src/TestFiles/test1.txt";
        TaxCalculator tx = new TaxCalculator(fileName);
        tx.getOrders(fileName);
        float actualSalesTax = tx.totalTaxCalculator(tx.items);
        float expectedSalesTax = 1.50f;
        assertEquals("correct tax amount shown", expectedSalesTax, actualSalesTax);
    }

    public void test11() {
        String fileName = "src/TestFiles/test1.txt";
        TaxCalculator tx = new TaxCalculator(fileName);
        tx.getOrders(fileName);
        float actualTotalPrice = tx.totalPriceCalculator(tx.items);
        float expectedTotalPrice = 29.85f;
        assertEquals("correct tax amount shown", expectedTotalPrice, actualTotalPrice);
    }

    public void test2() {
        String fileName = "src/TestFiles/test2.txt";
        TaxCalculator tx = new TaxCalculator(fileName);
        tx.getOrders(fileName);
        float actualSalesTax = tx.totalTaxCalculator(tx.items);
        float expectedSalesTax = 7.65f;
        assertEquals("correct tax amount shown", expectedSalesTax, actualSalesTax);
    }

    public void test22() {
        String fileName = "src/TestFiles/test2.txt";
        TaxCalculator tx = new TaxCalculator(fileName);
        tx.getOrders(fileName);
        float actualTotalPrice = tx.totalPriceCalculator(tx.items);
        float expectedTotalPrice = 65.17f;
        assertEquals("correct tax amount shown", expectedTotalPrice, actualTotalPrice);
    }

    public void test3() {
        String fileName = "src/TestFiles/test3.txt";
        TaxCalculator tx = new TaxCalculator(fileName);
        tx.getOrders(fileName);
        float actualSalesTax = tx.totalTaxCalculator(tx.items);
        float expectedSalesTax = 6.70f;
        assertEquals("correct tax amount shown", expectedSalesTax, actualSalesTax);
    }

    public void test33() {
        String fileName = "src/TestFiles/test3.txt";
        TaxCalculator tx = new TaxCalculator(fileName);
        tx.getOrders(fileName);
        float actualTotalPrice = tx.totalPriceCalculator(tx.items);
        float expectedTotalPrice = 74.69f;
        assertEquals("correct tax amount shown", expectedTotalPrice, actualTotalPrice);
    }
}
