package com.codecoy.caribbean.fragments.shop_view;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.codecoy.caribbean.R;
import com.codecoy.caribbean.data_model.MenuItem;
import com.codecoy.caribbean.data_model.Shop;
import com.codecoy.caribbean.databinding.FragmentDelicaciesBinding;
import com.codecoy.caribbean.databinding.FragmentDirectoryBinding;
import com.codecoy.caribbean.listeners.OnMenuItemLoadListeners;
import com.codecoy.caribbean.repository.Repository;
import com.codecoy.caribbean.util.DialogBuilder;


public class Directory extends Fragment {

    FragmentDirectoryBinding mDataBinding;
    private Shop shop;
    public Directory() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            shop=getArguments().getParcelable("shop");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            mDataBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_directory, container, false);
        ProgressDialog loading= DialogBuilder.getSimpleLoadingDialog(getContext(),"Loading","Please wait for server response . . .");
        loading.setCanceledOnTouchOutside(false);
        loading.show();

        Repository.getShopDirectory(shop.getId(), new OnMenuItemLoadListeners() {
                @Override
                public void onMenuLoaded(MenuItem itemList) {
                    Glide.with(getContext()).load(itemList.getImageUri()).into(mDataBinding.directoryImage);
                    loading.dismiss();
                }

                @Override
                public void onEmpty() {
                    mDataBinding.directoryMsg.setVisibility(View.VISIBLE);
                    loading.dismiss();
                }

                @Override
                public void onFailure(String e) {
                    mDataBinding.directoryMsg.setVisibility(View.VISIBLE);
                    mDataBinding.directoryMsg.setText("Error "+e);
                    loading.dismiss();

                }
            });
            return mDataBinding.getRoot();
    }
}