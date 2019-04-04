package com.example.number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Button btnEasy;
    Button btnAverage;
    Button btnHard;
    Button btnExit;

    Random r = new Random();
    int highBound = 100;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = r.nextInt(highBound + 1);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        btnEasy = findViewById(R.id.btnEasy);
        btnAverage = findViewById(R.id.btnAverage);
        btnHard = findViewById(R.id.btnHard);
        btnExit = findViewById(R.id.btnExit);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highBound = 10;
                number = r.nextInt(highBound + 1);
                tvInfo.setText("Новое число загадано");
            }
        });

        btnAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highBound = 100;
                number = r.nextInt(highBound + 1);
                tvInfo.setText("Новое число загадано");
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highBound = 1000;
                number = r.nextInt(highBound + 1);
                tvInfo.setText("Новое число загадано");
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    public void onClick(View view) {
        try {
            int value = Integer.parseInt(etInput.getText().toString());
            if (value < 1) {
                tvInfo.setText("Меньше нижней границы");
            }
            else if (value > highBound) {
                tvInfo.setText("Больше высшей границы");
            }
            else if (value < number) {
                tvInfo.setText("Недолет!");
            }
            else if (value > number) {
                tvInfo.setText(getResources().getString(R.string.ahead));
            }
            else {
                tvInfo.setText("Верно");
            }
        }

        catch (Exception ex) {
            tvInfo.setText("Невозможно распознать число");
        }
    }
}



