package com.globant.testdatabinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.globant.testdatabinding.BR;
import com.globant.testdatabinding.R;
import com.globant.testdatabinding.model.User;
import com.globant.testdatabinding.utils.ItemViewHolder;

import java.util.List;

/**
 * Created by zadtankus on 28/02/16.
 */
public class RecyclerAdapter  extends RecyclerView.Adapter<ItemViewHolder>{

    private List<User> arrayUser;

    public RecyclerAdapter(List<User> arrayUser) {
        this.arrayUser = arrayUser;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding mvdb = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item,parent,false);
        return new ItemViewHolder(mvdb);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.getmBinding().setVariable(BR.item, arrayUser.get(position));
    }

    @Override
    public int getItemCount() {
        return null != arrayUser?arrayUser.size():0;
    }
}
