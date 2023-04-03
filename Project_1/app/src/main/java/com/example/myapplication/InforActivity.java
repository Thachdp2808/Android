package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class InforActivity extends AppCompatActivity {
    Button btn_send;
    EditText name, cmtnd, bomon;
    TextView a;
    Spinner sex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infor);
        init();

        List<String> list = new ArrayList<>();
        list.add("Nam");
        list.add("Nữ");
        list.add("Khác");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
        sex.setAdapter(adapter);

        sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(InforActivity.this, sex.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InforActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        sex = findViewById(R.id.gioitinh);
        a = findViewById(R.id.input_hoten);
        btn_send = findViewById(R.id.send);
        name = findViewById(R.id.input_name);
        cmtnd = findViewById(R.id.input_cmtnd);
        bomon = findViewById(R.id.input_bomon);
    }
}
