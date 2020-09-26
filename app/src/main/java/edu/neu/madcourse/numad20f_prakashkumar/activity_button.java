package edu.neu.madcourse.numad20f_prakashkumar;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class activity_button extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button button_A = findViewById(R.id.button_A);
        Button button_B = findViewById(R.id.button_B);
        Button button_C = findViewById(R.id.button_C);
        Button button_D = findViewById(R.id.button_D);
        Button button_E = findViewById(R.id.button_E);
        Button button_F = findViewById(R.id.button_F);

        button_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView_ButtonPressed);
                textView.setText(R.string.activity_buttons_pressed_A);
            }
        });

        button_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView_ButtonPressed);
                textView.setText(R.string.activity_buttons_pressed_B);
            }
        });

        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView_ButtonPressed);
                textView.setText(R.string.activity_buttons_pressed_C);
            }
        });

        button_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView_ButtonPressed);
                textView.setText(R.string.activity_buttons_pressed_D);
            }
        });

        button_E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView_ButtonPressed);
                textView.setText(R.string.activity_buttons_pressed_E);
            }
        });

        button_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView_ButtonPressed);
                textView.setText(R.string.activity_buttons_pressed_F);
            }
        });
    }

}
