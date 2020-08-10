package com.example.multidice;

import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class four_dice extends AppCompatActivity {
    private Button backButton4;
    private Button rollButton;
    private ImageView dice4_1;
    private ImageView dice4_2;
    private ImageView dice4_3;
    private ImageView dice4_4;
    private int[] diceimgs = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_dice);

        dice4_1 = (ImageView) findViewById(R.id.dice4_1);
        rollDiceNoFlick(dice4_1);
        dice4_2 = (ImageView) findViewById(R.id.dice4_2);
        rollDiceNoFlick(dice4_2);
        dice4_3 = (ImageView) findViewById(R.id.dice4_3);
        rollDiceNoFlick(dice4_3);
        dice4_4 = (ImageView) findViewById(R.id.dice4_4);
        rollDiceNoFlick(dice4_4);


        backButton4 = (Button) findViewById(R.id.homeButton);
        backButton4.setOnClickListener(new View.OnClickListener() {
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
                rollDice(dice4_1);
                rollDice(dice4_2);
                rollDice(dice4_3);
                rollDice(dice4_4);
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
