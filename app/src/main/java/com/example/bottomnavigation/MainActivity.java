package com.example.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
    private void initialize(){

        loadFragment(new FragmentHome()); // ekran ilk açıldıpında frament yüklüyor.

        BottomNavigationView navigation = findViewById(R.id.navigation_bar);
        navigation.setOnNavigationItemSelectedListener(this); //menü itemlerine listener atadır, thisle işaret ediyor


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
Fragment fragment = null ;

        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                fragment = new FragmentHome();
                break;
            case R.id.navigation_profile:
                fragment = new FragmentProfile();
                break;
            case R.id.navigation_notifications:
                fragment = new FragmentNotifications();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment !=null){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment_layout,fragment); // layouttaki fragmentta yoksa direkt benim attığım fragmenti atacak varsa benim yolladığımla yer değiştiricek
            transaction.commit();//transaction işleminin bittiğini gösterir

            return true;
        }
        return false ;
    }





}
