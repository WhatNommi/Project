package com.example.nommi.myapplication;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private SparseArray<Integer>mypair=new SparseArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton b1 = findViewById(R.id.btn);
        Resources res = getResources();
        for (int j=0,i=R.drawable.darkgray2;i<=R.drawable.darkgray9;j++,i++)
            mypair.put(j,i);
        final TypedArray Mycolors = res.obtainTypedArray(R.array.rainbow);
        final Random random = new Random(); // create new
        final CountDownTimer waitTimer = new CountDownTimer(300000, 1000) {
            public void onTick(long millisUntilFinished) {
                    Integer randomInt = random.nextInt(Mycolors.length());
                    ConstraintLayout background = findViewById(R.id.back);
                Log.d("randomInt",randomInt.toString());
                background.setBackgroundResource(mypair.get(randomInt));

            }
            public void onFinish() {
//                    int randomInt = 0;
//                    int drawableID = 0;
//                    randomInt = random.nextInt(Mycolors.length());
//                    drawableID = Mycolors.getResourceId(randomInt, -1);
//                    ConstraintLayout background = findViewById(R.id.back);
//                    //background.setBackgroundResource(drawableID);
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

