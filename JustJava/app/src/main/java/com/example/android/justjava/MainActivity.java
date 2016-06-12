package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    boolean milk = false;
    boolean chocolate = false;
    int numberOfCoffees = 0;
    String Name ="Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {



        //Complete the check box options
        CheckBox checkboxMilk = (CheckBox) findViewById(R.id.checkboxMilk);
        milk = checkboxMilk.isChecked();
        CheckBox checkboxChoco = (CheckBox) findViewById(R.id.checkboxChoco);
        chocolate = checkboxChoco.isChecked();



        //Calculate the price
        int price = 5;
        if(milk)
            price +=1;
        if(chocolate)
            price +=2;
        int totalPrice = calculatePrice(numberOfCoffees, price);

        //Save the name in a global variable
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        Name = editTextName.getText().toString();;



        //Show the message

        String Message = createOrderSummary(numberOfCoffees, totalPrice);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order to" + Name);
        intent.putExtra(Intent.EXTRA_TEXT, Message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        //displayMessage(Message);

    }




    /**
     * This method is called when the increment button is clicked.
     */
    public void incrementOrder(View view) {
        if(numberOfCoffees<100)
            numberOfCoffees++;
        displayQuantity(numberOfCoffees);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void decrementOrder(View view) {
        if (numberOfCoffees > 0)
            numberOfCoffees--;
        Toast.makeText(this,"Text to show",Toast.LENGTH_SHORT).show();
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
        String priceMessage = "Name: " + Name
                                + "\nMilk: " + milk
                                + "\nChocolate: " + chocolate
                                + "\nQuantity: " + quantity
                                + "\nTotal: $" + totalPrice
                                + "\nThank you!!";
        return priceMessage;
    }


}