package com.example.tim43;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private float resultBMI;

    private EditText etAge;

    private EditText etWeight;

    private EditText etHeight;

    private Button btnCalc;

    private LinearLayout LMale;

    private LinearLayout LFemale;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAge = findViewById(R.id.EditLet);
        etWeight = findViewById(R.id.EditVes);
        etHeight = findViewById(R.id.EditRost);

        btnCalc = findViewById(R.id.Button1);

        LMale = findViewById(R.id.manlayout);
        LFemale = findViewById(R.id.womanlayout);

        btnCalc.setOnClickListener(this);
        LMale.setOnClickListener(this);
        LFemale.setOnClickListener(this);
    }

public void onClick(View v){
        switch (v.getId()){
            case R.id.Button1:
                int weight = Integer.parseInt(etWeight.getText().toString());
                int age = Integer.parseInt(etAge.getText().toString());
                int height = Integer.parseInt(etHeight.getText().toString());
                resultBMI =weight/((height/100f)*(height/100f));
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ResultActivity.class);
                intent.putExtra("res",resultBMI);
                intent.putExtra("age",age);
                startActivity(intent);
                break;
            case R.id.manlayout:
                LMale.setBackgroundColor(Color.BLUE);
                LFemale.setBackgroundColor(Color.TRANSPARENT);
                break;
            case R.id.womanlayout:
                LMale.setBackgroundColor(Color.TRANSPARENT);
                LFemale.setBackgroundColor(Color.BLUE);
                break;

        }
}


}