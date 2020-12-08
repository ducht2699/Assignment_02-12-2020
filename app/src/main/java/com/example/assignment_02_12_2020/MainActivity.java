package com.example.assignment_02_12_2020;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    List<Email> emailList = new ArrayList<Email> (   );
    List<Integer> colorList = new ArrayList<Integer>( );
    EmailAdapter adapter;
    ListView rv;
    List<Email> tempEmailList;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tempEmailList.clear();
                MainActivity.this.adapter.notifyDataSetChanged();
                for (int i = 0; i< emailList.size(); i++) {
                    if (query.contains(emailList.get(i).getTitle()) == true) {
                        tempEmailList.add(emailList.get(i));
                        MainActivity.this.adapter.notifyDataSetChanged();
                    }
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Email");


        int id = getResources().getColor(R.color.red);
        colorList.add(id);
        id = getResources().getColor(R.color.orange);
        colorList.add(id);
        id = getResources().getColor(R.color.yellow);
        colorList.add(id);
        id = getResources().getColor(R.color.green);
        colorList.add(id);
        id = getResources().getColor(R.color.cyan);
        colorList.add(id);
        id = getResources().getColor(R.color.blue);
        colorList.add(id);
        id = getResources().getColor(R.color.purple);
        colorList.add(id);

        Faker faker = new Faker();
        for (int i = 0; i < 15; i++) {
            String title = faker.name.firstName() + " " + faker.name.lastName();
            String details = faker.lorem.paragraph();
            Email temp = new Email(title, details, String.valueOf(title.charAt(0)));
            emailList.add(temp);
        }
        tempEmailList = new ArrayList<>(emailList);

        adapter = new EmailAdapter(tempEmailList, this, colorList);
        rv = findViewById(R.id.rv_emails);
        rv.setAdapter(adapter);
    }





}