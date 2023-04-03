package com.example.prm_he151521_daophucthach;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    EditText editTextID;
    EditText editTextName;
    EditText editTextBirthdate;
    EditText editTextGender;
    EditText editTextPhone;
    Button buttonAdd;

    private void Init() {
        editTextID = findViewById(R.id.editTextNumber);
        editTextName = findViewById(R.id.editTextTextPersonName2);
        editTextBirthdate = findViewById(R.id.editTextDate);
        editTextGender = findViewById(R.id.editTextTextPersonName3);
        editTextPhone = findViewById(R.id.editTextNumber2);
        buttonAdd = findViewById(R.id.button7);
    }

    private void Events() {
        guest retrievedGuest = (guest) getIntent().getSerializableExtra("key");

        String retrievedGuestID = String.valueOf(retrievedGuest.getGuestId());
        String retrievedGuestBirthdate = String.valueOf(retrievedGuest.getGuestBirth());

        editTextID.setText(retrievedGuestID);
        editTextName.setText(retrievedGuest.getGuestName());
        editTextBirthdate.setText(retrievedGuestBirthdate);
        editTextGender.setText(retrievedGuest.getGuestGender());
        editTextPhone.setText(retrievedGuest.getGuestMobile());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_edit);
        Init();
        Events();
    }
}