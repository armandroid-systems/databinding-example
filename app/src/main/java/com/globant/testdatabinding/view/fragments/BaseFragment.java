package com.globant.testdatabinding.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.globant.testdatabinding.utils.Constants;

/**
 * Created by zadtankus on 28/02/16.
 */
public class BaseFragment extends Fragment {

    protected Object mParam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        if(getArguments() != null){
            mParam = getArguments().get(Constants.KEY_PARAM);
        }
        super.onCreate(savedInstanceState);
    }
}
