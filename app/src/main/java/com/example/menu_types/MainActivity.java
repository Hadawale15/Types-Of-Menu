package com.example.menu_types;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    ListView listView;

    String Name[] = {"Shubham", "Raj", "Sai", "Ram", "Depak", "Pradnya", "Mukta", "Sahil", "Om", "Radhika", "Yash", "Aditya"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.PopUp_id);
        listView = findViewById(R.id.List_id);

        //set items in listview
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, Name);
        listView.setAdapter(arrayAdapter);

        //register context menu for list view
        registerForContextMenu(listView);
    }

    //OPTION MENU

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:
                Toast.makeText(MainActivity.this, "ONE", Toast.LENGTH_SHORT).show();
                break;

            case R.id.two:
                Toast.makeText(MainActivity.this, "TWO", Toast.LENGTH_SHORT).show();
                break;

            case R.id.three:
                Toast.makeText(MainActivity.this, "THREE", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    //CONTEXT MENU

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.delete:
                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                break;

            case R.id.share:
                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


    //POP_UP MENU
    public void POPUP(View view) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, button1);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }


}