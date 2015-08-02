package com.example.recepinanc.criminalintent;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import java.util.UUID;


public class CrimeActivity extends SingleFragmentActivity {     //Extending the SingleFragmentActivity class saved us from a lot typing
                                                                //and since it used this createFragment method in its(SingleFragmentActivity's) own implementation
                                                                //we are able to change which fragment will be created by our BlahBlahActivity.java file by allowing us to implement this createFragment()

    @Override
    protected Fragment createFragment() {

        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);

        return CrimeFragment.newInstance(crimeId);

    }

}
