package com.example.joaquin.flashcards;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * @authors Joaquin Bautista, Rexhep Hertica, Tobin Pomeroy, Stephen Teacher
 * This is the start up class which lists the type of categories and the
 * difficulty for the user to choose from to challenge themselves if they get better
 * at answering the easier flash card questions, once they pick their difficulty
 * and category they get access to the flash card questions to answer.
 */

public class HomeActivity extends FragmentActivity {

    RadioGroup difficultyGroup;
    RadioButton easyRadio, mediumRadio, hardRadio;
    String diffKey = "difficulty";

    /*
        This the main method to create the home page of the difficulty radio buttons
        and the category buttons along with their functionality.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        pickAnimals();
        pickHuman();
        pickCars();
        pickMath();

        difficultyGroup = (RadioGroup)findViewById(R.id.difficulty_group);
        difficultyGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                easyRadio = (RadioButton)findViewById(R.id.easy_radio);
                mediumRadio = (RadioButton)findViewById(R.id.medium_radio);
                hardRadio = (RadioButton)findViewById(R.id.hard_radio);

                if(mediumRadio.isChecked()) {
                    diffKey = "medium";
                } else if(hardRadio.isChecked()) {
                    diffKey = "hard";
                } else {
                    diffKey = "easy";
                }

            }

        });

    }

    /*
        The following four methods below will access the specific category flash card
        questions and answers with their difficulty based on the user's choice.
     */

    public void pickAnimals() {

        Button animalsButton = (Button)findViewById(R.id.animals_button);
        animalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FlashCardActivity.class);
                intent.putExtra(Integer.toString(R.string.key), "animals");
                intent.putExtra(Integer.toString(R.string.diff_key), diffKey);
                HomeActivity.this.startActivity(intent);
            }
        });
    }

    public void pickHuman() {

        Button humanButton = (Button)findViewById(R.id.human_button);
        humanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FlashCardActivity.class);
                intent.putExtra(Integer.toString(R.string.key), "humans");
                intent.putExtra(Integer.toString(R.string.diff_key), diffKey);
                HomeActivity.this.startActivity(intent);
            }
        });
    }

    public void pickCars() {

        Button carsButton = (Button)findViewById(R.id.cars_button);
        carsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FlashCardActivity.class);
                intent.putExtra(Integer.toString(R.string.key), "cars");
                intent.putExtra(Integer.toString(R.string.diff_key), diffKey);
                HomeActivity.this.startActivity(intent);
            }
        });
    }

    public void pickMath() {

        Button mathButton = (Button)findViewById(R.id.math_button);
        mathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FlashCardActivity.class);
                intent.putExtra(Integer.toString(R.string.key), "math");
                intent.putExtra(Integer.toString(R.string.diff_key), diffKey);
                HomeActivity.this.startActivity(intent);
            }
        });
    }
}
