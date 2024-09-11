package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   int activePlayer = 1 ;// 1 = 0
    //0 = x
     TextView textview;
     int count = 0;
    int  []gameState = {2,2,2,2,2,2,2,2,2};
     boolean gameActive = true;
    int [][]winmatch = {{0,1,2} , {3,4,5} , {6,7,8} , {0,3,6} , {1,4,7} , {2,5,8} , {0,4,8} , {2,4,6}};
    @SuppressLint("SetTextI18n")
    public void playerTap(View view)
    {
        if(!gameActive)
        {
            reset(view);
            gameActive = true;
        }
        ImageView image = (ImageView) view;
        int tappedImge = Integer.parseInt(image.getTag().toString());
        textview = findViewById(R.id.textView);
         if(gameState[tappedImge] == 2)
         {
             gameState[tappedImge] = activePlayer;
             image.setTranslationY(-1000f);

             if(activePlayer == 1)
             {
                 activePlayer = 0;
                 image.setImageResource(R.drawable.o);
                 textview.setText("X turn tab to play");
             }
             else {
                 activePlayer = 1;
                 image.setImageResource(R.drawable.a);
                 textview.setText("O turn tab to play");
             }
             image.animate().translationYBy(1000f).setDuration(200);
         }
         for(int[] i : winmatch)
         {
             if(gameState[i[0]] == gameState[i[1]] &&  gameState[i[1]] == gameState[i[2]] &&  gameState[i[0]] !=2)
             {
                 if(gameState[i[0]] == 0)
                 {
                     textview.setText("X IS WINNER...");

                 }
                 else {

                     textview.setText("O IS WINNER...");
                     image.setImageResource(R.drawable.wino);
                 }
             }

         }
    }
    public void resetButton(View view)
    {
      reset(view);
    }
    public void reset(View view) {
        ImageView image;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        activePlayer = 1;
        textview.setText("O turn tab to play");
         image = findViewById(R.id.imageView_1);
           image.setImageResource(0);
        image = findViewById(R.id.imageView_7);
        image.setImageResource(0);
        image = findViewById(R.id.imageView_2);
        image.setImageResource(0);
        image = findViewById(R.id.imageView_3);
        image.setImageResource(0);
        image = findViewById(R.id.imageView_4);
        image.setImageResource(0);
        image = findViewById(R.id.imageView_5);
        image.setImageResource(0);
        image = findViewById(R.id.imageView_6);
        image.setImageResource(0);
        image = findViewById(R.id.imageView_8);
        image.setImageResource(0);
        image = findViewById(R.id.imageView_9);
        image.setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
