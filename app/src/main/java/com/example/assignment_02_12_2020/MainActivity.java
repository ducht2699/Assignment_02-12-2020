package com.example.assignment_02_12_2020;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    List<Email> emailList = new ArrayList<Email> (   );
    List<Integer> colorList = new ArrayList<Integer>( );

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);


        int id = getResources().getColor(R.color.red);
        colorList.add(id);
        id = getResources().getColor(R.color.orange);
        colorList.add(id);
        id = getResources().getColor(R.color.yellow);
        colorList.add(id);
        id = getResources().getColor(R.color.cyan);
        colorList.add(id);
        id = getResources().getColor(R.color.green);
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

        EmailAdapter adapter = new EmailAdapter(emailList, this, colorList);

        ListView rv = findViewById(R.id.rv_emails);
        rv.setAdapter(adapter);
    }


    private void init() {

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                selectedItemDrawer(item);
                return true;
            }
        });
    }
    private void selectedItemDrawer(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_all:
                setTitle("ALL INBOXES");

                break;
            case R.id.menu_star:
                setTitle("STARRED");

                break;

        }

        item.setChecked(true);

        drawerLayout.closeDrawers();
    }

}