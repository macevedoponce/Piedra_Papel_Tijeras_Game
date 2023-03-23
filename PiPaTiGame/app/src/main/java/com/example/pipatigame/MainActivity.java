package com.example.pipatigame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int userChoice;
    private int computerChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rockButton = findViewById(R.id.rockButton);
        Button paperButton = findViewById(R.id.paperButton);
        Button scissorsButton = findViewById(R.id.scissorsButton);

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userChoice = 0;
                playGame();
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userChoice = 1;
                playGame();
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userChoice = 2;
                playGame();
            }
        });
    }

    private void playGame() {
        generateComputerChoice();

        String userChoiceString = "";
        String computerChoiceString = "";

        switch (userChoice) {
            case 0:
                userChoiceString = "piedra";
                break;
            case 1:
                userChoiceString = "papel";
                break;
            case 2:
                userChoiceString = "tijeras";
                break;
        }

        switch (computerChoice) {
            case 0:
                computerChoiceString = "piedra";
                break;
            case 1:
                computerChoiceString = "papel";
                break;
            case 2:
                computerChoiceString = "tijeras";
                break;
        }

        Toast.makeText(this, "Elegiste " + userChoiceString + ", la computadora eligió " + computerChoiceString, Toast.LENGTH_SHORT).show();

        determineWinner();
    }


    private void generateComputerChoice() {
        Random random = new Random();
        computerChoice = random.nextInt(3);
    }

    private void determineWinner() {
        if (userChoice == computerChoice) {
            Toast.makeText(this, "Empate!", Toast.LENGTH_SHORT).show();
        } else if ((userChoice == 0 && computerChoice == 2) ||
                (userChoice == 1 && computerChoice == 0) ||
                (userChoice == 2 && computerChoice == 1)) {
            Toast.makeText(this, "Ganaste!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Perdiste!", Toast.LENGTH_SHORT).show();
        }
    }
}


