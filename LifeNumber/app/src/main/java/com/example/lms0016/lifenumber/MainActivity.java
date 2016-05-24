package com.example.lms0016.lifenumber;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
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
            TextView txtShow = (TextView)getActivity().findViewById(R.id.txtShow);
            TextView txtDetail = (TextView)getActivity().findViewById(R.id.txttDetail);
            Locale locale = Locale.TAIWAN;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", locale);
            Date date = new Date(year, month, day-1);
            String dayOfWeek = simpleDateFormat.format(date);
            year -=1911;
            txtRes.setText(year + "年" + (month+1) + "月" + day + "日" + dayOfWeek);

            int temp = 0;
            temp = 1911 + year + (month+1) + day;
            String result = "";
            if (temp > 1000 ){
                result = Integer.toString(temp);
                String[] store = result.split("");
                temp = Integer.parseInt(store[1]) + Integer.parseInt(store[2]) + Integer.parseInt(store[3]) + Integer.parseInt(store[4]);
                if(temp > 9){
                    result = Integer.toString(temp);
                    String[] store2 = result.split("");
                    temp = Integer.parseInt(store2[1]) + Integer.parseInt(store2[2]);
                }

            }
            txtShow.setText("生命靈數 : " +Integer.toString(temp));
            switch (temp){
                case 1:
                    txtDetail.setText(
                            "優點:\n"
                            + "獨立、積極、創造、領導、能量\n"
                            + "富創意與理解力，為人聰明，喜歡領導\n\n"
                            + "缺點:\n"
                            + "強勢、獨斷、浮躁、自私、懶散、吹牛\n"
                            + "主觀意識強，我行我素，人際關係淡薄");
                    break;
                case 2:
                    txtDetail.setText(
                            "優點:\n"
                            + "敏感、體貼、柔順、和諧、依賴\n"
                            + "個性內斂，善於分工合作，重視群體關係，喜歡受到別人肯定\n\n"
                            + "缺點:\n"
                            + "情緒不定、優柔寡斷、難以捉摸、膚淺不安\n"
                            + "容易因他人的意見而受到影響，不能忍耐孤獨");
                    break;
                case 3:
                    txtDetail.setText(
                            "優點:\n"
                            + "行動、樂觀、自信、表現、社交\n"
                            + "聰明機警，有創意，多具有藝術天份，表達能力強\n\n"
                            + "缺點:\n"
                            + "欺瞞、虛榮浮華、憤世嫉俗、渙散不集中\n"
                            + "任性，多只依自己的喜好行事，容易好高騭遠");
                    break;
                case 4:
                    txtDetail.setText(
                            "優點:\n"
                            + "忠誠、次序、效率、助人、自律\n"
                            + "組織能力強，做事條理分明，目光敏銳，能迅速掌握重點\n\n"
                            + "缺點:\n"
                            + "獨斷獨行、心胸狹窄、容易緊張、不易妥協\n"
                            + "固執，缺乏安全感，不敢承擔風險，因此容易讓機會溜走");
                    break;
                case 5:
                    txtDetail.setText(
                            "優點:\n"
                            + "聰穎、冒險、適應強、多變化、學習快\n"
                            + "能答善辯，口才極佳，熱情豪爽，講義氣，崇尚自由\n\n"
                            + "缺點:\n"
                            + "博而不精、持續力差、毫不在乎、索求無度\n"
                            + "不喜歡受到束縛，容易放縱，容易得罪別人");
                    break;
                case 6:
                    txtDetail.setText(
                            "優點:\n"
                            + "穩定、信賴、熱情、正義、奉獻\n"
                            + "情感細膩，擅長人際間的交際，喜歡幫助他人，重承諾與責任\n\n"
                            + "缺點:\n"
                            + "缺乏自信、不切實際、好強爭辯、強行干涉\n"
                            + "不理智時，常會做出錯誤的決定，付出不求回報時容易讓自己受傷");
                    break;
                case 7:
                    txtDetail.setText(
                            "優點:\n"
                            + "內省、沉默、直覺、真理、理想\n"
                            + "擅長鑽研事物，喜歡追求真理，精於算計，遇事理智\n\n"
                            + "缺點:\n"
                            + "冷漠、自大傲慢、自我放縱、鬼鬼祟祟\n"
                            + "處事不夠圓滑，不容易被討好，容易到手的東西不會珍惜");
                    break;
                case 8:
                    txtDetail.setText(
                            "優點:\n"
                            + "忠貞、持續、堅定、誠懇、照料\n"
                            + "喜歡冒險刺激，有商業頭腦，喜歡追求權力，能即知即行\n\n"
                            + "缺點:\n"
                            + "唯物主義、無道德感、心高氣傲、排除他議\n"
                            + "驕傲，對喜歡的東西有異常的執著，面對衝突時會勉強自己");
                    break;
                case 9:
                    txtDetail.setText(
                            "優點:\n"
                            + "人性、啟發、活力、關懷、靈性\n"
                            + "充滿生命力，能從創意之中獲得滿足感，處事隨機應變，見招拆招\n\n"
                            + "缺點:\n"
                            + "卑躬屈膝、毫無原則、善於批評、沒有耐性\n"
                            + "行事不務實，意志不夠堅定，想像太過於力豐富則會變成天馬行空");
                    break;
            }


        }
    }
}
