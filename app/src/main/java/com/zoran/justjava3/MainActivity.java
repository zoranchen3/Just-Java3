package com.zoran.justjava3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity=0;
    Button orderBtn,minusBtn,plusBtn;
    CheckBox whippedChk,chocolateChk;
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
        chocolateChk = (CheckBox)findViewById(R.id.chocTopping_chkBox);
        orderMsg = (TextView)findViewById(R.id.orderMsg_text_view);
        qNum = (TextView)findViewById(R.id.quantityNum_text_view);
    }

    public void displaySummaryMsg(View view){
        getView();
        displaySummary(view);
    }
    public void displayQuantity(View view){
        getView();
        minOrPlus(view);
    }

    private void minOrPlus(View view){
        int number;
        if (view == minusBtn){
            number = Integer.parseInt(qNum.getText().toString());
            if (number == 1){
                return;
            }
            number--;
            qNum.setText(String.valueOf(number));
        }else if (view == plusBtn){
            number = Integer.parseInt(qNum.getText().toString());
            if (number == 99){
                return;
            }
            number++;
            qNum.setText(String.valueOf(number));
        }
    }

    private void displaySummary(View view){
        msgSummary="";
        String username = "Zoran Chen\n";
        msgSummary+="Name:"+username;
        msgSummary+="Add Whipped Cream?"+hasWhippedCream()+"\n";
        msgSummary+="Quantity:"+ qNum.getText().toString()+"\n";
        msgSummary+="Total:"+ NumberFormat.getCurrencyInstance().format(calTotalPrice())+"\n";
        msgSummary+="Thank you!";
        orderMsg.setText(msgSummary);
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



    /**calculate total price**/
    private int calTotalPrice(){
        int totalprice = 5*Integer.parseInt(qNum.getText().toString());
        return totalprice;
    }



}
