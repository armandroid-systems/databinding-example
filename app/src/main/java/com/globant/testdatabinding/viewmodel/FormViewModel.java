package com.globant.testdatabinding.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.globant.testdatabinding.BR;
import com.globant.testdatabinding.R;
import com.globant.testdatabinding.adapter.RecyclerAdapter;
import com.globant.testdatabinding.model.User;


/**
 * Created by zadtankus on 28/02/16.
 */
public class FormViewModel extends BaseObservable {
    private static final String TAG = FormViewModel.class.getSimpleName();

    private RecyclerAdapter mAdapter;
    public   String name = "";
    public  String phone = "";
    public  String email = "";

    public FormViewModel(RecyclerAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Bindable
    public String getError(){
        if(name.isEmpty() || phone.isEmpty() || email.isEmpty()){
            return "THE FIELD CANNOT BE EMPTY";
        }
        return null;
    }

    public View.OnClickListener onClickButton(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Log.d(TAG,"CLICK");
                if(mAdapter.getArrayUser() != null){
                    Log.d(TAG,"CLICK 2"+name);
                    mAdapter.addItem(setUser());
                    clearFields();
                    notifyChange();
                }

            }
        };
    }

    public RecyclerAdapter getmAdapter() {
        return mAdapter;
    }

    public User setUser(){
        return new User(name,phone, email);
    }
    public EditText.OnFocusChangeListener getFocusListener(){
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    notifyPropertyChanged(BR.error);
                }
            }
        };
    }

    @BindingAdapter("app:binding")
    public static void alternative(final EditText v, final FormViewModel a){
        v.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                switch(v.getId()){
                    case R.id.editTextName:
                        a.name = s.toString();
                        break;
                    case R.id.editTextPhone:
                        a.phone = s.toString();
                        break;
                    case R.id.editTextMail:
                        a.email = s.toString();
                        break;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void clearFields(){
        name = "";
        phone = "";
        email = "";
    }
}
