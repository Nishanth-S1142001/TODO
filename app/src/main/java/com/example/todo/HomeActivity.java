package com.example.todo;

import static com.example.todo.R.id.*;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageButton navToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        System.out.println("Start of Home Activity");
        setContentView(R.layout.activity_home);


        toolbar= (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navToggle= (ImageButton) findViewById(nav_toggle) ;
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

            navigationView.setCheckedItem(R.id.nav_home);

        }
        navToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.open();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                int itemId=menuItem.getItemId();
                if(itemId == nav_home)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                }
                if(itemId == nav_dummy)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DummyFragment()).commit();
                }

                else if(itemId == nav_settings)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SettingsFragment()).commit();
                }
                else if(itemId == nav_about)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
                }
                else if(itemId == nav_share)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareFragment()).commit();
                }
                if(itemId == nav_calendar)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CalendarFragment()).commit();
                }
                else if(itemId == logOut)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LogOutFragment()).commit();
                }
                drawerLayout.close();
                return false;
            }
        });
    }
}


