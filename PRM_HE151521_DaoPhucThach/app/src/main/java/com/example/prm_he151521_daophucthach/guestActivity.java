package com.example.prm_he151521_daophucthach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.prm_he151521_daophucthach.guest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.DataFormatException;

public class guestActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<guest> arr_str = new ArrayList<>();
    ArrayAdapter<guest> adapter;
    int pos_item=0;
    Button insert,edit,delete;
    EditText text;
    int pos_item_lv = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest);
        Init();
        Events();
        Events_LV();
    }

    public void Events(){
        adapter = new ArrayAdapter<guest>(this, android.R.layout.simple_list_item_1, arr_str) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);
                guest guest = arr_str.get(position);
                textView.setText(guest.getGuestId() + " - " + guest.getGuestName());
                return view;
            }
        };

        lv.setAdapter(adapter);

    }

    public void Init(){
        arr_str.add( new guest(1114,"2","23/12/2022","abc","abc"));
        arr_str.add( new guest(1110,"b","23/12/2022","abc","abc"));
        arr_str.add( new guest(1113,"c","23/12/2022","abc","abc"));
        arr_str.add( new guest(1112,"d","23/12/2022","abc","abc"));

        insert = findViewById(R.id.insert);
        edit = findViewById(R.id.edit);
        delete = findViewById(R.id.delete);
        lv=findViewById(R.id.lv);
    }

    private void Events_LV() {
        //OnClick to see name
        lv.setOnItemClickListener((adapterView, view, i, id) -> {
            pos_item_lv = i;
            Toast.makeText(guestActivity.this, "Click on " + i + arr_str.get(i), Toast.LENGTH_LONG).show();
        });
        insert.setOnClickListener(view -> {
            guest choseGuest = arr_str.get(pos_item_lv);
            Intent intent = new Intent(guestActivity.this, InsertActivity.class);
            intent.putExtra("key", String.valueOf(choseGuest));
            startActivity(intent);
        });
        edit.setOnClickListener(view -> {
            guest choseGuest = arr_str.get(pos_item_lv);
            Intent intent = new Intent(guestActivity.this, UpdateActivity.class);
            intent.putExtra("key", String.valueOf(choseGuest));
            startActivity(intent);
        });

        //Delete
        delete.setOnClickListener(view -> {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(guestActivity.this);
            alertDialog.setTitle("Delete this " + arr_str.get(pos_item_lv) + " ?");
            alertDialog.setPositiveButton("yes", (dialogInterface, i1) -> {
                arr_str.remove(pos_item_lv);
                adapter.notifyDataSetChanged();
                Toast.makeText(guestActivity.this, "Deleted item " + arr_str.get(pos_item_lv), Toast.LENGTH_SHORT).show();

            });
            alertDialog.setNegativeButton("no", (dialogInterface, i12) -> {
                Toast.makeText(guestActivity.this, "No action on item " + arr_str.get(pos_item_lv), Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
            });
            alertDialog.create().show();
        });
    }
}
