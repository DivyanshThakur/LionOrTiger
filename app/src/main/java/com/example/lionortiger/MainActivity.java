package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    enum Player {
        ONE, TWO, NO
    }

    Player currentPlayer = Player.ONE;

    Player[] playerChoices = new Player[9];

    int[][] winnerRowsColumns = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    private boolean gameOver = false;
    private Button btnReset;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gridLayout);

        assignLoop();
        btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetTheGame();
            }
        });
    }

    public void imgClicked(View imageView) {
        ImageView tappedImg = (ImageView) imageView;

        int tiTag = Integer.parseInt(tappedImg.getTag().toString());

            if (playerChoices[tiTag] == Player.NO && !gameOver) {

                playerChoices[tiTag] = currentPlayer;

                if (currentPlayer == Player.ONE) {
                    tappedImg.setTranslationX(-2000);
                    tappedImg.setImageResource(R.drawable.lion);
                    currentPlayer = Player.TWO;

                    tappedImg.animate().translationXBy(2000).alpha(1).rotationBy(3600).setDuration(1000);
                } else if (currentPlayer == Player.TWO) {

                    tappedImg.setTranslationX(2000);
                    tappedImg.setImageResource(R.drawable.tiger);
                    currentPlayer = Player.ONE;

                    tappedImg.animate().translationXBy(-2000).alpha(1).rotationBy(3600).setDuration(1000);
                }

                for (int[] winnerColumn : winnerRowsColumns) {
                    if (playerChoices[winnerColumn[0]] == playerChoices[winnerColumn[1]] && playerChoices[winnerColumn[1]] == playerChoices[winnerColumn[2]] && playerChoices[winnerColumn[0]] != Player.NO) {

                        btnReset.setVisibility(View.VISIBLE);
                        gameOver = true;
                        String winner = "";
                        if (currentPlayer == Player.ONE) {
                            winner = "PLAYER TWO";
                        } else if (currentPlayer == Player.TWO) {
                            winner = "PLAYER ONE";
                        }
                        Toast.makeText(this, winner + " is the Winner.", Toast.LENGTH_LONG).show();
                    }
                }

            }

    }
        // Resetting the Game
    private void ResetTheGame(){

        for (int i=0; i<gridLayout.getChildCount();i++) {

            ImageView img = (ImageView) gridLayout.getChildAt(i);
            img.setImageDrawable(null);
            img.setAlpha(0.2f);
        }

        currentPlayer = Player.ONE;
        gameOver = false;

        assignLoop();
        btnReset.setVisibility(View.GONE);

    }

    private void assignLoop(){
        for (int i = 0; i< playerChoices.length;i++){
            playerChoices[i] = Player.NO;
        }
    }

}
