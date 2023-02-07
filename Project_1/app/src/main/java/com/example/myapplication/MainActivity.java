package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnLoggin;
    EditText tk,mk;
    TextView tvtb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoggin= (Button) findViewById(R.id.dangnhap);
        tk=findViewById(R.id.input_login);
        mk=findViewById(R.id.input_password);
        tvtb=findViewById(R.id.tvbt);

        btnLoggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edittk,editmk;
                edittk=tk.getText().toString();
                editmk=mk.getText().toString();
                if(edittk.equals("se164")&& editmk.equals("123")){
                    tvtb.setText("Đăng nhập thành công");
                    Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                    startActivity(intent);
                }
                tvtb.setText("Đăng nhập thất bại");

            }
        });
    }
}