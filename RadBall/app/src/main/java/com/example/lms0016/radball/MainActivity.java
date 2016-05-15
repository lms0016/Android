package com.example.lms0016.radball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtRes;
    private RadioButton radBase, radBasket, radVol, radBad;
    private RadioGroup radGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRes = (TextView)findViewById(R.id.txtRes);
        radGroup = (RadioGroup)findViewById(R.id.radGroup);
        radBase = (RadioButton)findViewById(R.id.radBase);
        radBasket = (RadioButton)findViewById(R.id.radBasket);
        radVol = (RadioButton)findViewById(R.id.radVol);
        radBad = (RadioButton)findViewById(R.id.radBad);

        // 設定 radGroupBall 元件 CkeckedChange 事件的 listerer 為 myListener
        radGroup.setOnCheckedChangeListener(myListener);
    }

    private RadioGroup.OnCheckedChangeListener myListener = new RadioGroup.OnCheckedChangeListener(){
      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId){
          int p = group.indexOfChild((RadioButton)findViewById(checkedId)); // 選項的索引值
          int count = group.getChildCount(); //清單共有多少項

          if (checkedId == R.id.radBase){
              txtRes.setText(count + " 項球類中，最喜歡第 " + (p+1) + " 項 " + radBase.getText());
          }else if (checkedId == R.id.radBasket){
              txtRes.setText(count + " 項球類中，最喜歡第 " + (p+1) + " 項 " + radBasket.getText());
          }else if (checkedId == R.id.radVol){
              txtRes.setText(count + " 項球類中，最喜歡第 " + (p+1) + " 項 " + radVol.getText());
          }else if (checkedId == R.id.radBad){
              txtRes.setText(count + " 項球類中，最喜歡第 " + (p+1) + " 項 " + radBad.getText());
          }
      }
    };
}
