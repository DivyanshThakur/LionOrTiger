package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}

    public void imgClicked(View imageView){
        ImageView tappedImg = (ImageView) imageView;
        tappedImg.setTranslationX(-2000);
        tappedImg.setImageResource(R.drawable.tiger);

        tappedImg.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);
    }
}
