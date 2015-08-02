package com.example.recepinanc.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Recepinanc on 01.08.2015.
 */
public class CrimeListFragment extends ListFragment {

    private ArrayList<Crime> mCrimes;
    private static final String TAG = "CrimeListFragment";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);

        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
        Log.d(TAG, c.getTitle() + " was clicked");

        Intent intent = new Intent(getActivity(),CrimePagerActivity.class);
        intent.putExtra(CrimeFragment.EXTRA_CRIME_ID,c.getId());
        startActivity(intent);
    }

    private class CrimeAdapter extends ArrayAdapter<Crime> {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
            {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime,null);  //fragment inflate etme host activity'de gerçekleþtiði için hangi fragment'ýn layout'unun
                                                                                                        // inflate edileceðini bulmak için get activity ve o activity'nin LayoutInflater'ý alýnýr
            }

            Crime c = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);  //host class'ýn onCreate methodunun override ediliþinde "converView" kýmsýný yazmaya gerek yoktur.
            titleTextView.setText(c.getTitle());                                                              // Fragment classý bu özelliðe sahip deðildir.
            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getDate().toString());
            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());

            return convertView;
        }

        public CrimeAdapter(ArrayList<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }
    }
}
