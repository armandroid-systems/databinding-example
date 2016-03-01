package com.globant.testdatabinding.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.globant.testdatabinding.R;
import com.globant.testdatabinding.adapter.RecyclerAdapter;
import com.globant.testdatabinding.databinding.FragmentMainBinding;
import com.globant.testdatabinding.model.User;
import com.globant.testdatabinding.viewmodel.FormViewModel;

import java.util.ArrayList;

/**
 * Created by zadtankus on 28/02/16.
 */
public class FragmentMain extends BaseFragment {
    private static final String TAG = FragmentMain.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentMain = inflater.inflate(R.layout.fragment_main,container, false);
        FormViewModel mViewModel = new FormViewModel(new RecyclerAdapter(new ArrayList<User>()));

        FragmentMainBinding fragmentBinding = DataBindingUtil.bind(fragmentMain);
        fragmentBinding.setForm(mViewModel);

        fragmentBinding.contacts.setLayoutManager(new LinearLayoutManager(getContext()));
       // fragmentBinding.contacts.setAdapter(mViewModel.getmAdapter());

        return fragmentMain;
    }
}
