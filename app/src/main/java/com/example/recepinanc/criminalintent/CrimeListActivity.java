package com.example.recepinanc.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Recepinanc on 01.08.2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
