package com.example.recepinanc.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Recepinanc on 01.08.2015.
 */
public class CrimeLab {

    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext){
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();

        for(int i = 1; i <= 100; i++)
        {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }

    }

    public ArrayList<Crime> getCrimes()
    {
        return mCrimes;
    }

    public Crime getCrime(UUID id)
    {
        for(Crime c : mCrimes){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    public static CrimeLab get(Context c){ // we set it static bec. we want everybody to access it
        if(sCrimeLab == null)
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        return sCrimeLab;
    }


}
