package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    Button btncal;
    TextView sum,num;
    CheckBox coffe,kem,bim,suachua,nepcam;
    EditText input_coffe,input_kem,input_bim,input_suachua,input_nepcam;
    float tongtien=0;
    int a,b,c,d,e;
    int number=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        btncal= (Button) findViewById(R.id.cal);
        coffe = (CheckBox) findViewById(R.id.coffe);
        kem = (CheckBox) findViewById(R.id.kem);
        bim = (CheckBox) findViewById(R.id.bim);
        suachua = (CheckBox) findViewById(R.id.suachua);
        nepcam = (CheckBox) findViewById(R.id.nepcam);
        sum = findViewById(R.id.sum);
        num=findViewById(R.id.sum_soluong);
         input_coffe=findViewById(R.id.input_coffe);
        input_kem=findViewById(R.id.input_kem);
        input_bim=findViewById(R.id.input_bim);
        input_suachua=findViewById(R.id.input_suachua);
        input_nepcam=findViewById(R.id.input_nepcam);







        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(coffe.isChecked()){
                    if(input_coffe.getText().toString().equals("")){
                        a=1;
                    }else {
                        a	=	Integer.parseInt(input_coffe.getText().toString());
                    }


                    tongtien+=a*20000;
                }
                if(nepcam.isChecked()){
                    if(input_nepcam.getText().toString().equals("")){
                        b=1;
                    }else {
                        b	=	Integer.parseInt(input_nepcam.getText().toString());
                    }

                    tongtien+=b*12000;
                }
                if(kem.isChecked()){
                    if(input_kem.getText().toString().equals("")){
                        c=1;
                    }else{
                        c	=	Integer.parseInt(input_kem.getText().toString());
                    }

                    tongtien+=c*10000;
                }
                if(bim.isChecked()){
                    if(input_bim.getText().toString().equals("")){
                        d=1;
                    }else{
                        d	=	Integer.parseInt(input_bim.getText().toString());
                    }

                    tongtien+=d*5000;
                }
                if(suachua.isChecked()){
                    if(input_suachua.getText().toString().equals("")){
                        e=1;
                    }else{
                        e	=	Integer.parseInt(input_suachua.getText().toString());
                    }

                    tongtien+=e*6000;
                }

                sum.setText(tongtien+"");
                tongtien=0;
                Toast.makeText(Menu.this, tongtien+"",Toast.LENGTH_LONG).show();
            }

        });
    }
}
