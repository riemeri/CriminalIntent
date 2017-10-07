package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by ianri on 10/7/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
