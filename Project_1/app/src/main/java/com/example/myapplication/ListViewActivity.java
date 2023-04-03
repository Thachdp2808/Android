package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> arr_str = new ArrayList<>();
    ArrayAdapter<String> adapter;
    int pos_item=0;

    Button search,add,edit,remove;
    EditText text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        Init();
        Events();
        Events_lv();
        Crud();
    }

    public void Events_lv(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                pos_item=position;
                text.setText(arr_str.get(position).toString());

                Toast.makeText(ListViewActivity.this, lv.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ListViewActivity.this);
                alertDialog.setTitle("DO you want delete this? ");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {

                        arr_str.remove(i);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(ListViewActivity.this, "Delete Success", Toast.LENGTH_LONG).show();
                    }
                });

                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ListViewActivity.this, "Delete Not Success", Toast.LENGTH_LONG).show();
                        dialogInterface.cancel();
                    }
                });


                alertDialog.create().show();
                return true;
            }

        });

    }
    public void Crud(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = text.getText().toString();
                if(!s.isEmpty()){
                    arr_str.add(0,s);
                    adapter.notifyDataSetChanged();

                }
                Toast.makeText(ListViewActivity.this, "Text is Empty", Toast.LENGTH_LONG).show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!text.getText().toString().isEmpty()){
                    arr_str.set(pos_item,text.getText().toString());
                    adapter.notifyDataSetChanged();
                }
                Toast.makeText(ListViewActivity.this, "Text is Empty", Toast.LENGTH_LONG).show();

            }
        });



        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                search.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.getFilter().filter(charSequence);
                    }

                });
                Events_lv();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ListViewActivity.this);
                alertDialog.setTitle("DO you want delete this? ");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {

                        arr_str.remove(pos_item);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(ListViewActivity.this, "Delete Success", Toast.LENGTH_LONG).show();
                    }
                });

                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ListViewActivity.this, "Delete Not Success", Toast.LENGTH_LONG).show();
                        dialogInterface.cancel();
                    }
                });
                alertDialog.create().show();
            }
        });
    }

    public void Events(){
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr_str);
        lv.setAdapter(adapter);
    }

    public void Init(){
        arr_str.add("thach");
        arr_str.add("trang");
        arr_str.add("dao");
        arr_str.add("Vuong");

        lv=findViewById(R.id.lv);
        search=findViewById(R.id.search);
        add=findViewById(R.id.add);
        edit=findViewById(R.id.edit);
        remove=findViewById(R.id.remove);
        text=findViewById(R.id.input_edit);



    }
}
