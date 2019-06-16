package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    enum Player {
        ONE,TWO;
    }

    Player currentPlayer = Player.ONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}

    public void imgClicked(View imageView) {
        ImageView tappedImg = (ImageView) imageView;
        tappedImg.setTranslationX(-2000);

        if (currentPlayer == Player.ONE) {
            tappedImg.setImageResource(R.drawable.lion);
            currentPlayer = Player.TWO;
        } else if (currentPlayer == Player.TWO) {
            tappedImg.setImageResource(R.drawable.tiger);
            currentPlayer = Player.ONE;
        }
        tappedImg.animate().translationXBy(2000).alpha(1).rotationBy(3600).setDuration(1000);
    }
}
