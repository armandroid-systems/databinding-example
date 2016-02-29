package com.globant.testdatabinding.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.globant.testdatabinding.R;
import com.globant.testdatabinding.utils.Constants;
import com.globant.testdatabinding.utils.ScreenManager;
import com.globant.testdatabinding.view.fragments.FragmentMain;

public class MainActivity extends AppCompatActivity {
    private static final String TAG =MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.screenWrapper)!= null){
            if(savedInstanceState == null){
                try {
                    ScreenManager.screenChange(MainActivity.this,
                            R.id.screenWrapper,
                            FragmentMain.class,null,
                            Constants.VIEW_SUMMARY,
                            Constants.BIN_TRUE);
                } catch (IllegalAccessException e) {
                    Log.e(TAG,"ERROR "+e);
                } catch (InstantiationException e) {
                    Log.e(TAG, "ERROR " + e);
                }
            }
        }
    }
}
