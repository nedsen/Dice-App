package com.example.multidice;

import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class five_dice extends AppCompatActivity {
    private Button backButton5;
    private Button rollButton;
    private ImageView dice5_1;
    private ImageView dice5_2;
    private ImageView dice5_3;
    private ImageView dice5_4;
    private ImageView dice5_5;
    private int[] diceimgs = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_dice);

        dice5_1 = (ImageView) findViewById(R.id.dice5_1);
        rollDiceNoFlick(dice5_1);
        dice5_2 = (ImageView) findViewById(R.id.dice5_2);
        rollDiceNoFlick(dice5_2);
        dice5_3 = (ImageView) findViewById(R.id.dice5_3);
        rollDiceNoFlick(dice5_3);
        dice5_4 = (ImageView) findViewById(R.id.dice5_4);
        rollDiceNoFlick(dice5_4);
        dice5_5 = (ImageView) findViewById(R.id.dice5_5);
        rollDiceNoFlick(dice5_5);

        backButton5 = (Button) findViewById(R.id.homeButton);
        backButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Roll if the roll button is pressed
        rollButton = (Button) findViewById(R.id.rollButton);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vib.vibrate(300);
                rollDice(dice5_1);
                rollDice(dice5_2);
                rollDice(dice5_3);
                rollDice(dice5_4);
                rollDice(dice5_5);
            }
        });
    }
    private void rollDice(ImageView image){
        Handler h = new Handler();
        int interval = 100;
        for(int i = 0; i < 1000; i += interval){
            h.postDelayed(new FlickDiceImage(image), i);
        }
    }
    private void rollDiceNoFlick(ImageView image){
        int randNum = (int) (Math.random() * 6);
        image.setImageResource(diceimgs[randNum]);
    }
    public class FlickDiceImage implements Runnable {
        public ImageView image;

        FlickDiceImage (ImageView i){
            image = i;
        }

        @Override
        public void run() {
            int randNum = (int) (Math.random() * 6);
            image.setImageResource(diceimgs[randNum]);
        }
    }
}
