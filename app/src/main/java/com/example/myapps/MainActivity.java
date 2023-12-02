package com.example.myapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportFragmentManager().beginTransaction().add(R.id.frame1, new fragmento1()).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId())
        {
            case R.id.menufracmento1:getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new fragmento1()).commit();
                return true;
            case R.id.menufracmento2:getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new fragmento2()).commit();
                return true;
            case R.id.menufracmento3:getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new fragmento3()).commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


