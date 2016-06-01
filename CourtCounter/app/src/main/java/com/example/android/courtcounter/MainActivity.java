package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static int pointsTeamA = 0;
    static int pointsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void twoPointsTeamA(View view) {
        pointsTeamA += 2;
        displayForTeamA(pointsTeamA);
    }

    public void threePointsTeamA(View view) {
        pointsTeamA += 3;
        displayForTeamA(pointsTeamA);
    }

    public void onePointTeamA(View view) {
        pointsTeamA += 1;
        displayForTeamA(pointsTeamA);
    }

    public void resetTeams(View view) {
        pointsTeamA=0;
        pointsTeamB=0;
        displayForTeamA(pointsTeamA);
        displayForTeamB(pointsTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void twoPointsTeamB(View view) {
        pointsTeamB += 2;
        displayForTeamB(pointsTeamB);
    }

    public void threePointsTeamB(View view) {
        pointsTeamB += 3;
        displayForTeamB(pointsTeamB);
    }

    public void onePointTeamB(View view) {
        pointsTeamB += 1;
        displayForTeamB(pointsTeamB);
    }

}
