package com.example.android.multiactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onGetNameClick(View view) {
        Intent getNameScreenIntent = new Intent(this,
                SecondScreen.class);

        final int result = 1;  // return the result of the other activity

        //we will send data, the data is MainActivity string, you can send
        //different types of data...
        //the name of this data is callingActivity
        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
        //launch the other activity - we wait a return value
        startActivityForResult(getNameScreenIntent, result);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //link the TextView
        TextView usersNameMessage = (TextView)
                findViewById(R.id.users_name_message);
        //Save the incoming String in a variable
        String nameSentBack = data.getStringExtra("UsersName");
        //Save the data in the TextView
        usersNameMessage.append(" " + nameSentBack);

    }


}
