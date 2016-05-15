package com.example.lms0016.spnball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtRes;
    private Spinner spnBalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtRes = (TextView)findViewById(R.id.txtRes);
        spnBalls = (Spinner)findViewById(R.id.spnBalls);

        // 建立 ArrayAdapter
        ArrayAdapter<CharSequence> adapterBalls = ArrayAdapter.createFromResource(this, R.array.Balls, android.R.layout.simple_spinner_item);

        // 設定 Spinner 顯示的格式
        adapterBalls.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 設定 Spinner 的資料來源
        spnBalls.setAdapter(adapterBalls);

        // 設定 spnPrefer 元件 ItemSelected 事件的 listener 為 spnPreferListener
        spnBalls.setOnItemSelectedListener(spnPreferListener);
    }
    private Spinner.OnItemSelectedListener spnPreferListener = new Spinner.OnItemSelectedListener(){
      @Override
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
          String sel = parent.getSelectedItem().toString();
          txtRes.setText(sel);
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent){
          //TODO Auto-generated method stub
      }
    };
}
