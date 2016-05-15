package com.example.lms0016.checkboxball;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private TextView txtRes;
    private CheckBox chkBase, chkBasket, chkFoot, chkBad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtRes = (TextView)findViewById(R.id.txtRes);
        chkBasket = (CheckBox)findViewById(R.id.chkBasket);
        chkFoot = (CheckBox)findViewById(R.id.chkFoot);
        chkBase = (CheckBox)findViewById(R.id.chkBase);
        chkBad = (CheckBox)findViewById(R.id.chkBad);

        chkBasket.setOnCheckedChangeListener(myListener);
        chkFoot.setOnCheckedChangeListener(myListener);
        chkBase.setOnCheckedChangeListener(myListener);
        chkBad.setOnCheckedChangeListener(myListener);
    }

    private CheckBox.OnCheckedChangeListener myListener = new CheckBox.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            int n = 0; //紀錄共選了多少項
            String sel = ""; //所有的選項結果
            String s1 = "", s2 = "", s3 = "", s4 = ""; //單一的選項結果

            if (chkBase.isChecked()){
                n++;
                s1 = chkBase.getText().toString() + "";
            }else{
                s1 = "";
            }

            if (chkFoot.isChecked()){
                n++;
                s2 = chkFoot.getText().toString() + "";
            }else{
                s2 = "";
            }

            if (chkBasket.isChecked()){
                n++;
                s3 = chkBasket.getText().toString() + "";
            }else{
                s3 = "";
            }

            if (chkBad.isChecked()){
                n++;
                s4 = chkBad.getText().toString() + "";
            }else{
                s4 = "";
            }

            sel = s1 + s2 + s3 + s4;
            txtRes.setText("最喜歡的球類有 : " + sel + " 共 " + n + " 項 " );
        }
    };
}
