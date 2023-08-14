package com.riamvn; // assignment 1 solution

import java.util.ArrayList;

public class TaxCalculator {
    public String fileName;

    public ArrayList<Item> items;

    TaxCalculator(String fileName) {
        getOrders(fileName);
    }

    public static void main(String[] args) throws Exception {
        String fileName = "src/TestFiles/OrderList.txt";
        TaxCalculator tcobj = new TaxCalculator(fileName);
        tcobj.PrintReceipt(tcobj.items);
    }

    public void PrintReceipt(ArrayList<Item> items) {

        float totalPrice = 0.0f;
        float totalTax = 0.0f;

        int length = items.size();
        System.out.println("------------------------------------------------");
        for (int i = 0; i < length; i++) {
            Item item = items.get(i);
            float item_tax = getRoundedOffValue(calculateTax(item));
            float item_price = Round((item.price + item_tax) * item.quantity);
            totalTax += item_tax * item.quantity;
            totalPrice += item_price;

            System.out.println(item.quantity + " " + item.name + " at " + item_price);
        }
        System.out.println("Sales Tax : " + getRoundedOffValue(totalTax));
        System.out.println("total : " + Round(totalPrice));
        System.out.println("------------------------------------------------");
    }

    public void getOrders(String fileName) {
        try {
            ReadOrder orders = new ReadOrder();
            items = orders.OrderReader(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float totalTaxCalculator(ArrayList<Item> items) {
        float totalTax = 0.0f;
        int length = items.size();
        for (int i = 0; i < length; i++) {
            Item item = items.get(i);
            float item_tax = getRoundedOffValue(calculateTax(item));

            totalTax += item_tax * item.quantity;
        }
        return totalTax;

    }

    public float totalPriceCalculator(ArrayList<Item> items) {
        float totalPrice = 0.0f;
        int length = items.size();
        for (int i = 0; i < length; i++) {
            Item item = items.get(i);
            float item_tax = getRoundedOffValue(calculateTax(item));
            float item_price = Round((item.price + item_tax) * item.quantity);

            totalPrice += item_price;
        }
        return Round(totalPrice);
    }

    public static float calculateTax(Item item) { // for each item
        float tax = 0.0f;
        if (item.isExempted()) { // if exempted item - book , medicine, food
            if (item.isImported()) { // if exempted but imported - 5% tax
                return item.price * 0.05f;
            } else // else exempted - 0 tax
                return tax;

        } else {
            if (item.isImported()) { // if not exempted and also imported - 10% as well as 5 %
                return (item.price * 0.1f + item.price * 0.05f);
            } else { // if not exempted and not imported - 10% local tax
                return (item.price * 0.1f);
            }
        }
    }

    private static float Round(float value) // simple round off function
    {
        value = (float) (Math.ceil((double) value * 100)) / 100;
        return value;
    }

    private static float getRoundedOffValue(float value) {// function ro round of to 0.05 amounts
        value = (float) Math.ceil((double) (value * 20));
        value /= 20;
        return value;
    }
}