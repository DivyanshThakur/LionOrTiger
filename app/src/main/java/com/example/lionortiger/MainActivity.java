package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    enum Player {
        ONE,TWO
    }

    Player currentPlayer = Player.ONE;

    Player[] playerChoices = new Player[9];

    int[][] winnerRowsColumns = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}

    public void imgClicked(View imageView) {
        ImageView tappedImg = (ImageView) imageView;

        int tiTag = Integer.parseInt(tappedImg.getTag().toString());
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

    }
}
