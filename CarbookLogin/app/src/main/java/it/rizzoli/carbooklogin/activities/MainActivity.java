package it.rizzoli.carbooklogin.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import it.rizzoli.carbooklogin.fragments.AddFragment;
import it.rizzoli.carbooklogin.fragments.HomeFragment;
import it.rizzoli.carbooklogin.fragments.NotificationFragment;
import it.rizzoli.carbooklogin.fragments.ProfileFragment;
import it.rizzoli.carbooklogin.fragments.SearchFragment;
import it.rizzoli.carbooklogin.R;

public class MainActivity extends AppCompatActivity {


    ProfileFragment profileFrag = null;
    NotificationFragment notifFrag = null;
    AddFragment addFrag = null;
    SearchFragment searchFrag = null;
    HomeFragment homeFrag = null;

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        profileFrag = new ProfileFragment();
        notifFrag = new NotificationFragment();
        homeFrag = new HomeFragment();
        searchFrag = new SearchFragment();
        addFrag = new AddFragment();
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        openFragment(homeFrag);
                        return true;
                    case R.id.navigation_search:
                        openFragment(searchFrag);
                        return true;
                    case R.id.navigation_notifications:
                        openFragment(notifFrag);
                        return true;
                    case R.id.navigation_user:
                        openFragment(profileFrag);
                        return true;
                    case R.id.navigation_add:
                        openFragment(addFrag);
                        return true;
                }
                return false;
            }
        });

        openFragment(homeFrag);
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }






}
