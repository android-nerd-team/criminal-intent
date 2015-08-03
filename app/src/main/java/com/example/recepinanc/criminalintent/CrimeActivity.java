package com.example.recepinanc.criminalintent;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class CrimeActivity extends FragmentActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private CrimeFragment crimeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        crimeFragment = new CrimeFragment();

        // Adds Fragment
        fragmentTransaction.add(R.id.fragmentContainer, crimeFragment)
                .show(crimeFragment)
                .commit();
    }
}
