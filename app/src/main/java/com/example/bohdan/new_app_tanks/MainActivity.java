package com.example.bohdan.new_app_tanks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button start;
    TextView expression_3;
    int image = R.drawable.jack_s;
    int image2 = R.drawable.jordan;
    ImageView imageView3;
    ImageView imageView4;
    /*MiddleTank tank5 = new MiddleTank("Johny", "jack_s");
    MiddleTank tank6 = new MiddleTank("Johny2", "jordan");*/
    MiddleTank tank5 = new MiddleTank("jack_s");
    MiddleTank tank6 = new MiddleTank( "jordan");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.button2);

        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        // джерело картинок
        imageView3.setImageResource(image);
        imageView4.setImageResource(image2);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityTWO.class);
        intent.putExtra("item", tank5);
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityTWO.class);
        intent.putExtra("item", tank6);
        startActivity(intent);
    }

    public void starter(View view) throws InterruptedException {
        expression_3 = findViewById(R.id.textView3);

        final MiddleTank[] tanksGreen = new MiddleTank[15];
        final MiddleTank[] tanksRed = new MiddleTank[15];

        for (int i = 0; i < 15; i++) {
            tanksGreen[i] = new MiddleTank("Jack" + i);
            tanksRed[i] = new MiddleTank("Bruce" + i);
        }

        //final MiddleTank tank0 = new MiddleTank("one");
        //final MiddleTank tank1 = new MiddleTank("two");

        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 15; i++) {
                    while (tanksGreen[i].endurance > 0 && tanksRed[i].endurance > 0) {
                        System.out.println("Player 1 health: " + tanksGreen[i].endurance + " ***  Player 2 health: " + tanksRed[i].endurance);
                        tanksGreen[i].fireTank(tanksRed[i]);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (tanksGreen[i].endurance > 0)
                        System.out.println("The winner is: " + tanksGreen[i].name);
                }
            }
        });

        t.start();

        Thread p = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 15; i++) {
                    while (tanksGreen[i].endurance > 0 && tanksRed[i].endurance > 0) {
                        System.out.println("Player 1 health: " + tanksGreen[i].endurance + " ***  Player 2 health: " + tanksRed[i].endurance);
                        System.out.println("------------------------");
                        tanksRed[i].fireTank(tanksGreen[i]);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("------------------------ * ---------------------------");
                    if (tanksRed[i].endurance > 0)
                        System.out.println("The winner is: " + tanksRed[i].name);
                }
            }
        });

        p.start();
        t.join();
        p.join();
        for (int i = 0; i < 15; i++) {
            if (tanksGreen[i].endurance > 0)
                expression_3.setText("***  The winner is: " + tanksGreen[i].name);
            else if (tanksRed[i].endurance > 0)
                expression_3.setText("***  The winner is: " + tanksRed[i].name);
        }
    }
}

