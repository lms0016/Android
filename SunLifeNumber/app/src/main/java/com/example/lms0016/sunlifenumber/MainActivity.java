package com.example.lms0016.sunlifenumber;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDate = (Button)findViewById(R.id.btnDate);

        btnDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO Auto-generated method stub
                DialogFragment dialogFragment = new DatePickerDialogTheme1();
                dialogFragment.show(getFragmentManager(), "Theme1");
            }
        });
    }

    public static class DatePickerDialogTheme1 extends DialogFragment implements DatePickerDialog.OnDateSetListener{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), AlertDialog.THEME_TRADITIONAL, this, year, month, day);
            return datePickerDialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day){
            TextView txtRes = (TextView)getActivity().findViewById(R.id.txtRes);
            Locale locale = Locale.TAIWAN;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", locale);
            Date date = new Date(year, month, day-1);
            String dayOfWeek = simpleDateFormat.format(date);
            year -=1911;
            txtRes.setText(year + "年" + (month-1) + "月" + day + "日" + dayOfWeek);
        }
    }
}
