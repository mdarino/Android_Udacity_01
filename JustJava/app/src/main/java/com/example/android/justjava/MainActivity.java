package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {


    int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //  displayPrice(numberOfCoffees * 5);
        //String priceMessage = "Free";
        //displayMessage(priceMessage);
        int price = 5;
        int totalPrice = calculatePrice(numberOfCoffees, price);

        String Message= createOrderSummary(numberOfCoffees,totalPrice);

        displayMessage(Message);

    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void incrementOrder(View view) {
        numberOfCoffees++;
        displayQuantity(numberOfCoffees);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void decrementOrder(View view) {
        if (numberOfCoffees > 0)
            numberOfCoffees--;
        displayQuantity(numberOfCoffees);

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     * @param price    is the price of each coffee
     * @return price x quantity
     */
    private int calculatePrice(int quantity, int price) {
        return price * quantity;
    }


    /**
     * Calculates the price of the order.
     *
     * @param quantity   is the number of cups of coffee ordered
     * @param totalPrice is the total price quantity x price
     * @return message
     */

    private String createOrderSummary(int quantity, int totalPrice) {
        String priceMessage = "Name: Marcos \nQuantity:" + quantity + "\nTotal:$" + totalPrice + "\nThank you!!";
        return priceMessage;
    }


}