package com.example.myapplication;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class imageActivity extends AppCompatActivity {
    Button btn;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        btn=findViewById(R.id.button_image);
        img=findViewById(R.id.img);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(imageActivity.this).load("Erro").placeholder(R.drawable.ava).error
                        (R.drawable.ava).into(img);
            }
        });
    }
}
