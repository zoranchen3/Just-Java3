package com.zoran.justjava3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity=0;
    Button orderBtn,minusBtn,plusBtn;
    CheckBox whippedChk;
    TextView qNum,orderMsg;
    String msgSummary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getView(){
        orderBtn = (Button)findViewById(R.id.order_btn);
        minusBtn = (Button)findViewById(R.id.minus_btn);
        plusBtn = (Button)findViewById(R.id.plus_btn);
        whippedChk = (CheckBox)findViewById(R.id.wCream_chkBox);
        orderMsg = (TextView)findViewById(R.id.orderMsg_text_view);
    }
    private void displaySummary(View view){
        String username = "Zoran Chen\n";
        msgSummary+="Name:"+username;
        msgSummary+="Add Whipped Cream?"+hasWhippedCream()+"\n";
        msgSummary+="Quantity:"+ qNum.getText().toString()+"\n";
        msgSummary+="Total:";
        msgSummary+="Thank you!";

    }

    private Boolean hasWhippedCream() {
        if (whippedChk.isChecked() == true) {
            return true;
        }
        if (whippedChk.isChecked() == false) {
            return false;
        }
        return false;
    }
}
