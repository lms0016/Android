package com.example.lms0016.bmi;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private TextView txtBMI;
    private EditText edtHigh, edtWeight;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBMI = (TextView)findViewById(R.id.txtBMI);
        edtHigh = (EditText)findViewById(R.id.edtHigh);
        edtWeight = (EditText)findViewById(R.id.edtWeight);
        btnCalc = (Button)findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(btnCalcListener);
    }

    private Button.OnClickListener btnCalcListener = new Button.OnClickListener(){
        public void onClick(View v){
            float high = Float.parseFloat(edtHigh.getText().toString());
            float weight = Float.parseFloat(edtWeight.getText().toString());
            float bmi = weight/(high*high);
            txtBMI.setText("您的BMI為" + bmi);
        }
    };
}
