package com.globant.testdatabinding.viewmodel;

import android.app.Service;
import android.databinding.BaseObservable;
import android.util.Log;
import android.view.View;

import com.globant.testdatabinding.adapter.RecyclerAdapter;
import com.globant.testdatabinding.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zadtankus on 28/02/16.
 */
public class FormViewModel extends BaseObservable {
    private static final String TAG = FormViewModel.class.getSimpleName();

    private RecyclerAdapter mAdapter;
    private String name;
    private String phone;
    private String email;

    public FormViewModel(RecyclerAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    public View.OnClickListener onClickButton(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Log.d(TAG,"CLICK");
                if(mAdapter.getArrayUser() != null){
                    Log.d(TAG,"CLICK 2");
                    mAdapter.addItem(setUser());
                    notifyChange();
                }

            }
        };
    }

    public RecyclerAdapter getmAdapter() {
        return mAdapter;
    }

    public String getName() {
        Log.d(TAG,"GETIN NAME");
        return name;
    }

    public String getPhone() {
        Log.d(TAG,"GETIN NAME 2");
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public User setUser(){
        return new User(getName(),getPhone(),getEmail());
    }

}
