package com.example.nommi.myapplication;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ArrayAdapter;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//hello
        ToggleButton b1 = (ToggleButton) findViewById(R.id.btn);
        Resources res = getResources();
        final TypedArray Mycolors = res.obtainTypedArray(R.array.rainbow);
        final Random random = new Random(); // create new
        final CountDownTimer waitTimer = new CountDownTimer(300000, 1000) {
            public void onTick(long millisUntilFinished) {
                    int randomInt = 0;
                    int drawableID = 0;
                    randomInt = random.nextInt(Mycolors.length());
                    drawableID = Mycolors.getResourceId(randomInt, -1);
                    ConstraintLayout background = findViewById(R.id.back);
                    //background.setBackgroundResource(drawableID);
                    Toast.makeText(MainActivity.this, "run1 " + randomInt, Toast.LENGTH_SHORT).show();
                    //System.out.println("Show mw");
                    switch (randomInt){
                        case 0:
                            background.setBackgroundResource(R.drawable.ic_launcher_foreground);
                        case 1:
                            background.setBackgroundResource(R.drawable.darkgray2);
                            break;
                        case 2:
                            background.setBackgroundResource(R.drawable.darkgray3);
                            break;
                        case 3:
                            background.setBackgroundResource(R.drawable.darkgray4);
                            break;
                        case 4:
                            background.setBackgroundResource(R.drawable.darkgray5);
                            break;
                        case 5:
                            background.setBackgroundResource(R.drawable.darkgray6);
                            break;
                        case 6:
                            background.setBackgroundResource(R.drawable.darkgray7);
                            break;
                        case 7:
                            background.setBackgroundResource(R.drawable.darkgray8);
                            break;
                        case 8:
                            background.setBackgroundResource(R.drawable.darkgray9);
                            break;
                    }

            }
            public void onFinish() {
                    int randomInt = 0;
                    int drawableID = 0;
                    randomInt = random.nextInt(Mycolors.length());
                    drawableID = Mycolors.getResourceId(randomInt, -1);
                    ConstraintLayout background = findViewById(R.id.back);
                    //background.setBackgroundResource(drawableID);
            }
        };
                    b1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                            if (isChecked) {
                                       waitTimer.start();//Start
                            }
                            else {
                                      ConstraintLayout background = findViewById(R.id.back);
                                      background.setBackgroundResource(R.drawable.dark);
                                      waitTimer.cancel();//End
                            }
                        }
                    });

                 /*  b1.setOnClickListener(new Button.OnClickListener(){
                   public void onClick(View v){
                   ColorChange.say();
                   }});
                 */
    }
}

