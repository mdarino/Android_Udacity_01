package com.example.android.multiactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mdarino on 12/6/2016.
 */
public class SecondScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for the layout we created
        setContentView(R.layout.second_layout);

        // Get the Intent that called for this Activity to open

        Intent activityThatCalled = getIntent();

        // Get the data that was sent

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        TextView callingActivityMessage = (TextView)
                findViewById(R.id.calling_activity_info_text_view);

        callingActivityMessage.append(" " + previousActivity);
    }


    public void onSendUsersName(View view) {

        //link the edit text
        EditText usersNameET = (EditText)
                findViewById(R.id.users_name_edit_text);
        //Take the value of the string inside the EditText
        String usersName = String.valueOf(usersNameET.getText());

        //create a new Intent to go back to the MainActivity
        Intent  goingBack = new Intent();

        //Send the name of the user...
        goingBack.putExtra("UsersName", usersName);

        //go back
        setResult(RESULT_OK, goingBack);

        //close this activity
        finish();

    }
}
