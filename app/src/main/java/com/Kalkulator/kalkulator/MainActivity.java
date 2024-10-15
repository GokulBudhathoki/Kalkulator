package com.Kalkulator.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button calculateButton;
    private EditText inchesEditText;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        findViews();
        displayResult();

    }

    private void findViews() {
        calculateButton = findViewById(R.id.button_calculate);
        inchesEditText = findViewById(R.id.edit_text_inches);
        resultText = findViewById(R.id.text_view_result);
    }

    private void displayResult() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inchesText = inchesEditText.getText().toString();
                if (inchesText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input inches!!", Toast.LENGTH_LONG).show();
                } else {
                    calculate(inchesText);
                }
            }
        });

    }

    private void calculate(String inchesText) {

        String finalResultInMeter;

        double inches = Double.parseDouble(inchesText);

        double meters = inches * 0.0254;

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");

        String resultInMeters = myDecimalFormatter.format(meters);

        finalResultInMeter = resultInMeters + " meters";

        resultText.setText(finalResultInMeter);


    }

}