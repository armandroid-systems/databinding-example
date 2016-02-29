package com.globant.testdatabinding.utils;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by zadtankus on 28/02/16.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder{

    private ViewDataBinding mBinding;

    public ItemViewHolder(ViewDataBinding mBinding) {
        super(mBinding.getRoot());
        this.mBinding = mBinding;
        this.mBinding.executePendingBindings();
    }

    public ViewDataBinding getmBinding() {
        return mBinding;
    }
}
